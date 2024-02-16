package edu.ucv;

class UntilIncludedEndPoint extends UntilEndPoint {

	UntilIncludedEndPoint(double value) {
		super(value);
		this.mode = new Closed();
	}

	boolean onRight(double value) {
		return super.onRight(value) || value == this.getValue();
	}

}
