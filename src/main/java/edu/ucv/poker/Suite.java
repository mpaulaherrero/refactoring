package edu.ucv.poker;

public enum Suite {
	CORAZONES("C"),	
	DIAMANTES("D"),
	PICAS("P"),
	TREBOLES("T");

	private String title;

	private Suite(String title){
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	private Suite next() {
		return Suite.values()[(this.ordinal()+1)%Suite.values().length];
	}
	
	public Suite next(int amount) {
		Suite suite = this;
		for (int i = 0; i < amount; i++) {
			suite = suite.next();
		}
		return suite;
	}
}
