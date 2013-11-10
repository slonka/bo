package pl.edu.agh.student.pathfinding.gui.components;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import pl.edu.agh.student.pathfinding.gui.AlgorithmData;
import pl.edu.agh.student.pathfinding.gui.MainFrame;
import pl.edu.agh.student.pathfinding.gui.listeners.LoadMapFileActionListener;
import pl.edu.agh.student.pathfinding.gui.listeners.RunAlgorithmActionListener;

public class BottomPanel extends JPanel {

	private static final long serialVersionUID = -6994642304985929956L;

	private JPanel buttonsPanel = new JPanel();
	private JButton loadButton = new JButton();
	private JButton runAlgorithmButton = new JButton();

	private JPanel parametersPanel = new JPanel();

	private MainFrame parentMainFrame;
	
	public BottomPanel(MainFrame parentMainFrame) {
		this.parentMainFrame = parentMainFrame;
		setLayout(new GridLayout());
		initComponents();
	}

	private void initComponents() {

		// buttons
		createLoadButton();
		createRunAlgorithmButton();
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
		buttonsPanel.add(loadButton);
		buttonsPanel.add(runAlgorithmButton);
		
		// parameters
		parametersPanel.setLayout(new BoxLayout(parametersPanel, BoxLayout.Y_AXIS));
		parametersPanel.add(new ParameterFieldPanel("Initial Nests (n):", AlgorithmData.NESTS, parentMainFrame.getAlgorithmData()));
		parametersPanel.add(new ParameterFieldPanel("Dying Probability (Pa):", AlgorithmData.DYING_PROBABLITY, parentMainFrame.getAlgorithmData()));
		parametersPanel.add(new ParameterFieldPanel("Max Generation: (MG)", AlgorithmData.MAX_GENERATION, parentMainFrame.getAlgorithmData()));

		add(buttonsPanel);
		add(parametersPanel);
	}

	private void createRunAlgorithmButton() {
		runAlgorithmButton.setText("Run algorithm");
		runAlgorithmButton.addActionListener(new RunAlgorithmActionListener(parentMainFrame.getAlgorithmData()));
	}

	private void createLoadButton() {
		loadButton.setText("Choose map file");
		loadButton.addActionListener(new LoadMapFileActionListener(this, parentMainFrame.getAlgorithmData()));
	}

}
