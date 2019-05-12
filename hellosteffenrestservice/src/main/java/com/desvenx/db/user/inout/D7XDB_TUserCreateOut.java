package com.desvenx.db.user.inout;

import com.desvenx.db.D7XDB_Erg;
import com.desvenx.db.D7XKonstanten;

public class D7XDB_TUserCreateOut {
	
	private final D7XDB_Erg mD7XDB_Erg;

	int mID;
	
	String mNAME;

	public D7XDB_TUserCreateOut() {
		super();
		mD7XDB_Erg = new D7XDB_Erg("");
	}

	@Override
	public String toString() {
		return  "D7XDB_TUserCreateOut ID        :"+ mID + D7XKonstanten.K_NEW_LINE+
				"D7XDB_TUserCreateOut NAME      :"+ mNAME +  D7XKonstanten.K_NEW_LINE+
				"D7XDB_TUserCreateOut D7XDB_Erg :"+ mD7XDB_Erg.toString()+ D7XKonstanten.K_NEW_LINE
				;
	}

	public void setD7XDB_Erg(String pErgHinweis) {
		getD7XDB_Erg().setErgHinweis(pErgHinweis);
		
	}

	public int getID() {
		return mID;
	}

	public void setID(int pID) {
		mID = pID;
	}

	public D7XDB_Erg getD7XDB_Erg() {
		return mD7XDB_Erg;
	}

	public String getNAME() {
		return mNAME;
	}

	public void setNAME(String pNameForInsert) {
		mNAME = pNameForInsert;
	}


}
