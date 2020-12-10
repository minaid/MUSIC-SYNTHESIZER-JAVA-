package editor.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Formatter;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.DefaultListModel;
/********************************************************************
 *  The Model performs all the calculations needed
 *  and that is it. It doesn't know the View exists
 ********************************************************************/
	 
public class EditorModel {
    private DefaultListModel<String> listModel;
    public DefaultListModel<String> getListModel() {return listModel;}

	public String currentFile;
    
    public EditorModel(){
    	listModel= new DefaultListModel<String>();
    }
    
	//Swap two Elements in the List.
    public void swap(int a, int b) {
        String aString = listModel.getElementAt(a);
        String bString = listModel.getElementAt(b);
        listModel.set(a, bString);
        listModel.set(b, aString);
    }
    
  //===================================================================    
  	public void readFile(String fileName) {
  		String line;
  		try {
  			listModel.clear();
  			Scanner scanner= new Scanner(new File(fileName));
  			scanner.useDelimiter(System.getProperty("line.separator"));
  			scanner.useLocale(new Locale("en", "US"));
  			while(scanner.hasNext()){
  				line= scanner.next();
  				listModel.addElement(line);
  			}
  			scanner.close();
  		} catch (FileNotFoundException e) {
  			e.printStackTrace();
  		}
  	}
  //===================================================================
  	public void writeFile(String file){
  		try {
  			Locale locale= new Locale("en", "US");
  			Formatter result= new Formatter(file, "ISO8859-7");
  			for(int i=0; i<listModel.getSize(); i++){
  				result.format(locale, "%s\r\n", listModel.elementAt(i));
  			}
  			result.close();
  		} catch (FileNotFoundException e) {
  			e.printStackTrace();
  		} catch (UnsupportedEncodingException e) {
  			e.printStackTrace();
  		}
  	}
  //===================================================================
  	public String getMusic(){
  		StringBuffer sb= new StringBuffer();
  		for(int i=0; i<listModel.getSize(); i++){
  			sb.append(listModel.elementAt(i)+" ");
  		}
  		return sb.toString();
  	}
    

}
