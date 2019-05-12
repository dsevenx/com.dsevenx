package com.desvenx.db.user.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.desvenx.db.D7XAllgFunktionen;
import com.desvenx.db.user.RDSConnectionD7XDB;
import com.desvenx.db.user.inout.D7XDB_TUserCreateIn;
import com.desvenx.db.user.inout.D7XDB_TUserCreateOut;

public class D7XDBRequestHandlerCreateUser implements RequestHandler<D7XDB_TUserCreateIn, D7XDB_TUserCreateOut> {

	@Override
	public D7XDB_TUserCreateOut handleRequest(D7XDB_TUserCreateIn pInput, Context pContext) {
		
		D7XAllgFunktionen.log("--> D7XDBRequestHandlerCreateUser");
		D7XAllgFunktionen.log("Input :"+pInput.toString());
		           	
		D7XDB_TUserCreateOut lD7XDB_TUserCreateOut = new RDSConnectionD7XDB().createUser(pInput);
    	
		D7XAllgFunktionen.log("Outputput :"+lD7XDB_TUserCreateOut.toString());

		return lD7XDB_TUserCreateOut;
	}

}
