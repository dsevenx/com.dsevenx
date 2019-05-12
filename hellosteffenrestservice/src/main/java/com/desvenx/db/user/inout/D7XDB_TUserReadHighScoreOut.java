package com.desvenx.db.user.inout;

import java.util.ArrayList;
import java.util.List;

import com.desvenx.db.D7XAllgFunktionen;
import com.desvenx.db.D7XDB_Erg;
import com.desvenx.db.D7XKonstanten;

public class D7XDB_TUserReadHighScoreOut {
	
	private final D7XDB_Erg mD7XDB_Erg;

	private final List<String> mHighScore;
	
	
	public D7XDB_TUserReadHighScoreOut() {
		super();
		mD7XDB_Erg = new D7XDB_Erg("");
		mHighScore = new ArrayList<String>();
	}

	@Override
	public String toString() {
		StringBuilder lErg = new StringBuilder( "D7XDB_TUserReadHighScoreOut D7XDB_Erg :"+ mD7XDB_Erg.toString());
		
		for (String lString : mHighScore) {
			lErg.append(lString+D7XKonstanten.K_NEW_LINE);
		}
		
		return lErg.toString();
	}

	public D7XDB_Erg getD7XDB_Erg() {
		return mD7XDB_Erg;
	}
	
	public String getHighScoreString() {
		StringBuilder lErg = new StringBuilder();
		
		for (String lString : mHighScore) {
			lErg.append(lString);
		}
		
		return lErg.toString();
	}


	public void addUserMitHighScore(String pName,int pHighScore, String pHighScoreDatum) {
		mHighScore.add(String.format("%-20s", pName) + D7XKonstanten.K_TRENN_USER_HIGHSCORE + String.format("%4d", pHighScore)+ " ("+D7XAllgFunktionen.lieferDatumKorrekt(pHighScoreDatum)+")  "+D7XKonstanten.K_NEW_LINE);
	}

	public void setD7XDB_Erg(String pErgHinweis) {
		getD7XDB_Erg().setErgHinweis(pErgHinweis);
		
	}


}
