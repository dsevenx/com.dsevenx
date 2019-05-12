package com.desvenx.db.user;

public class D7XDB_TUSER_ReadNamePasswort {

	String mSTAGE;
	String mCOMPANY;
	String mDOMAIN;
	String mNAME;
	String mPASSWORD;
	
	@Override
	public String toString() {
		return  " STAGE    :"+ mSTAGE+
				" COMPANY  :"+mCOMPANY+
				" DOMAIN   :"+mDOMAIN+
				" NAME     :"+mNAME+
				" PASSWORD :"+mPASSWORD;
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

}
