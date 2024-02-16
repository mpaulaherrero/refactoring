package edu.ucv.poker;

import java.util.ArrayList;
import java.util.List;

import edu.ucv.poker.analyzers.GambleAnalyzer;

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
		if (gamble == null){
			gamble = new GambleAnalyzer().getGamble(new PlayerStatistics(cardList));
		}
		return gamble;
	}

	@Override
	public String toString() {
		return "Player [\ncardList=" + cardList  
				+ ", \ngamble=" + gamble
				+ "]";
	}

}
