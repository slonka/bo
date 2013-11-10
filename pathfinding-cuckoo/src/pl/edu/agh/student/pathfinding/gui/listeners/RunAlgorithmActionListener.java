package pl.edu.agh.student.pathfinding.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import pl.edu.agh.student.pathfinding.gui.AlgorithmData;

public class RunAlgorithmActionListener implements ActionListener {

	private AlgorithmData data;

	public RunAlgorithmActionListener(AlgorithmData data) {
		this.data = data;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		File mapFile = data.getMapFile();
		
	}

}
