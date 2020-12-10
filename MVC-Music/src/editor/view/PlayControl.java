package editor.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class PlayControl extends JPanel {
	private static final long serialVersionUID = 1L;
	private JToggleButton toggleButton;
	
	public PlayControl(){
		setBackground(Color.ORANGE);
		ImageIcon playIcon = createImageIcon("images/Button-Stop-icon.png");
		ImageIcon stopIcon = createImageIcon("images/Button-Play-icon.png");
		toggleButton = new JToggleButton(stopIcon);
		toggleButton.setSelectedIcon(playIcon);
		toggleButton.setPreferredSize(new Dimension(32, 32));

		add(toggleButton);
		setOpaque(true);
	}
	
	public void addItemListener(ItemListener il){
		toggleButton.addItemListener(il);
	}


	// Returns just the class name -- no package info.
	protected String getClassName(Object o) {
		String classString = o.getClass().getName();
		int dotIndex = classString.lastIndexOf(".");
		return classString.substring(dotIndex + 1);
	}

	/** Returns an ImageIcon, or null if the path was invalid. */
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = TopPanel.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
}
