package edu.ucv;

public class OnLeftChecker {

	private FromEndPoint included;
	
	public OnLeftChecker(FromEndPoint included) {
		super();
		this.included = included;
	}
	
	public boolean onLeft() {
		return !(included instanceof FromIncludedEndPoint);
	}

}
