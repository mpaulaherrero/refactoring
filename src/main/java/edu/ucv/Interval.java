package edu.ucv;

public class Interval {

	private double minimum;

	private boolean minimumClosed;

	private double maximum;

	private boolean maximumClosed;

	public Interval(double minimum, boolean minimumClosed, double maximum, boolean maximumClosed) {
		assert minimum < maximum || minimum == maximum && minimumClosed || !minimumClosed;
		this.minimum = minimum;
		this.minimumClosed = minimumClosed;
		this.maximum = maximum;
		this.maximumClosed = maximumClosed;
	}

	public void shift(double value) {
		this.minimum += value;
		this.maximum += value;
	}

	public double length() {
		return this.maximum - this.minimum;
	}

	public boolean includes(double value) {
		if (this.minimumClosed) {
			if (value < this.minimum) {
				return false;
			}
		} else {
			if (value <= this.minimum) {
				return false;
			}
		}
		if (this.maximumClosed) {
			if (value > this.maximum) {
				return false;
			}
		} else {
			if (value >= this.maximum) {
				return false;
			}
		}
		return true;
	}

	public boolean includes(Interval that) {
		if (this.minimum > that.minimum) {
			return false;
		}
		if (this.minimumClosed) {
		} else {
			if (this.minimum == that.minimum && that.minimumClosed) {
				return false;
			}
		}
		if (this.maximum < that.maximum) {
			return false;
		}
		if (this.maximumClosed) {
		} else {
			if (this.maximum == that.maximum && that.maximumClosed) {
				return false;
			}
		}
		return true;
	}

}
