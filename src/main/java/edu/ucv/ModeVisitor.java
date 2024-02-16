package edu.ucv;

public interface ModeVisitor {

	boolean visit(Open open);
	
	boolean visit(Closed closed);
}
