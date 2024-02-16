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
}
