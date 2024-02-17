package edu.ucv.poker.analyzers;

import java.util.List;

import edu.ucv.poker.Gamble;
import edu.ucv.poker.GambleType;
import edu.ucv.poker.PlayerStatistics;
import edu.ucv.poker.Value;

class DobleParejaAnalyzer extends Analyzer {

	public DobleParejaAnalyzer(Analyzer analyzer){
		super(analyzer);
	}
	
	@Override
	public Gamble getGamble(PlayerStatistics playerStatistics) {
		if (playerStatistics.hasTwoPairs()) {
			List<Value> orderedValues = playerStatistics.getOrderedValues(2);
			orderedValues.addAll(playerStatistics.getOrderedValues(1));
			return new Gamble(GambleType.DOBLE_PAREJA, orderedValues);
		} else {
			return nextAnalyzer.getGamble(playerStatistics);
		}
	}

}
