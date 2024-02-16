package edu.ucv;

class EndPoint {

	private double value;
	
	private Mode mode;
		
	protected EndPoint(double value, Mode mode) {
		this.value = value;
		this.setMode(mode);
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

	protected Mode getMode() {
		return mode;
	}

	protected void setMode(Mode mode) {
		this.mode = mode;
	}
	
}
