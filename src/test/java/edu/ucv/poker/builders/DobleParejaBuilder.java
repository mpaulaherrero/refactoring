package edu.ucv.poker.builders;

import edu.ucv.poker.Value;

public class DobleParejaBuilder extends GambleBuilder {

	private Value valueFirstPareja;
	
	private Value valueSecondPareja;
	
	private Value minValue;
	
	public DobleParejaBuilder setValueFirstPareja(Value valueFirstPareja) {
		this.valueFirstPareja = valueFirstPareja;
		return this;
	}
	
	public DobleParejaBuilder setValueSecondPareja(Value valueSecondPareja) {
		this.valueSecondPareja = valueSecondPareja;
		return this;
	}
	
	public DobleParejaBuilder setMinValue(Value minValue) {
		this.minValue = minValue;
		return this;
	}
	
	@Override
	protected void fillPlayer() {
		player.add(deck.getCard(valueFirstPareja));
		player.add(deck.getCard(valueFirstPareja));
		player.add(deck.getCard(valueSecondPareja));
		player.add(deck.getCard(valueSecondPareja));
		player.add(deck.getCard(minValue));
	}

}