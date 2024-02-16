package edu.ucv;

class UntilEndPoint extends EndPoint {

	UntilEndPoint(double value) {
		super(value);
		this.mode = new Open();
	}

	boolean onRight(double value) {
		return value < this.getValue();
	}

	boolean onRight(UntilEndPoint that) {
		if (this.onRight(that.getValue())) {
			return true;
		}
		if (this.getValue() == that.getValue()) {
			return this.mode.includes(that.mode);
		}
		return false;
	}

}
