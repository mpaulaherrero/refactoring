package edu.ucv;

public interface FromEndPointVisitor {

	void visit(FromEndPoint fromEndPoint);
	
	void visit(FromIncludedEndPoint fromIncludedEndPoint);
}
