package pl.edu.agh.student.pathfinding.gui.panels;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import org.jdesktop.layout.GroupLayout;

public class ImagePanel extends JPanel {

	private Image img;

	private static final long serialVersionUID = 4187065896799463284L;

	public ImagePanel() {
		
		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.LEADING).add(0, 580, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.LEADING).add(0, 470, Short.MAX_VALUE));

		setBorder(BorderFactory.createEtchedBorder());
	}
	
	public ImagePanel(String img) {
		this(new ImageIcon(img).getImage());
	}

	public ImagePanel(Image img) {
		this();
		this.img = img;
	}

	public void setImage(Image image) {
		img = image;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (img != null) g.drawImage(img, 0, 0, null);
	}
}