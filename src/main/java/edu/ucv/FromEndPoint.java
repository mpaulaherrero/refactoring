package edu.ucv;

class FromEndPoint extends EndPoint {

	FromEndPoint(double value) {
		super(value);
		this.mode = new Open();
	}

	boolean onLeft(double value) {
		return this.getValue() < value;
	}

	boolean onLeft(FromEndPoint that) {
		if (this.onLeft(that.getValue())) {
			return true;
		}
		if (this.getValue() == that.getValue()) {
			return this.mode.includes(that.mode);
		}
		return false;
	}

}
