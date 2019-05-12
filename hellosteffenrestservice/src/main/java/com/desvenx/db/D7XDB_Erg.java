package com.desvenx.db;

public class D7XDB_Erg {

	private String mErgHinweis;
	
	@Override
	public String toString() {
		return "ErgHinweis : " + mErgHinweis;
	}

	public D7XDB_Erg(String pString) {
		mErgHinweis = pString;
	}

	public String getErgHinweis() {
		return mErgHinweis;
	}

	public void setErgHinweis(String pErgHinweis) {
		mErgHinweis = pErgHinweis;
	}

}
