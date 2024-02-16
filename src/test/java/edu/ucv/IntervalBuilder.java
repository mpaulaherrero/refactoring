package edu.ucv;

public class IntervalBuilder {

	private FromEndPoint fromEndPoint;

	private UntilEndPoint untilEndPoint;

	private IntervalBuilderState intervalBuilderState;

	public IntervalBuilder() {
		this.intervalBuilderState = null;
	}

	public IntervalBuilder open(double value) {
		assert intervalBuilderState != IntervalBuilderState.MAXIMUM_SETTED;
		if (intervalBuilderState == null) {
			this.fromEndPoint = new FromEndPoint(value, false);
			intervalBuilderState = IntervalBuilderState.MINIMUM_SETTED;
		} else {
			this.untilEndPoint = new UntilEndPoint(value, false);
			intervalBuilderState = IntervalBuilderState.MAXIMUM_SETTED;
		}
		return this;
	}

	public IntervalBuilder closed(double value) {
		assert intervalBuilderState != IntervalBuilderState.MAXIMUM_SETTED;
		if (intervalBuilderState == null) {
			this.fromEndPoint = new FromEndPoint(value, true);
			intervalBuilderState = IntervalBuilderState.MINIMUM_SETTED;
		} else {
			this.untilEndPoint = new UntilEndPoint(value, true);
			intervalBuilderState = IntervalBuilderState.MAXIMUM_SETTED;
		}
		return this;
	}

	public Interval build() {
		return new Interval(this.fromEndPoint, this.untilEndPoint);
	}
}
