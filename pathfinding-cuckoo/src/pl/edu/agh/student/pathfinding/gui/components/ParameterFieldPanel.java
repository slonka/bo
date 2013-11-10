package pl.edu.agh.student.pathfinding.gui.components;

import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ParameterFieldPanel extends JPanel {

	private static final long serialVersionUID = -120581466722298810L;
	
	private JTextField textField;
	private String textFieldValue;
	private JLabel label;
	
	public ParameterFieldPanel(String labelText, String name) {
		initComponents(labelText, name);
		setLayout(new GridLayout(1,2));
		this.add(label);
		this.add(textField);
	}

	private void initComponents(String labelText, String name) {
		this.label = new JLabel(labelText);
		this.textField = new JTextField();
		textField.setName(name);
		textField.addFocusListener(new FocusAdapter() {
		
			@Override
			public void focusLost(FocusEvent arg0) {
				setTextFieldValue(textField.getText());
			}
			
		});
	}

	public String getTextFieldValue() {
		return textFieldValue;
	}

	public void setTextFieldValue(String textFieldValue) {
		this.textFieldValue = textFieldValue;
	}
	
}
