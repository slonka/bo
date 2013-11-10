package pl.edu.agh.student.pathfinding.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import pl.edu.agh.student.pathfinding.RandomPathGenerator;
import pl.edu.agh.student.pathfinding.gui.AlgorithmData;
import pl.edu.agh.student.pathfinding.map.BitmapMap;
import pl.edu.agh.student.pathfinding.map.IMap;
import pl.edu.agh.student.pathfinding.util.SolutionImageBuilder;

public class RunAlgorithmActionListener implements ActionListener {

	private AlgorithmData data;

	public RunAlgorithmActionListener(AlgorithmData data) {
		this.data = data;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		File mapFile = data.getMapFile();
		IMap map = null;
		try {
			map = new BitmapMap(mapFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		RandomPathGenerator randomPathGenerator = new RandomPathGenerator(map);
	
		data.setMap(SolutionImageBuilder.generateImage(	randomPathGenerator.getSolution()));
	}

}
