package edu.ucv;

public class Open extends Mode implements ModeVisitor {

	@Override
	public boolean includes(Mode mode) {
		return mode.accept(this);
	}

	@Override
	public boolean accept(ModeVisitor modeVisitor) {
		return modeVisitor.visit(this);
	}

	@Override
	public boolean visit(Open open) {
		return true;
	}

	@Override
	public boolean visit(Closed closed) {
		return false;
	}

}
