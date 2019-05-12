package com.desvenx.db.user.inout;

public class D7XDB_TUserUpdateIn {

	int mID;
	
	String mDaten;
	
    int mHighScoreGesamt;
	
    int mHighScoreEinzel;
	
	@Override
	public String toString() {
		return  "D7XDB_TUserUpdateIn ID               :"+ mID +
				"D7XDB_TUserUpdateIn Daten            :"+ mDaten +
			    "D7XDB_TUserUpdateIn HighScoreGesamt  :"+ mHighScoreGesamt +
			    "D7XDB_TUserUpdateIn HighScoreEinzel  :"+ mHighScoreEinzel 
					;
	}

	public int getID() {
		return mID;
	}

	public void setID(int pID) {
		mID = pID;
	}

	public String getDaten() {
		return mDaten;
	}

	public void setDaten(String pDaten) {
		mDaten = pDaten;
	}

	public int getHighScoreGesamt() {
		return mHighScoreGesamt;
	}

	public void setHighScoreGesamt(int pHighScoreGesamt) {
		mHighScoreGesamt = pHighScoreGesamt;
	}

	public int getHighScoreEinzel() {
		return mHighScoreEinzel;
	}

	public void setHighScoreEinzel(int pHighScoreEinzel) {
		mHighScoreEinzel = pHighScoreEinzel;
	}


}
