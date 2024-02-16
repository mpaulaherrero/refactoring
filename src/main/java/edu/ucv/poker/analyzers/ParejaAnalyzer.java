package edu.ucv.poker.analyzers;

import java.util.List;

import edu.ucv.poker.Gamble;
import edu.ucv.poker.GambleType;
import edu.ucv.poker.PlayerStatistics;
import edu.ucv.poker.Value;

public class ParejaAnalyzer {
	
	public Gamble getGamble(PlayerStatistics playerStatistics) {
		if (playerStatistics.hasSameValue(2)) {
			List<Value> orderedValues = playerStatistics.getOrderedValues(2);
			orderedValues.addAll(playerStatistics.getOrderedValues(1));
			return new Gamble(GambleType.PAREJA, orderedValues);
		}
		return null;
	}


}
