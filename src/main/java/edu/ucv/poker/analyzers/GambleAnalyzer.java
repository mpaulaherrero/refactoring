package edu.ucv.poker.analyzers;

import edu.ucv.poker.Gamble;
import edu.ucv.poker.PlayerStatistics;

public class GambleAnalyzer {

	private Analyzer analyzer;

	public GambleAnalyzer() {
		analyzer = 
//				new EscaleraRealAnalyzer(
//				new EscaleraColorAnalyzer(
//				new PoquerAnalyzer(
//				new FullAnalyzer(
//				new ColorAnalyzer(
//				new EscaleraAnalyzer(
//				new TrioAnalyzer(
				new DobleParejaAnalyzer(
				new ParejaAnalyzer(
				new CartaAltaAnalyzer()))/*)))))))*/;
	}

	public Gamble getGamble(PlayerStatistics playerStatistics) {
		return analyzer.getGamble(playerStatistics);
	}

}