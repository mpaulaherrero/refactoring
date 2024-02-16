package edu.ucv;

class FromIncludedEndPoint extends FromEndPoint {

	FromIncludedEndPoint(double value) {
		super(value);
		this.mode = new Closed();
	}

	boolean onLeft(double value) {
		return super.onLeft(value) || this.getValue() == value;
	}
	
}
