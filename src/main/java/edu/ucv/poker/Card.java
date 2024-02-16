package edu.ucv.poker;

public class Card {

	private Suite suite;
	
	private Value value;
		
	Card(Suite suite, Value value){
		this.value = value;
		this.suite = suite;
	}

	public boolean greater(Card card) {
		return value.greater(card.value);
	}

	
	public Value getValue() {
		return value;
	}
	
	public Suite getSuite() {
		return suite;
	}
	
	@Override
	public String toString() {
		return "Card [" + value.getTitle() + ", " + suite.getTitle() + "]";
	}
	
}
