package pl.edu.agh.student.pathfinding;

import java.util.List;
import java.awt.Point;
import java.util.ArrayList;

import pl.edu.agh.student.pathfinding.map.*;

public class Solution {
	List<Point> steps = new ArrayList<Point>();
	
	
	IMap map;
	
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
}
