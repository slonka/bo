package pl.edu.agh.student.pathfinding.map;

import java.awt.Point;
import java.awt.image.BufferedImage;

public class FakeMap implements IMap {
	public Point startingPoint, finishPoint;
	public BitmapMap realMap; 
	
	FakeMap(BitmapMap realMap, Point startingPoint, Point finishPoint) {
		this.realMap = realMap;
		this.startingPoint = startingPoint;
		this.finishPoint = finishPoint;
	}
	
	@Override
	public Point getStartingPoint() {
		return startingPoint;
	}

	@Override
	public Point getFinishPoint() {
		return finishPoint;
	}

	@Override
	public int getWidth() {
		return realMap.getWidth();
	}

	@Override
	public int getHeight() {
		return realMap.getHeight();
	}

	@Override
	public boolean isAccessible(Point point) {
		return realMap.isAccessible(point);
	}

	@Override
	public int getCost(Point point) {
		return realMap.getCost(point);
	}

	@Override
	public BufferedImage getMapImage() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
