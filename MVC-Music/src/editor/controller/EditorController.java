package editor.controller;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.ListSelectionModel;

import jfugue.MusicEngine;
import editor.model.EditorModel;
import editor.view.EditorView;
	 
/********************************************************************
 * The Controller coordinates interactions
 * between the View and Model
 *
 ********************************************************************/
	 
public class EditorController {
    private EditorView  theView;
    private EditorModel theModel;
	     
    public EditorController(EditorView theView, EditorModel theModel) {
        this.theView = theView;
        this.theModel= theModel;
        theView.notesList.getList().setModel(theModel.getListModel());
        // Tell the View about the ActionListeners
        theView.createMenuBar(new MenuListener());
        theView.xylophone.addNotesListener(new NotesActionListener());
        theView.notesList.addButtonListener(new AddButtonListener());
        theView.notesList.DeleteButtonListener(new DeleteButtonListener());
        theView.notesList.addUpDnListener(new UpDownListener());
        theView.playControl.addItemListener(new PlayControlListener());
    }
	     
    class MenuListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            JMenuItem source = (JMenuItem)(e.getSource());
            String action= source.getActionCommand();
            if(action=="Piano" )    {pianoAction();}
            if(action=="Guitar" )   {guitarAction();}
            if(action=="Flute" )    {fluteAction();}
            
            if(action=="Free" )     {freeAction();}
            if(action=="Atonal" )   {atonalAction();}
            if(action=="Algorithm" ){algorithmAction();}
            
            if(action=="Open" )     {openAction();}
            if(action=="Save" )     {saveAction();}
            if(action=="SaveAs" )   {saveAsAction();}
            if(action=="Quit" )     {System.exit(0);}
        }
    }
    
	//===============================================================
	class NotesActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
	        JButton source = (JButton)(e.getSource());
	        String action= source.getActionCommand();
	        if(action=="DO" )     {theView.notesList.addNote("C");}
	        if(action=="DO2" )    {theView.notesList.addNote("C#");}
	        if(action=="RE" )     {theView.notesList.addNote("D");}
	        if(action=="RE2" )    {theView.notesList.addNote("D#");}
	        if(action=="MI" )     {theView.notesList.addNote("E");}
	        if(action=="FA" )     {theView.notesList.addNote("F");}
	        if(action=="FA2" )    {theView.notesList.addNote("F#");}
	        if(action=="SOL" )    {theView.notesList.addNote("G");}
	        if(action=="SOL2" )   {theView.notesList.addNote("G#");}
	        if(action=="LA" )     {theView.notesList.addNote("A");}
	        if(action=="LA2" )    {theView.notesList.addNote("A#");}
	        if(action=="SI" )     {theView.notesList.addNote("B");}
	        
		}
	}
	
	class OperationsActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
	        JButton source = (JButton)(e.getSource());
	        String action= source.getActionCommand();
	        if(action=="DoNothing" )	{doNothingAction();}
	        if(action=="retrograde" )	{retrogradeAction();}
	        if(action=="transpose" )	{transposeAction();}
		}
		
	}
	
	//===============================================================
	class PlayControlListener implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				startPlayAction();
			} else {
				stopPlayAction();
			}
		}
		
	}
	
	//===============================================================
    public class DeleteButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            /*
             * This method can be called only if there's a valid selection,
             * so go ahead and remove whatever's selected.
             */
            ListSelectionModel lsm = theView.notesList.getList().getSelectionModel();
            int firstSelected= lsm.getMinSelectionIndex();
            int lastSelected = lsm.getMaxSelectionIndex();
            theModel.getListModel().removeRange(firstSelected, lastSelected);
            int size = theModel.getListModel().size();
 
            if (size == 0) {
            	//List is empty: disable delete, up, and down buttons.
            	theView.notesList.setDelEnabled(false);
            	theView.notesList.setUpDnEnabled(false);
            } else {
            	//Adjust the selection.
                if (firstSelected == theModel.getListModel().getSize()) {
                //Removed item was in last position.
                    firstSelected--;
                }
                theView.notesList.getList().setSelectedIndex(firstSelected);
            }
        }
    }
	
    /** A listener shared by the text field and add button. */
    class AddButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(theView.notesList.getNameField().getText().equals("")) {
            	//User didn't type in a name...
                Toolkit.getDefaultToolkit().beep();
                return;
            }
            int index= theView.notesList.getList().getSelectedIndex();
            int size = theModel.getListModel().getSize();

            if(index == -1 || (index+1 == size)) {
                //If no selection or if item in last position is selected,
                //add the new one to end of list, and select new one.
            	theModel.getListModel().addElement(theView.notesList.getNameField().getText());
            	theView.notesList.getList().setSelectedIndex(size);
            }else{
                //Otherwise insert the new one after the current selection,
                //and select new one.
            	theModel.getListModel().insertElementAt(theView.notesList.getNameField().getText(), index+1);
                theView.notesList.getList().setSelectedIndex(index+1);
            }
        }
    }
 
    //Listen for clicks on the up and down arrow buttons.============
    class UpDownListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //This method can be called only when
            //there's a valid selection,
            //so go ahead and move the list item.
            int moveMe = theView.notesList.getList().getSelectedIndex();
 
            if (e.getActionCommand().equals("Up")) {
            	//UP ARROW BUTTON
                if (moveMe != 0) {    
                	//not already at top
                	theModel.swap(moveMe, moveMe-1);
                    theView.notesList.getList().setSelectedIndex(moveMe-1);
                    theView.notesList.getList().ensureIndexIsVisible(moveMe-1);
                }
            } else {
            	//DOWN ARROW BUTTON
                if (moveMe != theModel.getListModel().getSize()-1) {
                	//not already at bottom
                	theModel.swap(moveMe, moveMe+1);
                    theView.notesList.getList().setSelectedIndex(moveMe+1);
                    theView.notesList.getList().ensureIndexIsVisible(moveMe+1);
                }
            }
        }
    }
	
	
	//===============================================================
	void pianoAction(){
		theView.notesList.addNote("I[Piano]");
	}
	
	void guitarAction(){
		theView.notesList.addNote("I[Guitar]");
	}
	
	void fluteAction(){
		theView.notesList.addNote("I[Flute]");
	}
	
	//===============================================================
	void freeAction(){
		theView.editorStatus.setMode("Free");
	}
	
	void atonalAction(){
		theView.editorStatus.setMode("Atonal");
	}
	
	void algorithmAction(){
		theView.editorStatus.setMode("Algorithm");
	}
	
	//===============================================================
	void startPlayAction(){
		theView.editorStatus.setOut("Playing");
		MusicEngine.getInstance().startThread(theModel.getMusic());
	}
	
	void stopPlayAction(){
		theView.editorStatus.setOut("Stopped");
		MusicEngine.getInstance().stopThread();
	}
	//===============================================================
	void doNothingAction(){
		
	}
	void retrogradeAction(){
		
	}
	void transposeAction(){
		
	}
	void reflectionAction(){
		
	}
	
	//===============================================================
	void openAction(){
		String of= theView.editorPanel.openFile();
		if(of.length()>1){
			theModel.readFile(of);
			theModel.currentFile= of;
		}
	}
	
	void saveAction(){
		theModel.writeFile(theModel.currentFile);
	}
	
	void saveAsAction(){
		String s= theView.editorPanel.saveAsFile();
		if(s.length()>1){
			theModel.writeFile(s);
			theModel.currentFile= s;
		}
	}
}
