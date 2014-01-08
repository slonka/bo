package pl.edu.agh.student.pathfinding;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.math.*;

import pl.edu.agh.student.pathfinding.map.IMap;

public class SmartSolutionModifier implements ISolutionModifier {
	private Random r = new Random();
	private IMap map;

	private Point whereToGo(double degree) {
		if (degree >= -157.5 && degree < -112.5) {
			return new Point(-1, -1);
		} else if (degree >= -112.5 && degree < -67.5) {
			return new Point(0, -1);
		} else if (degree >= -67.5 && degree < -22.5) {
			return new Point(1, -1);
		} else if (degree >= -22.5 && degree < 22.5) {
			return new Point(1, 0);
		} else if (degree >= 22.5 && degree < 67.5) {
			return new Point(1, 1);
		} else if (degree >= 67.5 && degree < 112.5) {
			return new Point(0, 1);
		} else if (degree >= 112.5 && degree < 157.5) {
			return new Point(-1, 1);
		} else if (degree >= 157.5) {
			return new Point(-1, 0);
		} else if (degree <= -157.5) {
			return new Point(-1, 0);
		} else {
			throw new IllegalStateException(
					"Degree should be between [-180, 180]; degree: " + degree);
		}
	}

	public boolean cutSolution(Solution s) {
		if(map == null) {
			map = s.getMap();
		}
		
		int i = 0;
		int j = 0;
		
		while(Math.abs(i-j) < 2) {
			i = r.nextInt(s.getSteps().size());
			j = r.nextInt(s.getSteps().size());
		}

		ArrayList<Point> steps = (ArrayList<Point>) s.getSteps();
		List<Point> plaster = new ArrayList<Point>();

		if (j < i) {
			int tmp = i;
			i = j;
			j = tmp;
		}

		// i<=j

		int startX = steps.get(i).x;
		int startY = steps.get(i).y;

		int stopX = steps.get(j).x;
		int stopY = steps.get(j).y;

		int currentX = startX, currentY = startY;
		
		Point move;
		
		while (currentX != stopX && currentY != stopY) {
			double deg = Math.toDegrees(Math.atan2(stopY - currentY, stopX - currentX));
			move = whereToGo(deg); 
			move.x = currentX + move.x;
			move.y = currentY + move.y;
			
			if(move.x < 0 || move.y < 0) {
				throw new IllegalStateException("Something went wrong");
			}
			
			if( map.isAccessible(move) ) {
				plaster.add(move);
			}
			else {
				return false;
			}
			
			// made a move change current position
			currentX = move.x;
			currentY = move.y;
		}
		
		// cut out of steps
		steps.subList(i+1, j).clear();
		
		// paste plaster
		steps.addAll(i+1, plaster);
		
		return true;
	}

	@Override
	public Solution modify(Solution solution) {
		Solution newSolution = solution.getCopy();
		map = newSolution.getMap();
		
		if(cutSolution(newSolution)) {
			return newSolution;
		} else {
			return solution;
		}
	}

}
