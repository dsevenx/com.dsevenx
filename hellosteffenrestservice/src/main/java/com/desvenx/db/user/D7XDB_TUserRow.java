package com.desvenx.db.user;

import com.desvenx.db.D7XDB_Erg;

public class D7XDB_TUserRow {

	private D7XDB_Erg mD7XDB_Erg;

	public static final String K_STAGE = "STAGE";
	public static final String K_COMPANY = "COMPANY";
	public static final String K_DOMAIN = "DOMAIN";
	public static final String K_USERID = "USERID";
	public static final String K_NAME = "PLAYERNAME";
	public static final String K_PASSWORD = "PASSWORT";
	public static final String K_EMAIL = "EMAIL";
	public static final String K_HIGHSCORE_INSGESAMT = "HIGHSCORE_INSGESAMT";
	public static final String K_HIGHSCORE_EINZEL = "HIGHSCORE_EINZEL";
	public static final String K_HIGHSCORE_INSGESAMT_DATUM = "HIGHSCORE_INSGESAMT_DATUM";
	public static final String K_HIGHSCORE_EINZEL_DATUM = "HIGHSCORE_EINZEL_DATUM";
	public static final String K_DATEN = "DATEN";

	@Override
	public String toString() {
		return " STAGE    :" + mSTAGE + " COMPANY  :" + mCOMPANY + " DOMAIN   :" + mDOMAIN + " USERID   :" + mUSERID
				+ " NAME     :" + mNAME + " PASSWORD :" + mPASSWORD + " EMAIL                :" + mEMAIL
				+ " HIGHSCORE_INSGESAMT  :" + mHIGHSCORE_INSGESAMT + " HIGHSCORE_EINZEL     :" + mHIGHSCORE_EINZEL
				+ " HIGHSCORE_INSGESAMT_DATUM  :" + mHIGHSCORE_INSGESAMT_DATUM + " HIGHSCORE_EINZEL_DATUM     :" + mHIGHSCORE_EINZEL_DATUM
				+ " DATEN                :" + mDATEN;
	}

	private String mSTAGE;
	private String mCOMPANY;
	private String mDOMAIN;
	private int mUSERID;
	private String mNAME;
	private String mPASSWORD;
	private String mEMAIL;
	private int mHIGHSCORE_INSGESAMT;
	private int mHIGHSCORE_EINZEL;
	private String mHIGHSCORE_INSGESAMT_DATUM;
	private String mHIGHSCORE_EINZEL_DATUM;
	private String mDATEN;

	public D7XDB_TUserRow() {
		super();
		mD7XDB_Erg = new D7XDB_Erg("");
	}

	public D7XDB_Erg getD7XDB_Erg() {
		return mD7XDB_Erg;
	}

	public void setD7XDB_Erg(D7XDB_Erg pD7xdb_Erg) {
		mD7XDB_Erg = pD7xdb_Erg;
	}

	public String getSTAGE() {
		return mSTAGE;
	}

	public void setSTAGE(String pSTAGE) {
		mSTAGE = pSTAGE;
	}

	public String getCOMPANY() {
		return mCOMPANY;
	}

	public void setCOMPANY(String pCOMPANY) {
		mCOMPANY = pCOMPANY;
	}

	public String getDOMAIN() {
		return mDOMAIN;
	}

	public void setDOMAIN(String pDOMAIN) {
		mDOMAIN = pDOMAIN;
	}

	public String getNAME() {
		return mNAME;
	}

	public void setNAME(String pNAME) {
		mNAME = pNAME;
	}

	public String getPASSWORD() {
		return mPASSWORD;
	}

	public void setPASSWORD(String pPASSWORD) {
		mPASSWORD = pPASSWORD;
	}

	public String getEMAIL() {
		return mEMAIL;
	}

	public void setEMAIL(String pEMAIL) {
		mEMAIL = pEMAIL;
	}

	public String getDATEN() {
		return mDATEN;
	}

	public void setDATEN(String pDATEN) {
		mDATEN = pDATEN;
	}

	public void setD7XDB_Erg(String pString) {
		mD7XDB_Erg.setErgHinweis(pString);
	}

	public int getUSERID() {
		return mUSERID;
	}

	public void setUSERID(int pUSERID) {
		mUSERID = pUSERID;
	}

	public int getHIGHSCORE_INSGESAMT() {
		return mHIGHSCORE_INSGESAMT;
	}

	public void setHIGHSCORE_INSGESAMT(int pHIGHSCORE_INSGESAMT) {
		mHIGHSCORE_INSGESAMT = pHIGHSCORE_INSGESAMT;
	}

	public int getHIGHSCORE_EINZEL() {
		return mHIGHSCORE_EINZEL;
	}

	public void setHIGHSCORE_EINZEL(int pHIGHSCORE_EINZEL) {
		mHIGHSCORE_EINZEL = pHIGHSCORE_EINZEL;
	}

	public String getHIGHSCORE_INSGESAMT_DATUM() {
		return mHIGHSCORE_INSGESAMT_DATUM;
	}

	public void setHIGHSCORE_INSGESAMT_DATUM(String pHIGHSCORE_INSGESAMT_DATUM) {
		mHIGHSCORE_INSGESAMT_DATUM = pHIGHSCORE_INSGESAMT_DATUM;
	}

	public String getHIGHSCORE_EINZEL_DATUM() {
		return mHIGHSCORE_EINZEL_DATUM;
	}

	public void setHIGHSCORE_EINZEL_DATUM(String pHIGHSCORE_EINZEL_DATUM) {
		mHIGHSCORE_EINZEL_DATUM = pHIGHSCORE_EINZEL_DATUM;
	}

}
