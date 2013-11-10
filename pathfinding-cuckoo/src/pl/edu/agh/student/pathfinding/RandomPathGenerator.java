package pl.edu.agh.student.pathfinding;

import java.awt.Point;

import pl.edu.agh.student.pathfinding.map.IMap;

public class RandomPathGenerator implements IPathGenerator{
	
	private IMap map;
	
	private Point startingPoint;
	
	private Point endingPoint;
	
	public RandomPathGenerator(IMap map){
		this.map = map;
		this.startingPoint = map.getStartingPoint();
		this.endingPoint = map.getFinishPoint();
	}

	@Override
	public Solution getSolution() {
		Solution newSolution = new Solution(map);
		
		return newSolution;
	}

}
