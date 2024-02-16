package edu.ucv;

class FromIncludedEndPoint extends FromEndPoint {

	FromIncludedEndPoint(double value, boolean closed) {
		super(value, closed);
	}

	boolean onLeft(double value) {
		return super.onLeft(value) || this.getValue() == value;
	}

	boolean onLeft(FromEndPoint that) {
		return this.getValue() <= that.getValue();
	}
}
