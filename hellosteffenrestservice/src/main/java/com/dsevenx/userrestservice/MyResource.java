package com.dsevenx.userrestservice;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.desvenx.db.D7XAllgFunktionen;
import com.desvenx.db.D7XKonstanten;
import com.desvenx.db.user.RDSConnectionD7XDB;
import com.desvenx.db.user.inout.D7XDB_TUserCreateIn;
import com.desvenx.db.user.inout.D7XDB_TUserCreateOut;
import com.desvenx.db.user.inout.D7XDB_TUserDeleteIn;
import com.desvenx.db.user.inout.D7XDB_TUserDeleteOut;
import com.desvenx.db.user.inout.D7XDB_TUserReadHighScoreIn;
import com.desvenx.db.user.inout.D7XDB_TUserReadHighScoreOut;
import com.desvenx.db.user.inout.D7XDB_TUserUpdateIn;
import com.desvenx.db.user.inout.D7XDB_TUserUpdateOut;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {

		StringBuilder lErg = new StringBuilder();

		// HIGH SCORE Auslesen

	//	readHighScoreAus(lErg);

		return lErg.toString();
	}
	 */

	/*
	private void readHighScoreAus(StringBuilder lErg) {

		RDSConnectionD7XDB lRdsConnectionD7XDB = new RDSConnectionD7XDB();

		lErg.append(D7XKonstanten.K_NEW_LINE + "###################### Highscore anzeigen 1");

		ermittelHighScores(lErg, lRdsConnectionD7XDB);

		D7XAllgFunktionen.log(lErg.toString());
		lErg.append(D7XKonstanten.K_NEW_LINE + "###################### Nutzer anlegen");

		int lIDMichael_1 = legeNutzerAn(lErg, lRdsConnectionD7XDB, "Michael");
		D7XAllgFunktionen.log(lErg.toString());

		int lIDMichael_2 = legeNutzerAn(lErg, lRdsConnectionD7XDB, "Michael");
		D7XAllgFunktionen.log(lErg.toString());

		int lIDMichael_3 = legeNutzerAn(lErg, lRdsConnectionD7XDB, "Michael");
		D7XAllgFunktionen.log(lErg.toString());

		lErg.append(D7XKonstanten.K_NEW_LINE + "###################### Highscore anzeigen 2");

		ermittelHighScores(lErg, lRdsConnectionD7XDB);

		D7XAllgFunktionen.log(lErg.toString());
		lErg.append(D7XKonstanten.K_NEW_LINE + "###################### Nutzer updaten");

		updateNutzer(lErg, lRdsConnectionD7XDB, lIDMichael_1, 11, 0);

		updateNutzer(lErg, lRdsConnectionD7XDB, lIDMichael_2, 3, 22);

		ermittelHighScores(lErg, lRdsConnectionD7XDB);
		D7XAllgFunktionen.log(lErg.toString());

		lErg.append(D7XKonstanten.K_NEW_LINE + "###################### Nutzer zweite mal updaten");
		updateNutzer(lErg, lRdsConnectionD7XDB, lIDMichael_2, 92, 222);

		ermittelHighScores(lErg, lRdsConnectionD7XDB);
		D7XAllgFunktionen.log(lErg.toString());

		lErg.append(D7XKonstanten.K_NEW_LINE + "###################### Nutzer löschen");

		deleteNutzer(lErg, lRdsConnectionD7XDB, lIDMichael_1);

		deleteNutzer(lErg, lRdsConnectionD7XDB, lIDMichael_2);

		deleteNutzer(lErg, lRdsConnectionD7XDB, lIDMichael_3);

		ermittelHighScores(lErg, lRdsConnectionD7XDB);
		D7XAllgFunktionen.log(lErg.toString());
	}

	private void updateNutzer(StringBuilder pErg, RDSConnectionD7XDB pRdsConnectionD7XDB, int pID, int pHighScoreEinzel,
			int pHighScoreInsgesamt) {

		D7XDB_TUserUpdateIn lD7XDB_TUserUpdateIn = new D7XDB_TUserUpdateIn();

		lD7XDB_TUserUpdateIn.setID(pID);
		lD7XDB_TUserUpdateIn.setHighScoreEinzel(pHighScoreEinzel);
		lD7XDB_TUserUpdateIn.setHighScoreGesamt(pHighScoreInsgesamt);

		D7XDB_TUserUpdateOut lD7XDB_TUserUpdateOut = pRdsConnectionD7XDB.updateUser(lD7XDB_TUserUpdateIn);

		pErg.append(D7XKonstanten.K_NEW_LINE + "Update ID :" + pID + D7XKonstanten.K_NEW_LINE
				+ lD7XDB_TUserUpdateOut.getD7XDB_Erg().getErgHinweis() + " NAME : " + D7XKonstanten.K_NEW_LINE
				+ lD7XDB_TUserUpdateOut.getName());

	}

	private void deleteNutzer(StringBuilder pErg, RDSConnectionD7XDB pRdsConnectionD7XDB, int pID) {
		D7XDB_TUserDeleteIn lD7XDB_TUserDeleteIn = new D7XDB_TUserDeleteIn();

		lD7XDB_TUserDeleteIn.setID(pID);

		D7XDB_TUserDeleteOut lD7XDB_TUserDeleteOut = pRdsConnectionD7XDB.deleteUser(lD7XDB_TUserDeleteIn);

		pErg.append(D7XKonstanten.K_NEW_LINE + "Delete ID :" + pID + D7XKonstanten.K_NEW_LINE
				+ lD7XDB_TUserDeleteOut.getD7XDB_Erg().getErgHinweis() + " NAME : " + D7XKonstanten.K_NEW_LINE
				+ lD7XDB_TUserDeleteOut.getName());

	}

	private int legeNutzerAn(StringBuilder pErg, RDSConnectionD7XDB pRdsConnectionD7XDB, String pName) {
		D7XDB_TUserCreateIn lD7XDB_TUserCreateIn = new D7XDB_TUserCreateIn();

		lD7XDB_TUserCreateIn.setSTAGE("T");
		lD7XDB_TUserCreateIn.setCOMPANY("D7X");
		lD7XDB_TUserCreateIn.setDOMAIN("BUCHSTABENAPP");
		lD7XDB_TUserCreateIn.setNAME(pName);

		D7XDB_TUserCreateOut lD7XDB_TUserCreateOut = pRdsConnectionD7XDB.createUser(lD7XDB_TUserCreateIn);

		pErg.append(D7XKonstanten.K_NEW_LINE + "Anlegen USER :" + pName + D7XKonstanten.K_NEW_LINE
				+ lD7XDB_TUserCreateOut.getD7XDB_Erg().getErgHinweis() + D7XKonstanten.K_NEW_LINE
				+ lD7XDB_TUserCreateOut.getID() + " " + lD7XDB_TUserCreateOut.getNAME());

		return lD7XDB_TUserCreateOut.getID();

	}

	private void ermittelHighScores(StringBuilder lErg, RDSConnectionD7XDB pRdsConnectionD7XDB) {
		D7XDB_TUserReadHighScoreIn lD7XDB_TUserHighScoreIn = new D7XDB_TUserReadHighScoreIn();

		lD7XDB_TUserHighScoreIn.setmSTAGE("T");
		lD7XDB_TUserHighScoreIn.setmCOMPANY("D7X");
		lD7XDB_TUserHighScoreIn.setmDOMAIN("BUCHSTABENAPP");
		lD7XDB_TUserHighScoreIn.setmOffset(0);
		lD7XDB_TUserHighScoreIn.setmWELCHE(D7XKonstanten.K_EINZEL);

		D7XDB_TUserReadHighScoreOut lD7XDB_TUserHighScoreOutEinzel = pRdsConnectionD7XDB
				.readHighScore(lD7XDB_TUserHighScoreIn);

		lErg.append(D7XKonstanten.K_NEW_LINE + "HIGHSCORE EINZEL " + D7XKonstanten.K_NEW_LINE
				+ lD7XDB_TUserHighScoreOutEinzel.getD7XDB_Erg().getErgHinweis() + D7XKonstanten.K_NEW_LINE
				+ lD7XDB_TUserHighScoreOutEinzel.getHighScoreString());

		lD7XDB_TUserHighScoreIn.setmWELCHE(D7XKonstanten.K_INSGESAMT);

		D7XDB_TUserReadHighScoreOut lD7XDB_TUserHighScoreOutGesamt = pRdsConnectionD7XDB
				.readHighScore(lD7XDB_TUserHighScoreIn);

		lErg.append(D7XKonstanten.K_NEW_LINE + "HIGHSCORE GESAMT " + D7XKonstanten.K_NEW_LINE
				+ lD7XDB_TUserHighScoreOutGesamt.getD7XDB_Erg().getErgHinweis() + D7XKonstanten.K_NEW_LINE
				+ lD7XDB_TUserHighScoreOutGesamt.getHighScoreString());
	}
	*/

	/**
	 * 
	 * /webapi/myresource/createuser?stage=T&company=D7X&domain=BUCHSTABENAPP&name=Frank
	 * 
	 */

	@Path("/createuser")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String doCreate(@QueryParam("stage") String pStage, @QueryParam("company") String pCompany,
			@QueryParam("domain") String pDomain, @QueryParam("name") String pName) {

		RDSConnectionD7XDB lRdsConnectionD7XDB = new RDSConnectionD7XDB();

		D7XDB_TUserCreateIn lD7XDB_TUserCreateIn = new D7XDB_TUserCreateIn();

		lD7XDB_TUserCreateIn.setSTAGE(pStage);
		lD7XDB_TUserCreateIn.setCOMPANY(pCompany);
		lD7XDB_TUserCreateIn.setDOMAIN(pDomain);
		lD7XDB_TUserCreateIn.setNAME(pName);

		D7XDB_TUserCreateOut lD7XDB_TUserCreateOut = lRdsConnectionD7XDB.createUser(lD7XDB_TUserCreateIn);

		return lD7XDB_TUserCreateOut.getNAME() + D7XKonstanten.K_TRENN_NAME + lD7XDB_TUserCreateOut.getID();
	}

	/**
	 * 
	 * /webapi/myresource/updateuser?id=2&he=74&hges=75
	 * 
	 */
	@Path("/updateuser")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String doUpdate(@QueryParam("id") String pid, @QueryParam("he") String pHEinzel, @QueryParam("hges") String pGesamt) {

		RDSConnectionD7XDB lRdsConnectionD7XDB = new RDSConnectionD7XDB();
		
		D7XDB_TUserUpdateIn lD7XDB_TUserUpdateIn = new D7XDB_TUserUpdateIn();

		lD7XDB_TUserUpdateIn.setID(D7XAllgFunktionen.lieferInteger(pid));
		lD7XDB_TUserUpdateIn.setHighScoreEinzel(D7XAllgFunktionen.lieferInteger(pHEinzel));
		lD7XDB_TUserUpdateIn.setHighScoreGesamt(D7XAllgFunktionen.lieferInteger(pGesamt));

		D7XDB_TUserUpdateOut lD7XDB_TUserUpdateOut = lRdsConnectionD7XDB.updateUser(lD7XDB_TUserUpdateIn);

		return lD7XDB_TUserUpdateOut.getName() + D7XKonstanten.K_TRENN_NAME + lD7XDB_TUserUpdateOut.getD7XDB_Erg().getErgHinweis();
	}

	/**
	 * 
	 * /webapi/myresource/readhighscore?stage=T&company=D7X&domain=BUCHSTABENAPP&offset=0&welche=E
	 * 
	 */
	@Path("/readhighscore")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String doReadHighScore(@QueryParam("stage") String pStage, @QueryParam("company") String pCompany,
			@QueryParam("domain") String pDomain, @QueryParam("offset") String poffset,
			@QueryParam("welche") String pwelche) {

		RDSConnectionD7XDB lRdsConnectionD7XDB = new RDSConnectionD7XDB();

		D7XDB_TUserReadHighScoreIn lD7XDB_TUserHighScoreIn = new D7XDB_TUserReadHighScoreIn();

		lD7XDB_TUserHighScoreIn.setmSTAGE("T");
		lD7XDB_TUserHighScoreIn.setmCOMPANY("D7X");
		lD7XDB_TUserHighScoreIn.setmDOMAIN("BUCHSTABENAPP");
		lD7XDB_TUserHighScoreIn.setmOffset(D7XAllgFunktionen.lieferInteger(poffset));
		lD7XDB_TUserHighScoreIn.setmWELCHE(pwelche);

		D7XDB_TUserReadHighScoreOut lD7XDB_TUserHighScoreOutEinzel = lRdsConnectionD7XDB
				.readHighScore(lD7XDB_TUserHighScoreIn);

		return lD7XDB_TUserHighScoreOutEinzel.getHighScoreString();
	}
}
