package editor.model.compositions;


public class AtonalComposition extends Composition implements Symmetry {

	AtonalComposition() {
		super(CompositionMode.ATONAL);
		construct();
	}
	
	@Override
	protected void construct() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void doNothing() throws SymmetryActionOnNonValidAtonalRow {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transpose(int x) throws SymmetryActionOnNonValidAtonalRow {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void retrograde() throws SymmetryActionOnNonValidAtonalRow {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reflect(int x) throws SymmetryActionOnNonValidAtonalRow {
		// TODO Auto-generated method stub
		
	}




}
