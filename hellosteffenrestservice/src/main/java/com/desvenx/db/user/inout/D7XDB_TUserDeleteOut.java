package com.desvenx.db.user.inout;

import com.desvenx.db.D7XDB_Erg;
import com.desvenx.db.D7XKonstanten;

public class D7XDB_TUserDeleteOut {
	
	private final D7XDB_Erg mD7XDB_Erg;
	
	private String mName;

	public D7XDB_TUserDeleteOut() {
		super();
		mD7XDB_Erg = new D7XDB_Erg("");
	}

	@Override
	public String toString() {
		return   "D7XDB_TUserDeleteOut NAME :"+ mName+ D7XKonstanten.K_NEW_LINE
		+ "D7XDB_TUserDeleteOut D7XDB_Erg :"+ mD7XDB_Erg.toString()
				;
	}

	public D7XDB_Erg getD7XDB_Erg() {
		return mD7XDB_Erg;
	}

	public void setD7XDB_Erg(String pErgHinweis) {
		getD7XDB_Erg().setErgHinweis(pErgHinweis);
		
	}

	public void setName(String pString) {
		mName = pString;
	}

	public String getName() {
		return mName;
	}


}
