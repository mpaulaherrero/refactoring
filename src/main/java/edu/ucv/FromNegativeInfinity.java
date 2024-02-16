package edu.ucv;

public class FromNegativeInfinity implements From {

	@Override
	public boolean onLeft(From that) {
		return true;
	}

	@Override
	public void shift(double value) {
	}

	@Override
	public double getValue() {
		return Double.NEGATIVE_INFINITY;
	}

	@Override
	public Mode getMode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double distance(UntilEndPoint untilEndPoint) {
		return Double.POSITIVE_INFINITY;
	}

}
