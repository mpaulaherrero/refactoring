package edu.ucv;

class UntilEndPoint extends EndPoint {

	UntilEndPoint(double value, boolean closed) {
		super(value, closed);
	}

	boolean onRight(double value) {
		if (this.isClosed()) {
			if (value > this.getValue()) {
				return false;
			}
		} else {
			if (value >= this.getValue()) {
				return false;
			}
		}
		return true;
	}
	
}
