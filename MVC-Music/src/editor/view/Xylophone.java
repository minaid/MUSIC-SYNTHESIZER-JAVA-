package editor.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Xylophone extends JPanel {
	private static final long serialVersionUID = 1L;
	//Notes Buttons
	private JButton noteDO;		//do
	private JButton noteDO2;	//do#
	private JButton noteRE;		//re
	private JButton noteRE2;	//re#
	private JButton noteMI;		//mi
	private JButton noteFA;		//fa
	private JButton noteFA2;	//fa#
	private JButton noteSOL;	//sol
	private JButton noteSOL2;	//sol#
	private JButton noteLA;		//la
	private JButton noteLA2;	//la#
	private JButton noteSI;		//si
	
	//Operations Buttons
	private JButton doNothing;
	private JButton retrograde;
	private JButton transpose;
	private JButton reflection;
	
	public Xylophone(){
		setBorder(BorderFactory.createEtchedBorder());
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(createXylophoneNotes());
		add(createXylophoneOperations());
	}
	
    private JPanel createXylophoneNotes(){
    	JPanel p= new JPanel();
    	p.setBackground(Color.CYAN);
    	JPanel notesPanel = new JPanel(new GridLayout(1, 1));
    	
    	noteDO = new JButton("C "); 
    	noteDO.setActionCommand("DO");
    	notesPanel.add(noteDO);	
    	
    	noteDO2= new JButton("C#"); 
    	noteDO2.setActionCommand("DO2");
    	notesPanel.add(noteDO2);
    	
    	noteRE = new JButton("D "); 
    	noteRE.setActionCommand("RE");
    	notesPanel.add(noteRE);
    	
    	noteRE2= new JButton("D#"); 
    	noteRE2.setActionCommand("RE2");
    	notesPanel.add(noteRE2);
    	
    	noteMI = new JButton("E "); 
    	noteMI.setActionCommand("MI");
    	notesPanel.add(noteMI);
    	
    	noteFA = new JButton("F "); 
    	noteFA.setActionCommand("FA");
    	notesPanel.add(noteFA);	
    	
    	noteFA2= new JButton("F#"); 
    	noteFA2.setActionCommand("FA2");
    	notesPanel.add(noteFA2);
    	
    	noteSOL= new JButton("G "); 
    	noteSOL.setActionCommand("SOL");
    	notesPanel.add(noteSOL);	
    	
    	noteSOL2= new JButton("G#"); 
    	noteSOL2.setActionCommand("SOL2");
    	notesPanel.add(noteSOL2);	
    	
    	noteLA = new JButton("A "); 
    	noteLA.setActionCommand("LA");
    	notesPanel.add(noteLA);	
    	
    	noteLA2= new JButton("A#"); 
    	noteLA2.setActionCommand("LA2");
    	notesPanel.add(noteLA2);
    	
    	noteSI = new JButton("B "); 
    	noteSI.setActionCommand("SI");
    	notesPanel.add(noteSI);		
    	
    	p.add(notesPanel);
    	return p;
    }
    
    private JPanel createXylophoneOperations(){
    	JPanel p= new JPanel();
    	JPanel operPanel = new JPanel(new GridLayout(1, 1));
    	
    	doNothing = new JButton("DoNothing"); 
    	doNothing.setActionCommand("DoNothing");
    	operPanel.add(doNothing);	
    	
    	retrograde = new JButton("Retrograde"); 
    	retrograde.setActionCommand("Retrograde");
    	operPanel.add(retrograde);	
    	
    	transpose = new JButton("Transpose"); 
    	transpose.setActionCommand("Transpose");
    	operPanel.add(transpose);	
    	
    	reflection = new JButton("Reflection"); 
    	reflection.setActionCommand("Reflection");
    	operPanel.add(reflection);	
    	p.add(operPanel);
    	p.setBackground(Color.GREEN);
    	return p;
    }
    
    public void addNotesListener(ActionListener nal){
    	noteDO.addActionListener(nal);
    	noteDO2.addActionListener(nal);
    	noteRE.addActionListener(nal);
    	noteRE2.addActionListener(nal);
    	noteMI.addActionListener(nal);
    	noteFA.addActionListener(nal);
    	noteFA2.addActionListener(nal);
    	noteSOL.addActionListener(nal);
    	noteSOL2.addActionListener(nal);
    	noteLA.addActionListener(nal);
    	noteLA2.addActionListener(nal);
    	noteSI.addActionListener(nal);
    }
    
    
}
