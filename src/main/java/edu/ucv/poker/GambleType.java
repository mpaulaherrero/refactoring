package edu.ucv.poker;

public enum GambleType {
	CARTA_ALTA,	
	PAREJA,	
	DOBLE_PAREJA,	
	TRIO,	
	ESCALERA,	
	COLOR,	
	FULL,	
	POQUER,	
	ESCALERA_COLOR,	
	ESCALERA_REAL;

	public boolean equals(GambleType gambleType) {
		return this.ordinal() == gambleType.ordinal();
	}
	
	public boolean greater(GambleType gambleType) {
		return this.ordinal() > gambleType.ordinal();
	}

}
