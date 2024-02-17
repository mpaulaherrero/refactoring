package edu.ucv.poker.analyzers;

import edu.ucv.poker.Gamble;
import edu.ucv.poker.PlayerStatistics;

abstract class Analyzer {

	protected Analyzer nextAnalyzer;
	
	public Analyzer(Analyzer nextAnalyzer) {
		this.nextAnalyzer = nextAnalyzer;
	}

	public abstract Gamble getGamble(PlayerStatistics playerStatistics);

}
