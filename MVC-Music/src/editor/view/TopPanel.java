package editor.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;

public class TopPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final String dir = "/opt/music/midi";
	private final String fileMask= ".txt";

 
    public TopPanel(){
    	this.setLayout(new BorderLayout());
    }

    public JMenuBar createMenuBar(ActionListener a) {
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;
        JRadioButtonMenuItem rbMenuItem;

        //Create the Menu Bar.
        menuBar = new JMenuBar();

        //Build the Composition Menu.================================
        menu = new JMenu("Composition");
        menu.setMnemonic(KeyEvent.VK_C);
        menu.setToolTipText("Composition Manipulation");
        menuBar.add(menu);

        //JMenuItems for Composition Menu.
        menuItem = new JMenuItem("Open");
        menuItem.setMnemonic(KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.addActionListener(a);
        menu.add(menuItem);

        menuItem = new JMenuItem("New");
        menuItem.setMnemonic(KeyEvent.VK_N);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        menuItem.addActionListener(a);
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Save");
        menuItem.setMnemonic(KeyEvent.VK_S);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK));
        menuItem.addActionListener(a);
        menu.add(menuItem);        

        menuItem = new JMenuItem("SaveAs");
        menuItem.setMnemonic(KeyEvent.VK_V);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, ActionEvent.ALT_MASK));
        menuItem.addActionListener(a);
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Export");
        menuItem.setMnemonic(KeyEvent.VK_E);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5, ActionEvent.ALT_MASK));
        menuItem.addActionListener(a);
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Quit");
        menuItem.setMnemonic(KeyEvent.VK_Q);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_6, ActionEvent.ALT_MASK));
        menuItem.addActionListener(a);
        menu.add(menuItem);
        
        //Build the Instrument Menu.=================================
        menu = new JMenu("Instrument");
        menu.setMnemonic(KeyEvent.VK_I);
        menu.setToolTipText("Instrument Selection");
        menuBar.add(menu);
        
        ButtonGroup instrumentGroup = new ButtonGroup();

        rbMenuItem = new JRadioButtonMenuItem("Piano");
        rbMenuItem.setSelected(true);
        rbMenuItem.setMnemonic(KeyEvent.VK_P);
        instrumentGroup.add(rbMenuItem);
        rbMenuItem.addActionListener(a);
        menu.add(rbMenuItem);

        rbMenuItem = new JRadioButtonMenuItem("Guitar");
        rbMenuItem.setMnemonic(KeyEvent.VK_G);
        instrumentGroup.add(rbMenuItem);
        rbMenuItem.addActionListener(a);
        menu.add(rbMenuItem);        
        
        rbMenuItem = new JRadioButtonMenuItem("Flute");
        rbMenuItem.setMnemonic(KeyEvent.VK_F);
        instrumentGroup.add(rbMenuItem);
        rbMenuItem.addActionListener(a);
        menu.add(rbMenuItem);     
        
        //Build the Mode Menu.=======================================
        menu = new JMenu("Mode");
        menu.setMnemonic(KeyEvent.VK_M);
        menu.setToolTipText("Mode: Free, Atonal, Algorithm");
        menuBar.add(menu);   
        
        ButtonGroup modeGroup = new ButtonGroup();
        
        rbMenuItem = new JRadioButtonMenuItem("Free");
        rbMenuItem.setSelected(true);
        rbMenuItem.setMnemonic(KeyEvent.VK_F);
        modeGroup.add(rbMenuItem);
        rbMenuItem.addActionListener(a);
        //rbMenuItem.addItemListener(a);
        menu.add(rbMenuItem);     
        
        rbMenuItem = new JRadioButtonMenuItem("Atonal");
        rbMenuItem.setMnemonic(KeyEvent.VK_F);
        modeGroup.add(rbMenuItem);
        rbMenuItem.addActionListener(a);
        //rbMenuItem.addItemListener(this);
        menu.add(rbMenuItem);     
        
        rbMenuItem = new JRadioButtonMenuItem("Algorithm");
        rbMenuItem.setMnemonic(KeyEvent.VK_F);
        modeGroup.add(rbMenuItem);
        rbMenuItem.addActionListener(a);
        //rbMenuItem.addItemListener(this);
        menu.add(rbMenuItem);     
        
        
        //Build the Help Menu.=======================================
        menu = new JMenu("Help");
        menu.setMnemonic(KeyEvent.VK_H);
        menu.setToolTipText("Help");
        menuBar.add(menu);        
        
        menuItem = new JMenuItem("About");
        menuItem.setMnemonic(KeyEvent.VK_B);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_9, ActionEvent.ALT_MASK));
        menuItem.addActionListener(a);
        menu.add(menuItem);        

        return menuBar;
    }

    // Returns just the class name -- no package info.
    protected String getClassName(Object o) {
        String classString = o.getClass().getName();
        int dotIndex = classString.lastIndexOf(".");
        return classString.substring(dotIndex+1);
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = TopPanel.class.getResource(path);
        if(imgURL != null) {
            return new ImageIcon(imgURL);
        }else{
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }


	// ==============================================================
	public String openFile() {
		JFileChooser fc = new JFileChooser();
		fc.setAcceptAllFileFilterUsed(false);
		fc.setMultiSelectionEnabled(true);
		fc.setCurrentDirectory(new File(dir));
		fc.setFileFilter(new FileFilter() {
			public boolean accept(File f) {
				boolean accepted = f.getName().toLowerCase().endsWith(fileMask)
						|| f.isDirectory();
				return accepted;
			}

			public String getDescription() {
				return "*.txt (Midi File List )";
			}
		});
		
		if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			if (!file.exists()) {
				return "";
			}else{
				return file.getAbsolutePath();
				//editorText.readFile(openFile);
			}
		}
		return "";
	} 
	
	// ==============================================================
	public String saveAsFile() {
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new File(dir));
		
		fc.setFileFilter(new FileFilter() {
			public boolean accept(File f) {
				boolean accepted = f.getName().toLowerCase().endsWith(fileMask)
						|| f.isDirectory();
				return accepted;
			}

			public String getDescription() {
				return "*.txt (Midi File List )";
			}
		});
		
		if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			if (file.exists()) {
				//"то аявеио дем пяепеи ма упаявеи";
				return "";
			}else if(!file.getName().endsWith(fileMask)){
				//"то аявеио ма текеиымеи ле .txt";
				return "";
			}else{
				return file.getAbsolutePath();
				//editorText.writeFile(saveFile);
			}					
		}
		return "";
	}


}