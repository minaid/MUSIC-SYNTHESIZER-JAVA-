package editor.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import editor.controller.EditorController.DeleteButtonListener;


public class NotesList extends JPanel implements ListSelectionListener{
	private static final long serialVersionUID = 1L;
	private JList<String> list;
    public JList<String> getList() {return list;}

	private static final String addCommand= "Add";
    private static final String delCommand= "Delete";
    private static final String upCommand = "Up";
    private static final String dnCommand = "Down";
 
    private JButton addButton;
    private JButton deleteButton;
    private JButton upButton;
    private JButton downButton;
 
    private JTextField nameField;
    public JTextField getNameField() {return nameField;}

    
	public NotesList(){
		super(new BorderLayout());
		setBorder(BorderFactory.createEtchedBorder());
        //Create the list and put it in a scroll pane.
        list = new JList<String>();
        
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);
        JScrollPane listScrollPane = new JScrollPane(list);
        
        //Create the list-modifying buttons.
        addButton = new JButton("Add");
        addButton.setActionCommand(addCommand);
         
        deleteButton = new JButton("Del");
        deleteButton.setActionCommand(delCommand);    
         
        upButton = new JButton("Up");
        upButton.setToolTipText("Move the currently selected list item higher.");
        upButton.setActionCommand(upCommand);
         
        downButton = new JButton("Dn");
        downButton.setToolTipText("Move the currently selected list item lower.");
        downButton.setActionCommand(dnCommand);
         
        JPanel addDelPanel = new JPanel(new GridLayout(2, 1));
        addDelPanel.add(addButton);
        addDelPanel.add(deleteButton);
        
        JPanel upDownPanel = new JPanel(new GridLayout(2, 1));
        upDownPanel.add(upButton);
        upDownPanel.add(downButton);
 
        //Create the text field for entering new names.
        nameField = new JTextField(15);
        nameField.setText("");
 
        //Create a control panel, using the default FlowLayout.
        JPanel buttonPane = new JPanel();
        buttonPane.add(nameField);
        buttonPane.add(addDelPanel);
        buttonPane.add(upDownPanel);
 
        //Put everything together.
        add(buttonPane, BorderLayout.PAGE_START);
        add(listScrollPane, BorderLayout.CENTER);		
		
	}
	
  
    //Listener method for list selection changes.
    public void valueChanged(ListSelectionEvent e) {
        if(e.getValueIsAdjusting() == false) {
            if(list.getSelectedIndex() == -1) {
            	//No selection: disable delete, up, and down buttons.
                deleteButton.setEnabled(false);
                upButton.setEnabled(false);
                downButton.setEnabled(false);
                addButton.setEnabled(true);
                nameField.setText("");
            }else if (list.getSelectedIndices().length > 1) {
            	//Multiple selection: disable up and down buttons.
            	addButton.setEnabled(false);
                deleteButton.setEnabled(true);
                upButton.setEnabled(false);
                downButton.setEnabled(false);
            }else{
            	//Single selection: permit all operations.
            	addButton.setEnabled(true);
                deleteButton.setEnabled(true);
                upButton.setEnabled(true);
                downButton.setEnabled(true);
                nameField.setText(list.getSelectedValue().toString());
            }
        }
    }
    
   

	public void addNote(String s){
		nameField.setText(s);
		addButton.doClick();
	}
	
	public void setAddEnabled(boolean v){
		addButton.setEnabled(v);
	}
	
	public void setDelEnabled(boolean v){
		deleteButton.setEnabled(v);
	}
	
	public void setUpDnEnabled(boolean v){
		upButton.setEnabled(v);
		downButton.setEnabled(v);
	}
	
	public void addButtonListener(ActionListener l){
		addButton.addActionListener(l);
		nameField.addActionListener(l);
	}
	
	public void DeleteButtonListener(ActionListener l){
		deleteButton.addActionListener(l);
	}
	
	public void addUpDnListener(ActionListener l){
		upButton.addActionListener(l);
		downButton.addActionListener(l);
	}
	
	public void setListModel(DefaultListModel<String> model){
		list.setModel(model);
	}
}
