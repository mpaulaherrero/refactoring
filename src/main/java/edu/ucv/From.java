package edu.ucv;

public interface From {

	boolean onLeft(From that);
	
	void shift(double value);
	
	double getValue();
	
	Mode getMode();
}
