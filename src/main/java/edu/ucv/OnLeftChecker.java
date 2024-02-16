package edu.ucv;

public class OnLeftChecker implements FromEndPointVisitor {

	private boolean result;
	
	public OnLeftChecker(FromEndPoint included) {
		included.accept(this);
	}
	
	public boolean onLeft() {
		return result;
	}
	
	@Override
	public void visit(FromEndPoint included) {
		result = true; 
	}
	
	@Override
	public void visit(FromIncludedEndPoint included) {
		result = false; 
	}

}
