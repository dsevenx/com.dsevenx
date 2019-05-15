package com.desvenx.db.user.inout;

public class D7XDB_TUserReadHighScoreIn {

	String mSTAGE;
	String mCOMPANY;
	String mDOMAIN;
	String mWELCHE;
    int mOffset;
	
	@Override
	public String toString() {
		return  " D7XDB_TUserReadHighScoreIn STAGE    :"+ mSTAGE+
				" D7XDB_TUserReadHighScoreIn COMPANY  :"+mCOMPANY+
				" D7XDB_TUserReadHighScoreIn DOMAIN   :"+mDOMAIN+
				" D7XDB_TUserReadHighScoreIn WELCHE   :"+mWELCHE+
				" D7XDB_TUserReadHighScoreIn Offset   :"+mOffset
				
				;
	}

	public String getmSTAGE() {
		return mSTAGE;
	}

	public void setmSTAGE(String pMSTAGE) {
		mSTAGE = pMSTAGE;
	}

	public String getmCOMPANY() {
		return mCOMPANY;
	}

	public void setmCOMPANY(String pMCOMPANY) {
		mCOMPANY = pMCOMPANY;
	}

	public String getmDOMAIN() {
		return mDOMAIN;
	}

	public void setmDOMAIN(String pMDOMAIN) {
		mDOMAIN = pMDOMAIN;
	}

	public String getmWELCHE() {
		return mWELCHE;
	}

	public void setmWELCHE(String pMWELCHE) {
		mWELCHE = pMWELCHE;
	}

	public int getmOffset() {
		return mOffset;
	}

	public void setmOffset(int pMOffset) {
		mOffset = pMOffset;
	}



}
