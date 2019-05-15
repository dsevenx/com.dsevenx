package com.desvenx.db.user.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.desvenx.db.D7XAllgFunktionen;
import com.desvenx.db.user.RDSConnectionD7XDB;
import com.desvenx.db.user.inout.D7XDB_TUserReadHighScoreIn;
import com.desvenx.db.user.inout.D7XDB_TUserReadHighScoreOut;

public class D7XDBRequestHandlerOnly4Check implements RequestHandler<D7XDB_TUserReadHighScoreIn, D7XDB_TUserReadHighScoreOut> {

	@Override
	public D7XDB_TUserReadHighScoreOut handleRequest(D7XDB_TUserReadHighScoreIn pInput, Context pContext) {
		
		System.out.println("-->"+pInput);
		D7XDB_TUserReadHighScoreOut lErg =  new D7XDB_TUserReadHighScoreOut();
		
		lErg.setD7XDB_Erg("Schauen wir mal :"+pInput.toString());
		
		return lErg;
	}

}
