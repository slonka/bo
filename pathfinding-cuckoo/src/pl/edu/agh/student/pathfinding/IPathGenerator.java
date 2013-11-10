package pl.edu.agh.student.pathfinding;

import java.awt.Point;

public interface IPathGenerator {
	
	public Solution getSolution(Point startingPoint, Point endingPoint);

}
