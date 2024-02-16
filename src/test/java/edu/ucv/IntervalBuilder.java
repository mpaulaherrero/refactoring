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
			this.fromEndPoint = new FromEndPoint(value);
			intervalBuilderState = IntervalBuilderState.MINIMUM_SETTED;
		} else {
			this.untilEndPoint = new UntilEndPoint(value);
			intervalBuilderState = IntervalBuilderState.MAXIMUM_SETTED;
		}
		return this;
	}

	public IntervalBuilder closed(double value) {
		assert intervalBuilderState != IntervalBuilderState.MAXIMUM_SETTED;
		if (intervalBuilderState == null) {
			this.fromEndPoint = new FromIncludedEndPoint(value);
			intervalBuilderState = IntervalBuilderState.MINIMUM_SETTED;
		} else {
			this.untilEndPoint = new UntilIncludedEndPoint(value);
			intervalBuilderState = IntervalBuilderState.MAXIMUM_SETTED;
		}
		return this;
	}

	public Interval build() {
		return new Interval(this.fromEndPoint, this.untilEndPoint);
	}
}
