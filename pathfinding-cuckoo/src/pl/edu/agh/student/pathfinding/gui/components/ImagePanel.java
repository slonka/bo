package pl.edu.agh.student.pathfinding.gui.components;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.jdesktop.layout.GroupLayout;

public class ImagePanel extends JPanel {

	private Image img;

	private static final long serialVersionUID = 4187065896799463284L;

	public ImagePanel(int width, int height) {
		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.LEADING).add(0, width, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.LEADING).add(0, height, Short.MAX_VALUE));
		
		setBorder(BorderFactory.createEtchedBorder());
	}
	
	public void setImage(Image image) {
		img = image;
		img = img.getScaledInstance(400, 400, Image.SCALE_DEFAULT);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (img != null) g.drawImage(img, 0, 0, null);
	}
}