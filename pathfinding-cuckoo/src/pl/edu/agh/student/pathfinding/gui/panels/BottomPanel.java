package pl.edu.agh.student.pathfinding.gui.panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import pl.edu.agh.student.pathfinding.gui.MainFrame;
import pl.edu.agh.student.pathfinding.gui.listeners.RunAlgorithmActionListener;

public class BottomPanel extends JPanel {

	private JButton loadButton;
	private JButton runAlgorithmButton;

	private MainFrame mainFrame;
	private JPanel parameterTextFieldsPanel;
	private List<JTextField> parameters = new ArrayList<JTextField>();
	private JPanel buttonsPanel;

	public BottomPanel(MainFrame parentMainFrame) {
		mainFrame = parentMainFrame;
		initBottomPanel();
	}

	private void initBottomPanel() {
		GridLayout gridLayout = new GridLayout();
		setLayout(new GridLayout());

		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(gridLayout);
		gridLayout.setColumns(2);
		gridLayout.setRows(2);
		gridLayout.setHgap(1);
		gridLayout.setVgap(1);
		createLoadButton();
		createRunAlgorithmButton();
		buttonsPanel.add(loadButton);
		buttonsPanel.add(runAlgorithmButton);

		buttonsPanel.add(new JButton("nic nie robie"));
		buttonsPanel.add(new JButton("ja tez"));

		parameterTextFieldsPanel = new JPanel();
		BorderLayout gridLayout2 = new BorderLayout();
		parameterTextFieldsPanel.setLayout(gridLayout2);
		addParameterFieldToPanel(parameterTextFieldsPanel, "     Initial Nests (n):");
		addParameterFieldToPanel(parameterTextFieldsPanel, "     Dying Probability (Pa):");
		addParameterFieldToPanel(parameterTextFieldsPanel, "     Max Generation: (MG)");

		add(buttonsPanel);
		add(parameterTextFieldsPanel);
	}

	private void createRunAlgorithmButton() {
		runAlgorithmButton = new JButton("Run algorithm");

		Map<String, Double> map = new HashMap<String, Double>();
		for (JTextField t : parameters)
			map.put(t.getName(), Double.parseDouble(t.getText()));
		
		runAlgorithmButton.addActionListener(new RunAlgorithmActionListener(mainFrame.getAlgorithmData()));
	}

	private void addParameterFieldToPanel(JPanel parameterTextFields, String string) {
		JLabel jLabel = new JLabel(string);
		jLabel.setAlignmentX(LEFT_ALIGNMENT);
		parameterTextFields.add(jLabel, BorderLayout.AFTER_LAST_LINE);
		JTextField textField = new JTextField();
		textField.setName(string);
		parameters.add(textField);
		parameterTextFields.add(textField);
	}

	private void createLoadButton() {
		loadButton = new JButton();
		loadButton.setText("Choose map file");
		loadButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();
				FileFilter fileFilter = new FileFilter() {
					private final String[] okFileExtensions = new String[] { "jpg", "png", "gif", "bmp" };

					@Override
					public String getDescription() {
						return "Image files";
					}

					@Override
					public boolean accept(File file) {
						for (String extension : okFileExtensions) {
							if (file.getName().toLowerCase().endsWith(extension)) {
								return true;
							}
						}
						return false;
					}
				};

				fc.setFileFilter(fileFilter);
				int returnVal = fc.showOpenDialog(BottomPanel.this);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					try {
						BufferedImage image = ImageIO.read(file);
						mainFrame.getAlgorithmData().setMap(image);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		});
	}

}
