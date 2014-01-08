package pl.edu.agh.student.pathfinding.gui.components;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jdesktop.layout.GroupLayout;

public class RightPanel extends JPanel {

	public JLabel djikstraTimeLabel, cuckcooTimeLabel;
	
	public RightPanel(int width, int height) {
		super();
		
		djikstraTimeLabel = new JLabel("Czas djikstra: ");
		cuckcooTimeLabel = new JLabel("Czas cuckoo: ");
		
		this.add(djikstraTimeLabel);
		this.add(cuckcooTimeLabel);
		
		GroupLayout jPanel2Layout = new GroupLayout(this);
		this.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.LEADING).add(0, width,
				Short.MAX_VALUE));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.LEADING).add(0, height,
				Short.MAX_VALUE));
	}
}
