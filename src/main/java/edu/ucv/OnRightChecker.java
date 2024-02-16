package edu.ucv;

public class OnRightChecker implements UntilEndPointVisitor {

	private boolean result;
	
	public OnRightChecker(UntilEndPoint included) {
		included.accept(this);
	}
	
	public boolean onRight() {
		return result;
	}
	
	@Override
	public void visit(UntilEndPoint included) {
		result = true; 
	}
	
	@Override
	public void visit(UntilIncludedEndPoint included) {
		result = false; 
	}
}
