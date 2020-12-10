package editor.view;
/********************************************************************
 *  This is the View
 *  Its only job is to display what the user sees
 *  It performs no calculations, but instead passes the
 *  information entered by the user to whomever needs it.
 ********************************************************************/

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
 
public class EditorView extends JFrame{
	private static final long serialVersionUID = 1L;
	public TopPanel editorPanel;
	public PlayControl playControl;
	public StatusPanel editorStatus;
	public NotesList notesList;
    public Xylophone xylophone;
    
    public EditorView(){
    	// Sets up the view and adds the components
    	this.setTitle("Music Editor");
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setSize(950, 500);
        
    	editorPanel= new TopPanel();	this.add(editorPanel);
    	playControl= new PlayControl();
    	editorStatus= new StatusPanel();
    	notesList= new NotesList();
    	xylophone = new Xylophone();
    	
    	editorPanel.add(playControl, BorderLayout.BEFORE_FIRST_LINE);
    	editorPanel.add(xylophone, BorderLayout.WEST);
    	editorPanel.add(notesList, BorderLayout.EAST);
    	editorPanel.add(editorStatus, BorderLayout.AFTER_LAST_LINE);
    	// End of setting up the components --------
    }
    
    public void createMenuBar(ActionListener a){
    	this.setJMenuBar(editorPanel.createMenuBar(a));
    }
    
    public ListSelectionModel getListSelectionModel(){
    	return notesList.getList().getSelectionModel();
    }
    

    // Open a popup that contains the error message passed
    public void displayErrorMessage(String errorMessage){
    	JOptionPane.showMessageDialog(this, errorMessage);
    }
}
