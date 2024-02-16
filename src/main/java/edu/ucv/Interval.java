package edu.ucv;

public class Interval {

	private FromEndPoint fromEndPoint;
	
	private UntilEndPoint untilEndPoint;

	public Interval(double minimum, boolean minimumClosed, double maximum, boolean maximumClosed) {
		assert minimum < maximum || minimum == maximum && minimumClosed || !minimumClosed;
		this.fromEndPoint = new FromEndPoint();
		this.fromEndPoint.minimum = minimum;
		this.fromEndPoint.minimumClosed = minimumClosed;
		this.untilEndPoint = new UntilEndPoint();
		this.untilEndPoint.maximum = maximum;
		this.untilEndPoint.maximumClosed = maximumClosed;
	}

	public void shift(double value) {
		this.fromEndPoint.minimum += value;
		this.untilEndPoint.maximum += value;
	}

	public double length() {
		return this.untilEndPoint.maximum - this.fromEndPoint.minimum;
	}

	public boolean includes(double value) {
		if (this.fromEndPoint.minimumClosed) {
			if (value < this.fromEndPoint.minimum) {
				return false;
			}
		} else {
			if (value <= this.fromEndPoint.minimum) {
				return false;
			}
		}
		if (this.untilEndPoint.maximumClosed) {
			if (value > this.untilEndPoint.maximum) {
				return false;
			}
		} else {
			if (value >= this.untilEndPoint.maximum) {
				return false;
			}
		}
		return true;
	}

	public boolean includes(Interval that) {
		if (this.fromEndPoint.minimum > that.fromEndPoint.minimum) {
			return false;
		}
		if (this.fromEndPoint.minimumClosed) {
		} else {
			if (this.fromEndPoint.minimum == that.fromEndPoint.minimum && that.fromEndPoint.minimumClosed) {
				return false;
			}
		}
		if (this.untilEndPoint.maximum < that.untilEndPoint.maximum) {
			return false;
		}
		if (this.untilEndPoint.maximumClosed) {
		} else {
			if (this.untilEndPoint.maximum == that.untilEndPoint.maximum && that.untilEndPoint.maximumClosed) {
				return false;
			}
		}
		return true;
	}

}
