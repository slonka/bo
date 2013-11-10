package pl.edu.agh.student.pathfinding;

import java.util.List;
import java.awt.Point;
import java.util.ArrayList;

import pl.edu.agh.student.pathfinding.map.*;

public class Solution {
	private List<Point> steps = new ArrayList<Point>();
	private IMap map;
	
	public Solution(IMap map) {
		this.map = map;
	}
	
	
	int f() {
		int res = 0;
		for(Point p : steps) {
			res += map.getCost(p);
		}
		
		return res;
	}
	
	public void addStep(Point step){
		this.steps.add(step);
	}
	
	public void removeStep(Point step){
		this.steps.remove(step);
	}
	
	public boolean wasVisited(Point step){
		return this.steps.contains(step);
	}
	
	public Point getLast(){
		return this.steps.get(this.steps.size() - 1);
	}
}
