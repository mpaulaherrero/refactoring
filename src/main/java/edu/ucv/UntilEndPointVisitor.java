package edu.ucv;

public interface UntilEndPointVisitor {

	void visit(UntilEndPoint included);
	
	void visit(UntilIncludedEndPoint included);
}
