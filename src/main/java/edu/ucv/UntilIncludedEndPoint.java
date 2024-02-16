package edu.ucv;

class UntilIncludedEndPoint extends UntilEndPoint {

	UntilIncludedEndPoint(double value) {
		super(value);
	}

	boolean onRight(double value) {
		return super.onRight(value) || value == this.getValue();
	}
	
	boolean onRight(UntilEndPoint that) {
		return this.getValue() >= that.getValue();
	}

}
