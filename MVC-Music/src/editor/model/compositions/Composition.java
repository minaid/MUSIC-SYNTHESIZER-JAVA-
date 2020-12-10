package editor.model.compositions;

import java.util.List;


abstract class Composition {
	String compositionName;
	String composer;
	
	List<String> noteList;
	
	public Composition(CompositionMode mode) {
		this.mode = mode;
		arrangeParts();
	}

	private void arrangeParts() {
		// Do one time processing here
	}

	// Do subclass level processing in this method
	protected abstract void construct();
	private CompositionMode mode = null;

	public CompositionMode getMode() {
		return mode;
	}

	public void setModel(CompositionMode mode) {
		this.mode = mode;
	}
}
