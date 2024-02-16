package edu.ucv.poker;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private List<Card> cardList;

	private Gamble gamble;

	public Player() {
		cardList = new ArrayList<Card>();
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
		PlayerStatistics playerStatistics = new PlayerStatistics(cardList);
		if (gamble == null) {
			if (playerStatistics.hasTwoPairs()) {
				List<Value> orderedValues = playerStatistics.getOrderedValues(2);
				orderedValues.addAll(playerStatistics.getOrderedValues(1));
				gamble = new Gamble(GambleType.DOBLE_PAREJA, orderedValues);
			} 
			if (gamble == null) {
				if (playerStatistics.hasSameValue(2)) {
					List<Value> orderedValues = playerStatistics.getOrderedValues(2);
					orderedValues.addAll(playerStatistics.getOrderedValues(1));
					gamble = new Gamble(GambleType.PAREJA, orderedValues);
				}
				if (gamble == null) {
					gamble = new Gamble(GambleType.CARTA_ALTA, playerStatistics.getOrderedValues(1));
				}
			}
		}
		return gamble;
	}

	@Override
	public String toString() {
		return "Player [\ncardList=" + cardList + ", \ngamble=" + gamble + "]";
	}

}
