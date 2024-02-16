package edu.ucv;

class FromEndPoint extends EndPoint {

	FromEndPoint(double value, Mode mode) {
		super(value, mode);
	}

	boolean onLeft(FromEndPoint that) {
		if (this.getValue() < that.getValue()) {
			return true;
		}
		if (this.getValue() == that.getValue()) {
			return this.getMode().includes(that.getMode());
		}
		return false;
	}

}
