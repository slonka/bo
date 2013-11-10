package pl.edu.agh.student.pathfinding.gui;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class AlgorithmData extends Observable {

	private File mapFile;
	private Map<String, Double> parameters = new HashMap<String, Double>();
	
	public static String DYING_PROBABLITY = "dying";
	public static String NESTS = "nests";
	public static String MAX_GENERATION = "max_gen";
	
	public AlgorithmData() {
		
	}

	public void setMapFile(File mapFile) {
		this.mapFile = mapFile;
		setChanged();
		notifyObservers(mapFile);
	}
	
	public void addParameter(String name, Double value) {
		parameters.put(name, value);
	}

	public File getMapFile() {
		return mapFile;
	}
	
	public Integer getInitialNestAmount() {
		return parameters.get(NESTS).intValue();
	}
	
	public Integer getMaxGeneration() {
		return parameters.get(MAX_GENERATION).intValue();
	}
	
	public Double getCuckooDyingProbability() {
		return parameters.get(DYING_PROBABLITY);
	}
	
	
}
