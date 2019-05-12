package com.desvenx.db.user.inout;

public class D7XDB_TUserCreateIn {

	String mSTAGE;
	String mCOMPANY;
	String mDOMAIN;
	String mNAME;
	String mPASSWORD;
	String mEMAIL;
	
	@Override
	public String toString() {
		return  "D7XDB_TUserCreateIn STAGE    :"+ mSTAGE+
				"D7XDB_TUserCreateIn COMPANY  :"+mCOMPANY+
				"D7XDB_TUserCreateIn DOMAIN   :"+mDOMAIN+
				"D7XDB_TUserCreateIn NAME     :"+mNAME+
				"D7XDB_TUserCreateIn PASSWORD :"+mPASSWORD+
				"D7XDB_TUserCreateIn EMAIL    :"+mEMAIL
				;
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

}
