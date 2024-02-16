package edu.ucv;

class FromEndPoint extends EndPoint {

	FromEndPoint(double value) {
		super(value);
		this.mode = new Open();
	}

	boolean onLeft(FromEndPoint that) {
		if (this.getValue() < that.getValue()) {
			return true;
		}
		if (this.getValue() == that.getValue()) {
			return this.mode.includes(that.mode);
		}
		return false;
	}

}
