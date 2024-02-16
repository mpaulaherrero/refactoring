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
		if (this.fromEndPoint.getValue() > that.fromEndPoint.getValue()) {
			return false;
		}
		if (this.fromEndPoint.isClosed()) {
		} else {
			if (this.fromEndPoint.getValue() == that.fromEndPoint.getValue() && that.fromEndPoint.isClosed()) {
				return false;
			}
		}
		if (this.untilEndPoint.getValue() < that.untilEndPoint.getValue()) {
			return false;
		}
		if (this.untilEndPoint.isClosed()) {
		} else {
			if (this.untilEndPoint.getValue() == that.untilEndPoint.getValue() && that.untilEndPoint.isClosed()) {
				return false;
			}
		}
		return true;
	}

}
