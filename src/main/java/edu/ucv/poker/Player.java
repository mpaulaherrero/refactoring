package edu.ucv.poker;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private List<Card> cardList;

	private int[] valuesCont;

	private int[] suitesCont;

	private GambleType gambleType;

	private List<Value> orderedValues;

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
		this.setGambleType();
		player.setGambleType();
		if (this.gambleType.equals(player.gambleType)) {
			int i = 0;
			while (i < this.orderedValues.size() - 1
					&& this.orderedValues.get(i).equals(player.orderedValues.get(i))) {
				i++;
			}
			if (this.orderedValues.get(i).greater(player.orderedValues.get(i))) {
				return this;
			} else if (player.orderedValues.get(i).greater(this.orderedValues.get(i))) {
				return player;
			} else {
				return null;
			}
		} else if (this.gambleType.greater(player.gambleType)) {
			return this;
		} else if (player.gambleType.greater(this.gambleType)) {
			return player;
		}
		return null;
	}

	private void setGambleType() {
		for (Card card : cardList) {
			valuesCont[card.getValue().ordinal()]++;
			suitesCont[card.getSuite().ordinal()]++;
		}
		if (gambleType == null) {
			if (this.hasTwoPairs()) {
				orderedValues = this.getOrderedValues(2);
				orderedValues.addAll(this.getOrderedValues(1));
				gambleType = GambleType.DOBLE_PAREJA;
			}
			if (gambleType == null) {
				if (this.hasSameValue(2)) {
					orderedValues = this.getOrderedValues(2);
					orderedValues.addAll(this.getOrderedValues(1));
					gambleType = GambleType.PAREJA;
				}
				if (gambleType == null) {
					orderedValues = this.getOrderedValues();
					gambleType = GambleType.CARTA_ALTA;
				}
			}
		}
	}

	@Override
	public String toString() {
		return "Player [\ncardList=" + cardList + ", \ngambleType=" + gambleType + ", \norderedValues=" + orderedValues + "]";
	}

	private Value getMaxValue() {
		for (int i = valuesCont.length - 1; i >= 0; i--) {
			if (valuesCont[i] != 0) {
				return Value.values()[i];
			}
		}
		return null;
	}

	private boolean hasSameValue(int amount) {
		for (int valueCont : valuesCont) {
			if (valueCont == amount) {
				return true;
			}
		}
		return false;
	}

	private boolean hasSameColor(int amount) {
		for (int suiteCont : suitesCont) {
			if (suiteCont == amount) {
				return true;
			}
		}
		return false;
	}

	private boolean hasTwoPairs() {
		int pairs = 0;
		for (int valueCont : valuesCont) {
			if (valueCont == 2) {
				pairs++;
			}
		}
		return pairs == 2;
	}

	private List<Value> getOrderedValues(int amount) {
		List<Value> result = new ArrayList<Value>();
		for (int i = valuesCont.length - 1; i >= 0; i--) {
			if (valuesCont[i] == amount) {
				result.add(Value.values()[i]);
			}
		}
		return result;
	}

	private List<Value> getOrderedValues() {
		List<Value> orderedValues = new ArrayList<Value>();
		for (int i = valuesCont.length - 1; i >= 0; i--) {
			for (int j = 0; j < valuesCont[i]; j++) {
				orderedValues.add(Value.values()[i]);
			}
		}
		return orderedValues;
	}

	private boolean hasStairStart(Value value) {
		for (int i = 0; i < 5; i++) {
			if (valuesCont[i + value.ordinal()] != 1) {
				return false;
			}
		}
		return true;
	}

	private boolean hasStair() {
		for (int i = 0; i <= Value.DIEZ.ordinal(); i++) {
			if (this.hasStairStart(Value.values()[i])) {
				return true;
			}
		}
		return false;
	}

}
