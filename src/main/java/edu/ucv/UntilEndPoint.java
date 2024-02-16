package edu.ucv;

class UntilEndPoint extends EndPoint {

	UntilEndPoint(double value) {
		super(value);
		this.mode = new Open();
	}

	boolean onRight(UntilEndPoint that) {
		if (this.getValue() > that.getValue()) {
			return true;
		}
		if (this.getValue() == that.getValue()) {
			return this.mode.includes(that.mode);
		}
		return false;
	}

}
