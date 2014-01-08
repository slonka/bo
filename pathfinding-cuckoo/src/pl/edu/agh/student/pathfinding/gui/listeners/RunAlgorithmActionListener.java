package pl.edu.agh.student.pathfinding.gui.listeners;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;

import pl.edu.agh.student.pathfinding.RandomPathGenerator;
import pl.edu.agh.student.pathfinding.SmartSolutionModifier;
import pl.edu.agh.student.pathfinding.Solution;
import pl.edu.agh.student.pathfinding.gui.AlgorithmData;
import pl.edu.agh.student.pathfinding.gui.components.RightPanel;
import pl.edu.agh.student.pathfinding.gui.exception.InvalidAlgorithmParameterValueException;
import pl.edu.agh.student.pathfinding.map.BitmapMap;
import pl.edu.agh.student.pathfinding.map.IMap;
import pl.edu.agh.student.pathfinding.solver.CuckooSolver;
import pl.edu.agh.student.pathfinding.solver.DijkstraSolver;
import pl.edu.agh.student.pathfinding.util.SolutionImageBuilder;

public class RunAlgorithmActionListener implements ActionListener {

	private AlgorithmData data;
	private RightPanel rightPanel;

	public RunAlgorithmActionListener(AlgorithmData data, JPanel rightPanel) {
		this.data = data;
		this.rightPanel = (RightPanel) rightPanel;
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
		SmartSolutionModifier solutionModifier = new SmartSolutionModifier();
				
		int maxGeneration = 10;
		int nests = 10;
		double pa = 0.5;
		try {
			maxGeneration = data.getMaxGeneration();
			pa = data.getCuckooDyingProbability();
			nests = data.getInitialNestAmount();
		} catch (InvalidAlgorithmParameterValueException e) {
			e.printStackTrace();
			return;
		}
		
		CuckooSolver solver = new CuckooSolver(randomPathGenerator, solutionModifier, nests, maxGeneration , pa);
		DijkstraSolver dijkstraSolver = new DijkstraSolver(map);
		
		long start = System.nanoTime();
		Solution dijkstraSolution = dijkstraSolver.solve();
		long end = System.nanoTime();
		long time = end - start;
		System.out.println("Dijkstra:");
		double dTime = ((int)time / 1E3)  / 1E6;
		System.out.println("sekundy:" + dTime);
		System.out.println("Koszt: " + dijkstraSolution.f());
		
		start = System.nanoTime();
		Solution solution = solver.solve();
		end = System.nanoTime();
		time = end - start;
		System.out.println("Cuckoo \t");
		double cTime = ((int)time / 1E3)  / 1E6;
		System.out.println("sekundy:" + cTime);
		System.out.println("Koszt: " + solution.f());
		
		
		rightPanel.updateData(dTime, dijkstraSolution.f(), cTime, solution.f());
		
		SolutionImageBuilder builder = new SolutionImageBuilder();
		builder.addSolution(solution, 0xFFFF0000);
		builder.addSolution(dijkstraSolution, 0xFF00FF00);
		Image generateImage = builder.build();
		//generateImage = SolutionImageBuilder.generateImage(solution, trackColor)
		data.setMap(generateImage);
	}

}
