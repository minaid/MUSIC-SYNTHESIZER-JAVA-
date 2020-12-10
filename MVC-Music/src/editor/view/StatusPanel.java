package editor.view;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StatusPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JTextField modeTextField;
	private JTextField outTextField;
    private String mode;
	private String out;

	public StatusPanel(){
		this.add(createStatus());
	}
	
    /****************************************************************
     * Create Status
     ***************************************************************/
    private JPanel createStatus(){
        JPanel p= new JPanel();
        //p.setBackground(Color.GREEN);
        JLabel modeLabel= new JLabel("Mode:");
        p.add(modeLabel);
        modeTextField= new JTextField(10);
        modeTextField.setEditable(false);
        p.add(modeTextField);
        
        outTextField= new JTextField(50);
        outTextField.setEditable(false);
        p.add(outTextField);
        p.setBorder(BorderFactory.createLoweredBevelBorder());
        return p;
    }
    
    public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
		modeTextField.setText(mode);
	}    
	public String getOut() {
		return out;
	}

	public void setOut(String out) {
		this.out = out;
		outTextField.setText(out);
	}    
}
