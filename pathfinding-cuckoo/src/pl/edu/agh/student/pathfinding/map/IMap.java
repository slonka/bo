package pl.edu.agh.student.pathfinding.map;

import java.awt.Point;

public interface IMap {
	
	Point getStartingPoint();
	
	Point getFinishPoint();
	
	int getWidth();
	
	int getHeight();
	
	boolean isAccessible(Point point);
	
	int getCost(Point point);
	
}
