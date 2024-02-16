package edu.ucv;

class UntilEndPoint extends EndPoint {

	UntilEndPoint(double value, Mode mode) {
		super(value, mode);
	}

	boolean onRight(UntilEndPoint that) {
		if (this.getValue() > that.getValue()) {
			return true;
		}
		if (this.getValue() == that.getValue()) {
			return this.getMode().includes(that.getMode());
		}
		return false;
	}

}
