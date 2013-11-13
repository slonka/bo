package pl.edu.agh.student.pathfinding.util;

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;

import pl.edu.agh.student.pathfinding.Solution;

public class SolutionImageBuilder {
	
	private static final int DEFAULT_PATH_COLOR = 0xFFFF0000;
	private BufferedImage image;
	
	public void addSolution(Solution solution, int pathColor) {
		if(image == null) {
			image = solution.getMap().getMapImage();
		} else if(image.getWidth() != solution.getMap().getWidth() || image.getHeight() != solution.getMap().getHeight()) {
			throw new IllegalArgumentException("Size of solution's map does not match builder's map size.");
		}
		
		for(Point p : solution.getSteps()) {
			image.setRGB(p.x, p.y, pathColor);
		}
	}
	
	public void addSolution(Solution solution) {
		addSolution(solution, DEFAULT_PATH_COLOR);
	}

	public Image build() {
		return image;
	}

}
