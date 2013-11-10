package pl.edu.agh.student.pathfinding.gui;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import pl.edu.agh.student.pathfinding.gui.exception.InvalidAlgorithmParameterValueException;

public class AlgorithmData extends Observable {

	private File mapFile;
	private Map<String, String> parameters = new HashMap<String, String>();

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

	public void addParameter(String name, String value) {
		parameters.put(name, value);
	}

	public File getMapFile() {
		return mapFile;
	}

	public Integer getInitialNestAmount() throws InvalidAlgorithmParameterValueException {
		String value = parameters.get(NESTS);
		Integer nests;

		if (value == null)
			throw new InvalidAlgorithmParameterValueException("Initial nests amount must be given.");

		try {
			nests = Integer.parseInt(value);
			if (nests < 0)
				throw new InvalidAlgorithmParameterValueException("Initial nests amount cannot be negative.");

		} catch (NumberFormatException e) {
			throw new InvalidAlgorithmParameterValueException("Invalid initial nests amount.");
		}
		return nests;
	}

	public Integer getMaxGeneration() throws InvalidAlgorithmParameterValueException {
		String value = parameters.get(MAX_GENERATION);
		Integer maxGeneration;

		if (value == null)
			throw new InvalidAlgorithmParameterValueException("Max generations amount cannot must be given.");
		try {

			maxGeneration = Integer.parseInt(value);
			if (maxGeneration < 0)
				throw new InvalidAlgorithmParameterValueException("Max generations amount cannot be negative.");

		} catch (NumberFormatException e) {
			throw new InvalidAlgorithmParameterValueException("Invalid max generations amount.");
		}

		return maxGeneration;
	}

	public Double getCuckooDyingProbability() throws InvalidAlgorithmParameterValueException {
		String value = parameters.get(DYING_PROBABLITY);
		double dying;

		if (value == null) {
			throw new InvalidAlgorithmParameterValueException("Cuckoo dying probability must be given.");
		}
		
		try {
			dying = Double.parseDouble(value);

			if (!(dying > 0.0 && dying < 1.0)) {
				throw new InvalidAlgorithmParameterValueException("Cuckoo dying probability must be a number between 0.0 and 1.0.");
			}
			
		} catch (NumberFormatException e) {
			throw new InvalidAlgorithmParameterValueException("Invalid dying probability amount.");
		}
		return dying;
	}

}
