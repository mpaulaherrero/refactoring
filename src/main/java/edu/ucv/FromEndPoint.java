package edu.ucv;

class FromEndPoint extends EndPoint implements From  {

	FromEndPoint(double value, Mode mode) {
		super(value, mode);
	}

	public boolean onLeft(From that) {
		if (this.getValue() < that.getValue()) {
			return true;
		}
		if (this.getValue() == that.getValue()) {
			return this.getMode().includes(((FromEndPoint) that).getMode());
		}
		return false;
	}

	@Override
	public double distance(UntilEndPoint untilEndPoint) {
		return untilEndPoint.getValue() - this.getValue();
	}

}
