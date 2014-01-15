package pl.edu.agh.student.pathfinding.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import pl.edu.agh.student.pathfinding.gui.AlgorithmData;
import pl.edu.agh.student.pathfinding.gui.components.BottomPanel;

public final class LoadMapFileActionListener implements ActionListener {
	
	private final AlgorithmData algorithmData;

	public LoadMapFileActionListener(BottomPanel bottomPanel, AlgorithmData algorithmData) {
		this.algorithmData = algorithmData;
	}
	
	@Override
	public void actionPerformed(ActionEvent action) {
		JFileChooser fileChooser = new JFileChooser();
		File dir = new File("maps");
		fileChooser.setCurrentDirectory(dir);
		FileFilter fileFilter = new FileFilter() {
			private final String[] okFileExtensions = new String[] { "jpg", "png", "gif", "bmp" };

			@Override
			public String getDescription() {
				return "Image files";
			}

			@Override
			public boolean accept(File file) {
				if (file.isDirectory())
					return true;
				
				for (String extension : okFileExtensions) {
					if (file.getName().toLowerCase().endsWith(extension)) {
						return true;
					}
				}
				return false;
			}
		};

		fileChooser.setFileFilter(fileFilter);
		int returnVal = fileChooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			algorithmData.setMapFile(file);
		}
	}
}