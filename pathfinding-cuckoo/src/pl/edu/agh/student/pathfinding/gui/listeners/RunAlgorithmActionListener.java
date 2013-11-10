package pl.edu.agh.student.pathfinding.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;

import pl.edu.agh.student.pathfinding.gui.AlgorithmData;
import pl.edu.agh.student.pathfinding.gui.exception.InvalidAlgorithmParameterValueException;

public class RunAlgorithmActionListener implements ActionListener {

	private AlgorithmData data;

	public RunAlgorithmActionListener(AlgorithmData data) {
		this.data = data;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		File mapFile = data.getMapFile();
		try {
			System.out.println(data.getCuckooDyingProbability() + "\n"+data.getInitialNestAmount()+"\n"+data.getMaxGeneration());
		} catch (InvalidAlgorithmParameterValueException e) {
			JOptionPane.showMessageDialog(null, "Error: "+e.getMessage()+"   ", "Algorithm info", JOptionPane.ERROR_MESSAGE);
		}
	}

}
