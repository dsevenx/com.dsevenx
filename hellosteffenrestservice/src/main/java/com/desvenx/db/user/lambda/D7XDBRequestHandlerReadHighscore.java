package com.desvenx.db.user.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.desvenx.db.D7XAllgFunktionen;
import com.desvenx.db.user.RDSConnectionD7XDB;
import com.desvenx.db.user.inout.D7XDB_TUserReadHighScoreIn;
import com.desvenx.db.user.inout.D7XDB_TUserReadHighScoreOut;

public class D7XDBRequestHandlerReadHighscore implements RequestHandler<D7XDB_TUserReadHighScoreIn, D7XDB_TUserReadHighScoreOut> {

	@Override
	public D7XDB_TUserReadHighScoreOut handleRequest(D7XDB_TUserReadHighScoreIn pInput, Context pContext) {
		
		D7XAllgFunktionen.log("--> D7XDBRequestHandlerReadHighscore");
		D7XAllgFunktionen.log("Input :"+pInput.toString());
		           	
		D7XDB_TUserReadHighScoreOut lD7XDB_TUserReadHighScoreOut = new RDSConnectionD7XDB().readHighScore(pInput);
    	
		D7XAllgFunktionen.log("Outputput :"+lD7XDB_TUserReadHighScoreOut.toString());

		return lD7XDB_TUserReadHighScoreOut;
	}

}
