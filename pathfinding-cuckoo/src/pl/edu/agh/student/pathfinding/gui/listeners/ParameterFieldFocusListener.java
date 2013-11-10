package pl.edu.agh.student.pathfinding.gui.listeners;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JTextField;

import pl.edu.agh.student.pathfinding.gui.AlgorithmData;

public class ParameterFieldFocusListener extends FocusAdapter {

	private final JTextField textField;
	private AlgorithmData algorithmData;


	public ParameterFieldFocusListener(JTextField textField, AlgorithmData algorithmData) {
		this.textField = textField;
		this.algorithmData = algorithmData;
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		algorithmData.addParameter(textField.getName(), textField.getText());
	}
}