package edu.ucv;

class FromEndPoint extends EndPoint {

	FromEndPoint(double value) {
		super(value);
	}

	boolean onLeft(double value) {
		return this.getValue() < value;
	}

	boolean onLeft(FromEndPoint that) {
		if (this.getValue() > that.getValue()) {
			return false;
		}
		if (this.getValue() == that.getValue() && that instanceof FromIncludedEndPoint) {
			return false;
		}
		return true;
	}

}
