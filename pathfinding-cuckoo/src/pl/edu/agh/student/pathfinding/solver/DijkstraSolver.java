package pl.edu.agh.student.pathfinding.solver;

import java.awt.Point;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import pl.edu.agh.student.pathfinding.Solution;
import pl.edu.agh.student.pathfinding.map.IMap;

/**
 * Shortest path solver. An implementation of the Dijkstra's Algorithm.
 * @author Marek Mateja
 */
public class DijkstraSolver implements ISolver {
	
	private class PointDistanceComparator implements Comparator<Point> {

		@Override
		public int compare(Point arg0, Point arg1) {
			if(distances[arg0.x][arg0.y] < distances[arg1.x][arg1.y]) {
				return -1;
			} if(distances[arg0.x][arg0.y] > distances[arg1.x][arg1.y]) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	
	private enum Direction {
		N(0, -1),
		NE(1, -1),
		E(1, 0),
		SE(1, 1),
		S(0, 1),
		SW(-1, 1),
		W(-1, 0),
		NW(-1, -1);
		
		private int x;
		private int y;
		
		private Direction(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public Point move(Point p) {
			return new Point(p.x + x, p.y + y);
		}
	}
	
	private IMap map;
	private PriorityQueue<Point> queue;
	private int[][] distances;
	private Point[][] predecessors;
	
	public DijkstraSolver(IMap map) {
		this.map = map;
		queue = new PriorityQueue<>(map.getWidth() * map.getHeight(), new PointDistanceComparator());
		distances = new int[map.getWidth()][map.getHeight()];
		predecessors = new Point[map.getWidth()][map.getHeight()];
		
		initializeQueueAndTable();
	}
	
	private void initializeQueueAndTable() {
		for(int i=0; i<map.getWidth(); i++) {
			for(int j=0; j<map.getHeight(); j++) {
				if(i == map.getStartingPoint().x && j == map.getStartingPoint().y) {
					queue.add(new Point(i, j));
					distances[i][j] = 0;
				} else {
					queue.add(new Point(i, j));
					distances[i][j] = Integer.MAX_VALUE;
				}
			}
		}
	}

	@Override
	public Solution solve() {
		dijkstraAlgorithm();
		return computeSolution();
	}

	private void dijkstraAlgorithm() {
		while(!queue.isEmpty()) {
			Point current = queue.poll();
			for(Direction direction : Direction.values()) {
				Point neighbour = direction.move(current);
				if(outOfBounds(neighbour)){
					continue;
				}
				if(distances[neighbour.x][neighbour.y] > distances[current.x][current.y] + map.getCost(current) + 1) {
					distances[neighbour.x][neighbour.y] = distances[current.x][current.y] + map.getCost(current) + 1;
					predecessors[neighbour.x][neighbour.y] = current;
					queue.add(neighbour);
				}
			}
		}
	}
	
	private boolean outOfBounds(Point neighbour) {
		return neighbour.x < 0 || neighbour.x >= map.getWidth() || neighbour.y < 0 || neighbour.y >= map.getHeight();
	}

	public FutureTask<Solution> getSolverTask() {
		FutureTask<Solution> t = new FutureTask<Solution>(new Callable<Solution>() {

			@Override
			public Solution call() throws Exception {
				return solve();
			}

		});
		t.run();
		return t;
	}
	
	private Solution computeSolution() {
		Deque<Point> pathBreadcrumb = new LinkedList<>();
		Point current = map.getFinishPoint();
		while(!current.equals(map.getStartingPoint())) {
			pathBreadcrumb.add(current);
			current = predecessors[current.x][current.y];
		}
		pathBreadcrumb.add(current);
		
		Solution solution = new Solution(map);
		while(!pathBreadcrumb.isEmpty()) {
			solution.addStep(pathBreadcrumb.pop());
		}
		return solution;
	}

}
