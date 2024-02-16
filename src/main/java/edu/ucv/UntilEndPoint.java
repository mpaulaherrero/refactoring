package edu.ucv;

class UntilEndPoint extends EndPoint {

	UntilEndPoint(double value) {
		super(value);
	}

	boolean onRight(double value) {
		return value < this.getValue();
	}

	boolean onRight(UntilEndPoint that) {
		if (this.getValue() < that.getValue()) {
			return false;
		}
		if (this.getValue() == that.getValue() && that instanceof UntilIncludedEndPoint) {
			return false;
		}
		return true;
	}

}
