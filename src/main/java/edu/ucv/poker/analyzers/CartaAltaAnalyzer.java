package edu.ucv.poker.analyzers;

import edu.ucv.poker.Gamble;
import edu.ucv.poker.GambleType;
import edu.ucv.poker.PlayerStatistics;

class CartaAltaAnalyzer { 
	
	public Gamble getGamble(PlayerStatistics playerStatistics) {
		return new Gamble(GambleType.CARTA_ALTA, playerStatistics.getOrderedValues(1));
	}

}
