package com.desvenx.db.user;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.desvenx.db.D7XAllgFunktionen;

public class RDSConnectionD7XDBRequestHandler implements RequestHandler<D7XDB_TUSER_ReadNamePasswort, D7XDB_TUserRow> {

	@Override
	public D7XDB_TUserRow handleRequest(D7XDB_TUSER_ReadNamePasswort pInput, Context pContext) {
		
		D7XAllgFunktionen.log("--> handleRequest");
		D7XAllgFunktionen.log("Input :"+pInput.toString());
		
	//	D7XDB_TUserRow lErg =  new RDSConnectionD7XDB().einlesenPerName(new D7XDB_TUSER_ReadNamePasswort());
		
//		D7XAllgFunktionen.log("Output :"+lErg.toString());
//		D7XAllgFunktionen.log("<-- handleRequest");
//		return lErg;
		
		
		return null;

	}

}
