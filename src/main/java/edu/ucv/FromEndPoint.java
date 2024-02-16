package edu.ucv;

class FromEndPoint extends EndPoint {

	FromEndPoint(double value, boolean closed) {
		super(value, closed);
	}
	
	boolean onLeft(double value) {
		if (this.isClosed()) {
			if (value < this.getValue()) {
				return false;
			}
		} else {
			if (value <= this.getValue()) {
				return false;
			}
		}
		return true;
	}

	boolean onLeft(FromEndPoint that) {
		if (this.getValue() > that.getValue()) {
			return false;
		}
		if (this.isClosed()) {
		} else {
			if (this.getValue() == that.getValue() && that.isClosed()) {
				return false;
			}
		}
		return true;
	}
}

