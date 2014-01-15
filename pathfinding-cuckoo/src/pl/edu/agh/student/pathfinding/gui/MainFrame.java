package pl.edu.agh.student.pathfinding.gui;

import java.awt.Dimension;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import org.jdesktop.layout.GroupLayout;

import pl.edu.agh.student.pathfinding.gui.components.BottomPanel;
import pl.edu.agh.student.pathfinding.gui.components.ImagePanel;
import pl.edu.agh.student.pathfinding.gui.components.RightPanel;

public class MainFrame extends JFrame implements Observer {

	private static final long serialVersionUID = -2255435257331955721L;
	
	private ImagePanel mainMapPanel;
	private JPanel rightPanel;
	private BottomPanel bottomPanel;
	private AlgorithmData algorithmData;

	public MainFrame() {
		initComponents();
	}

	private void initComponents() {

		algorithmData = new AlgorithmData();
		algorithmData.addObserver(this);
		
		getAccessibleContext().setAccessibleName("Cuckoo - Pathfinding");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Cuckoo - Pathfinding");
		setPreferredSize(new Dimension(800, 620));
		
		mainMapPanel = new ImagePanel(580, 470);
		rightPanel = new RightPanel(190, 470);
		
		bottomPanel = new BottomPanel(this);
	
		buildFrameView();
		pack();
	}

	// code generated by NetBeans Matisse, do not touch
	private void buildFrameView() {
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.LEADING).add(
				layout.createSequentialGroup()
						.addContainerGap()
						.add(layout
								.createParallelGroup(GroupLayout.LEADING)
								.add(bottomPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.add(layout.createSequentialGroup()
										.add(mainMapPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
										.add(rightPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.LEADING).add(
				layout.createSequentialGroup()
						.addContainerGap()
						.add(layout.createParallelGroup(GroupLayout.LEADING)
								.add(rightPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.add(mainMapPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.add(bottomPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE).addContainerGap()));
	}

	@Override
	public void update(Observable o, Object arg) {
		Image image = (Image) arg;
		this.mainMapPanel.setImage(image);
		repaint();
	}

	public AlgorithmData getAlgorithmData() {
		return algorithmData;
	}

	public JPanel getRightPanel() {
		return rightPanel;
	}
	
}
