package pl.edu.agh.student.pathfinding.gui.components;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RightPanel extends JPanel {

	public JLabel djikstraTimeLabel, cuckcooTimeLabel;
	public JTextField djikstraTime, cuckooTime;
	public JLabel djikstraCostLabel, cuckooCostLabel;
	public JTextField djikstraCost, cuckooCost;
	
	public RightPanel(int width, int height) {
		super();
		
		this.setBorder(BorderFactory.createEtchedBorder());
		
		djikstraTimeLabel = new JLabel("Czas djikstra: ");
		cuckcooTimeLabel = new JLabel("Czas cuckoo: ");
		djikstraCostLabel = new JLabel("Koszt dijkstra: ");
		cuckooCostLabel = new JLabel("Koszt cuckoo: ");
		
		djikstraTime = new JTextField();
		djikstraTime.setEditable(false);
		cuckooTime = new JTextField();
		cuckooTime.setEditable(false);
		
		djikstraCost = new JTextField();
		djikstraCost.setEditable(false);
		cuckooCost = new JTextField();
		cuckooCost.setEditable(false);
		
		GridLayout layout = new GridLayout(16, 1);
		setLayout(layout);
		
		add(djikstraTimeLabel);
		add(djikstraTime);
		add(djikstraCostLabel);
		add(djikstraCost);
				
		add(cuckcooTimeLabel);
		add(cuckooTime);
		add(cuckooCostLabel);
		add(cuckooCost);
				
		this.setPreferredSize(new Dimension(width, height));
		
	}
}
