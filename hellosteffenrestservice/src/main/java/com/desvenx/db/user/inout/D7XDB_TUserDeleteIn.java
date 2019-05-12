package com.desvenx.db.user.inout;

public class D7XDB_TUserDeleteIn {

	int mID;
		
	@Override
	public String toString() {
		return  "D7XDB_TUserDeleteIn ID               :"+ mID 					;
	}

	public int getID() {
		return mID;
	}

	public void setID(int pID) {
		mID = pID;
	}
}
