package pl.edu.agh.student.pathfinding.gui;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// nie pamietam co chcialam z tym zrobic, na razie nvm
public class AlgorithmLoader {

	private BufferedImage map;
	private Map<String, Double> parameters = new HashMap<String, Double>();

	private List<BufferedImage> solutions; // albo cos takiego, zobaczymy
	
	public AlgorithmLoader() {

	}

	public void setMap(BufferedImage map) {
		this.map = map;
	}
	
	public void addParameter(String name, Double value) {
		parameters.put(name, value);
	}
	
	public BufferedImage runAlgorithm() {	// albo void i pobieramy rozwiazania z algorithm loadera
		return null;						// skoro Solution jest po prostu list� punkt�w, mo�na stworzy� mechanizm nak�adaj�cy Solution na Map ;]
	}
	
}
