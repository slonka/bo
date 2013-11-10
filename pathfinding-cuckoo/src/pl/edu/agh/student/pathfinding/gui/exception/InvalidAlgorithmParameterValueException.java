package pl.edu.agh.student.pathfinding.gui.exception;

public class InvalidAlgorithmParameterValueException extends Exception {

	private static final long serialVersionUID = -1163346068504631745L;

	public InvalidAlgorithmParameterValueException() {
		super("Invalid algorithm parameter.");
	}
	
	public InvalidAlgorithmParameterValueException(String string) {
		super(string);
	}

		
}
