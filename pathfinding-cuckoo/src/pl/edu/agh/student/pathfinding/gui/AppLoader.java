package pl.edu.agh.student.pathfinding.gui;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class AppLoader {

	public static String LOOK_AND_FEEL = "Nimbus";
	
	public static void main(String args[]) {
		
		setLookAndFeel();

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainFrame().setVisible(true);
			}
		});
		
	}

	private static void setLookAndFeel() {
		try {
			LookAndFeelInfo[] installedLookAndFeels = UIManager.getInstalledLookAndFeels();
			for (int idx = 0; idx < installedLookAndFeels.length; idx++)
				if (LOOK_AND_FEEL.equals(installedLookAndFeels[idx].getName())) {
					UIManager.setLookAndFeel(installedLookAndFeels[idx].getClassName());
					break;
				}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
}
