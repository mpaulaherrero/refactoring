package edu.ucv.poker;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private List<Card> cardList;

	private Gamble gamble;
	
	private int[] valuesCont;

	private int[] suitesCont;

	public Player() {
		cardList = new ArrayList<Card>();
		valuesCont = new int[Value.values().length];
		suitesCont = new int[Suite.values().length];
	}

	public void add(Card card) {
		cardList.add(card);
	}
	
	public Player whoIsWinner(Player player) {
		assert player != null;
		Gamble winner = this.getGamble().whoIsWinner(player.getGamble());
		if (winner == this.getGamble()) {
			return this;
		} else if (winner == player.getGamble()) {
			return player;
		} else {
			return null;
		}
	}
	
	private Gamble getGamble(){
		for (Card card : cardList) {
			valuesCont[card.getValue().ordinal()]++;
			suitesCont[card.getSuite().ordinal()]++;
		}
		if (gamble == null) {
			if (this.hasTwoPairs()) {
				List<Value> orderedValues = this.getOrderedValues(2);
				orderedValues.addAll(this.getOrderedValues(1));
				gamble = new Gamble(GambleType.DOBLE_PAREJA, orderedValues);
			} 
			if (gamble == null) {
				if (this.hasSameValue(2)) {
					List<Value> orderedValues = this.getOrderedValues(2);
					orderedValues.addAll(this.getOrderedValues(1));
					gamble = new Gamble(GambleType.PAREJA, orderedValues);
				}
				if (gamble == null) {
					gamble = new Gamble(GambleType.CARTA_ALTA, this.getOrderedValues(1));
				}
			}
		}
		return gamble;
	}

	@Override
	public String toString() {
		return "Player [\ncardList=" + cardList + ", \ngamble=" + gamble + "]";
	}
	
	public Value getMaxValue() {
		for (int i = valuesCont.length - 1; i >= 0; i--) {
			if (valuesCont[i] != 0) {
				return Value.values()[i];
			}
		}
		return null;
	}

	public boolean hasSameValue(int amount) {
		for (int valueCont : valuesCont) {
			if (valueCont == amount) {
				return true;
			}
		}
		return false;
	}

	public boolean hasSameColor(int amount) {
		for (int suiteCont : suitesCont) {
			if (suiteCont == amount) {
				return true;
			}
		}
		return false;
	}

	public boolean hasTwoPairs() {
		int pairs = 0;
		for (int valueCont : valuesCont) {
			if (valueCont == 2) {
				pairs++;
			}
		}
		return pairs == 2;
	}

	public List<Value> getOrderedValues(int amount) {
		List<Value> result = new ArrayList<Value>();
		for (int i = valuesCont.length - 1; i >= 0; i--) {
			if (valuesCont[i] == amount) {
				result.add(Value.values()[i]);
			}
		}
		return result;
	}

	public List<Value> getOrderedValues() {
		List<Value> orderedValues = new ArrayList<Value>();
		for (int i = valuesCont.length - 1; i >= 0; i--) {
			for (int j = 0; j < valuesCont[i]; j++) {
				orderedValues.add(Value.values()[i]);
			}
		}
		return orderedValues;
	}

	public boolean hasStairStart(Value value) {
		for (int i = 0; i < 5; i++) {
			if (valuesCont[i + value.ordinal()] != 1) {
				return false;
			}
		}
		return true;
	}

	public boolean hasStair() {
		for (int i = 0; i <= Value.DIEZ.ordinal(); i++) {
			if (this.hasStairStart(Value.values()[i])) {
				return true;
			}
		}
		return false;
	}

}
