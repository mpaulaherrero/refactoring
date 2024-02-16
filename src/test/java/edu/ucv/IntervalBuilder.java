package edu.ucv;

public class IntervalBuilder {

	private From from;

	private UntilEndPoint untilEndPoint;

	private IntervalBuilderState intervalBuilderState;

	public IntervalBuilder() {
		this.intervalBuilderState = null;
	}

	public IntervalBuilder open(double value) {
		assert intervalBuilderState != IntervalBuilderState.MAXIMUM_SETTED;
		if (intervalBuilderState == null) {
			this.from = new FromEndPoint(value, new Open());
			intervalBuilderState = IntervalBuilderState.MINIMUM_SETTED;
		} else {
			this.untilEndPoint = new UntilEndPoint(value, new Open());
			intervalBuilderState = IntervalBuilderState.MAXIMUM_SETTED;
		}
		return this;
	}

	public IntervalBuilder closed(double value) {
		assert intervalBuilderState != IntervalBuilderState.MAXIMUM_SETTED;
		if (intervalBuilderState == null) {
			this.from = new FromEndPoint(value, new Closed());
			intervalBuilderState = IntervalBuilderState.MINIMUM_SETTED;
		} else {
			this.untilEndPoint = new UntilEndPoint(value, new Closed());
			intervalBuilderState = IntervalBuilderState.MAXIMUM_SETTED;
		}
		return this;
	}
	
	public IntervalBuilder infinity() {
		assert intervalBuilderState != IntervalBuilderState.MAXIMUM_SETTED;
		if (intervalBuilderState == null) {
			this.from = new FromNegativeInfinity();
			intervalBuilderState = IntervalBuilderState.MINIMUM_SETTED;
		} else {
			this.untilEndPoint = null;
			intervalBuilderState = IntervalBuilderState.MAXIMUM_SETTED;
		}
		return this;
	}

	public Interval build() {
		return new Interval(this.from, this.untilEndPoint);
	}
	
}
