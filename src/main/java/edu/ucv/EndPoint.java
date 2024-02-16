package edu.ucv;

class EndPoint {

	private double value;
	
	protected Mode mode;
	
	protected EndPoint(double value) {
		super();
		this.setValue(value);
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
	
}
