package edu.ucv;

public class Closed extends Mode {

	@Override
	public boolean includes(Mode mode) {
		return true;
	}
	
	@Override
	public boolean accept(ModeVisitor modeVisitor) {
		return modeVisitor.visit(this);
	}

}
