package edu.ucv;

public class Interval {

	private FromEndPoint fromEndPoint; 
	
	private UntilEndPoint untilEndPoint;

	public Interval(FromEndPoint fromEndPoint, UntilEndPoint untilEndPoint) {
		this.fromEndPoint = fromEndPoint;
		this.untilEndPoint = untilEndPoint;
	}

	public void shift(double value) {
		this.fromEndPoint.shift(value);
		this.untilEndPoint.shift(value);
	}

	public double length() {
		return this.untilEndPoint.getValue() - this.fromEndPoint.getValue();
	}

	public boolean includes(double value) {
		return this.fromEndPoint.onLeft(value) && this.untilEndPoint.onRight(value);
	}

	public boolean includes(Interval that) {
		return this.fromEndPoint.onLeft(that.fromEndPoint) && this.untilEndPoint.onRight(that.untilEndPoint);
	}

}
