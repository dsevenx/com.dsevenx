package com.desvenx.db.user.inout;

public class D7XDB_TUserReadHighScoreIn {

	String mSTAGE;
	String mCOMPANY;
	String mDOMAIN;
	String mWELCHE;
    int mOffset;
	
	@Override
	public String toString() {
		return  "D7XDB_TUserReadHighScoreIn STAGE    :"+ mSTAGE+
				"D7XDB_TUserReadHighScoreIn COMPANY  :"+mCOMPANY+
				"D7XDB_TUserReadHighScoreIn DOMAIN   :"+mDOMAIN+
				"D7XDB_TUserReadHighScoreIn WELCHE   :"+mWELCHE+
				"D7XDB_TUserReadHighScoreIn Offset   :"+mOffset
				
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

	public String getWELCHE() {
		return mWELCHE;
	}

	public void setWELCHE(String pWELCHE) {
		mWELCHE = pWELCHE;
	}

	public int getOffset() {
		return mOffset;
	}

	public void setOffset(int pOffset) {
		mOffset = pOffset;
	}


}
