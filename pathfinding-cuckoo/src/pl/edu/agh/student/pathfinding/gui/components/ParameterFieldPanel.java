package pl.edu.agh.student.pathfinding.gui.components;

import java.awt.GridLayout;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pl.edu.agh.student.pathfinding.gui.AlgorithmData;

public class ParameterFieldPanel extends JPanel  {

	private static final long serialVersionUID = -120581466722298810L;
		
	private JTextField textField;
	private String textFieldValue;
	private JLabel label;

	private AlgorithmData algorithmData;
	
	public ParameterFieldPanel(String labelText, String name, AlgorithmData data) {
		this.algorithmData = data;
		initComponents(labelText, name);
		setLayout(new GridLayout(1,2));
		this.add(label);
		this.add(getTextField());
	}

	private void initComponents(String labelText, String name) {
		this.label = new JLabel(labelText);
		this.setTextField(new JTextField());
		getTextField().setName(name);
		getTextField().addFocusListener(new ParameterFieldFocusListener(getTextField(), algorithmData));
	}

	public String getTextFieldValue() {
		return textFieldValue;
	}

	public void setTextFieldValue(String textFieldValue) {
		this.textFieldValue = textFieldValue;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	
}
