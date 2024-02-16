package edu.ucv;

class UntilIncludedEndPoint extends UntilEndPoint {

	UntilIncludedEndPoint(double value) {
		super(value);
		this.mode = new Closed();
	}

}
