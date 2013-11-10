package pl.edu.agh.student.pathfinding.gui;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class AlgorithmData extends Observable {

	private BufferedImage map;
	private Map<String, Double> parameters = new HashMap<String, Double>();
	
	public AlgorithmData() {
		
	}

	public void setMap(BufferedImage map) {
		this.map = map;
		setChanged();
		notifyObservers(map);
	}
	
	public void addParameter(String name, Double value) {
		parameters.put(name, value);
	}

	public BufferedImage getMap() {
		return map;
	}
	
	public Map<String, Double> getParameters() {
		return parameters;
	}
	
}
