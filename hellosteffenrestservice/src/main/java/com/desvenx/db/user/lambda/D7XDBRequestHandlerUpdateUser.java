package com.desvenx.db.user.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.desvenx.db.D7XAllgFunktionen;
import com.desvenx.db.user.RDSConnectionD7XDB;
import com.desvenx.db.user.inout.D7XDB_TUserUpdateIn;
import com.desvenx.db.user.inout.D7XDB_TUserUpdateOut;

public class D7XDBRequestHandlerUpdateUser implements RequestHandler<D7XDB_TUserUpdateIn, D7XDB_TUserUpdateOut> {

	@Override
	public D7XDB_TUserUpdateOut handleRequest(D7XDB_TUserUpdateIn pInput, Context pContext) {
		
		D7XAllgFunktionen.log("--> D7XDBRequestHandlerUpdateUser");
		D7XAllgFunktionen.log("Input :"+pInput.toString());
		           	
		D7XDB_TUserUpdateOut lD7XDB_TUserUpdateOut = new RDSConnectionD7XDB().updateUser(pInput);
    	
		D7XAllgFunktionen.log("Outputput :"+lD7XDB_TUserUpdateOut.toString());

		return lD7XDB_TUserUpdateOut;
	}

}
