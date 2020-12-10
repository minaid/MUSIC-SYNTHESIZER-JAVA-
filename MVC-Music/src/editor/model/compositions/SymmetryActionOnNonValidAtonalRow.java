package editor.model.compositions;

/**
 * Exception, thrown when symmetry actions are executed
 * over atonal rows that contain duplicate or not all the 12 notes
 *
 * @author Panagiotis Papadakos <papadako@gmail.com>
 */
public class SymmetryActionOnNonValidAtonalRow extends Exception {
	private static final long serialVersionUID = 1L;
    //Parameterless Constructor
	public SymmetryActionOnNonValidAtonalRow() {
    }

    //Constructor that accepts a message
    public SymmetryActionOnNonValidAtonalRow(String message) {
        super(message);
    }

    public SymmetryActionOnNonValidAtonalRow(Throwable cause) {
        super(cause);
    }

    public SymmetryActionOnNonValidAtonalRow(String message, Throwable cause) {
        super(message, cause);
    }
}
