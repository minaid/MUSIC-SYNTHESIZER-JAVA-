package editor;

import editor.controller.EditorController;
import editor.model.EditorModel;
import editor.view.EditorView;

public class EditorMVC {
    public static void main(String[] args) {
        EditorView  theView = new EditorView();
        EditorModel theModel= new EditorModel();
        //EditorController theController = 
        new EditorController(theView, theModel);
        theView.setVisible(true);
    }
}
