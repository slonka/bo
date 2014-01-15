package pl.edu.agh.student.pathfinding.gui.components;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RightPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public JLabel djikstraTimeLabel, cuckcooTimeLabel;
	public JTextField djikstraTime, cuckooTime;
	public JLabel djikstraCostLabel, cuckooCostLabel;
	public JTextField djikstraCost, cuckooCost;
	public JLabel algIterationText;
	public JTextField algIterationValue;
	
	public RightPanel(int width, int height) {
		super();
		
		this.setBorder(BorderFactory.createEtchedBorder());
		
		djikstraTimeLabel = new JLabel("Djikstra time: ");
		cuckcooTimeLabel = new JLabel("Cuckoo time: ");
		djikstraCostLabel = new JLabel("Dijkstra cost: ");
		cuckooCostLabel = new JLabel("Cuckoo cost: ");
		
		djikstraTime = new JTextField();
		djikstraTime.setEditable(false);
		cuckooTime = new JTextField();
		cuckooTime.setEditable(false);
		
		djikstraCost = new JTextField();
		djikstraCost.setEditable(false);
		cuckooCost = new JTextField();
		cuckooCost.setEditable(false);
		
		algIterationText = new JLabel("Algoritm iteration:");
		algIterationValue = new JTextField();
		algIterationValue.setEditable(false);
		
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
		
		add(algIterationText);
		add(algIterationValue);
				
		this.setPreferredSize(new Dimension(width, height));
		
	}

	public void updateData(double dTime, int dCost, double cTime, int cCost, int iteration) {
		djikstraCost.setText(new Integer(dCost).toString());
		cuckooCost.setText(new Integer(cCost).toString());
		djikstraTime.setText(new Double(dTime).toString()+"s");
		cuckooTime.setText(new Double(cTime).toString()+"s");
		algIterationValue.setText(new Integer(iteration).toString());
		repaint();
	}
}
