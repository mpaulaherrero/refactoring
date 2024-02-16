package edu.ucv;

class EndPoint {

	private double value;
	
	private boolean closed;
	
	protected EndPoint(double value, boolean closed) {
		super();
		this.setValue(value);
		this.setClosed(closed);
	}
	
	void shift(double value) {
		this.setValue(this.getValue() + value);
	}

	double getValue() {
		return value;
	}

	private void setValue(double value) {
		this.value = value;
	}

	boolean isClosed() {
		return closed;
	}

	private void setClosed(boolean closed) {
		this.closed = closed;
	}

	
}
