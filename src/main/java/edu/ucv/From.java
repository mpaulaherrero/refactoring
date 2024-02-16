package edu.ucv;

public interface From {
	
	double distance(UntilEndPoint untilEndPoint);

	boolean onLeft(From that);
	
	void shift(double value);
	
	double getValue();
}
