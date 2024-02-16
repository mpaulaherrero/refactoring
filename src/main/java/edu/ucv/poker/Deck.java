package edu.ucv.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	protected List<Card> cardList;

	public Deck() {
		cardList = new ArrayList<Card>();
		for (Suite suite : Suite.values()) {
			for (Value value : Value.values()) {
				cardList.add(new Card(suite, value));
			}
		}
		Collections.shuffle(cardList);
	}

	public Card getCard() {
		return cardList.remove(0);
	}
}
