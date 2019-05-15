package com.desvenx.db.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.desvenx.db.D7XAllgFunktionen;
import com.desvenx.db.D7XDB_Erg;
import com.desvenx.db.D7XKonstanten;
import com.desvenx.db.user.inout.D7XDB_TUserCreateIn;
import com.desvenx.db.user.inout.D7XDB_TUserCreateOut;
import com.desvenx.db.user.inout.D7XDB_TUserDeleteIn;
import com.desvenx.db.user.inout.D7XDB_TUserDeleteOut;
import com.desvenx.db.user.inout.D7XDB_TUserReadHighScoreIn;
import com.desvenx.db.user.inout.D7XDB_TUserReadHighScoreOut;
import com.desvenx.db.user.inout.D7XDB_TUserUpdateIn;
import com.desvenx.db.user.inout.D7XDB_TUserUpdateOut;

public class RDSConnectionD7XDB {

	/**
	 * USER nach Namenseingabe anlegen (nur bei APP-Start)
	 */
	public D7XDB_TUserCreateOut createUser(D7XDB_TUserCreateIn pD7XDB_TUserCreateIn) {
		
		D7XDB_TUserCreateOut lErg = new D7XDB_TUserCreateOut();

		Statement lStatement = baueStatementAuf(lErg.getD7XDB_Erg());

		if (lStatement != null) {

			try {

				ResultSet lResultSet = null;

				lResultSet = lStatement
						.executeQuery("select * from D7XDB.TUSER " + "where STAGE = '" + pD7XDB_TUserCreateIn.getSTAGE()
								+ "' " + "  AND COMPANY = '" + pD7XDB_TUserCreateIn.getCOMPANY() + "'"
								+ "  AND DOMAIN = '" + pD7XDB_TUserCreateIn.getDOMAIN() + "'" + "  AND PLAYERNAME = '"
								+ pD7XDB_TUserCreateIn.getNAME() + "'");

				int lAnzahlTreffer = 0;
				if (lResultSet.next()) {
					lResultSet = lStatement
							.executeQuery("select * from D7XDB.TUSER " + "where STAGE = '" + pD7XDB_TUserCreateIn.getSTAGE()
									+ "' " + "  AND COMPANY = '" + pD7XDB_TUserCreateIn.getCOMPANY() + "'"
									+ "  AND DOMAIN = '" + pD7XDB_TUserCreateIn.getDOMAIN() + "'" + "  AND PLAYERNAME like '"
									+ pD7XDB_TUserCreateIn.getNAME() + "%'");
					
					while (lResultSet.next()) {
						lAnzahlTreffer++;
					}
				}
				String lNameForInsert = pD7XDB_TUserCreateIn.getNAME();
				if (lAnzahlTreffer > 0) {
					if (pD7XDB_TUserCreateIn.getNAME().length() > D7XKonstanten.K_LAENGE_PLAYERNAME_IN_DB - 3) {
						lNameForInsert = pD7XDB_TUserCreateIn.getNAME().substring(0, 47) + " " + lAnzahlTreffer;
					} else {
						lNameForInsert = pD7XDB_TUserCreateIn.getNAME() + " " + lAnzahlTreffer;
					}
				}

				int lResultSetUpdate = lStatement.executeUpdate(
						"INSERT INTO D7XDB.TUSER (STAGE,COMPANY,DOMAIN,PLAYERNAME,PASSWORT,EMAIL,HIGHSCORE_INSGESAMT,HIGHSCORE_EINZEL,HIGHSCORE_INSGESAMT_DATUM,HIGHSCORE_EINZEL_DATUM,DATEN ) "
								+ "VALUES ('" + "T" + "','" + "D7X" + "','" + "BUCHSTABENAPP" + "','" + lNameForInsert
								+ "','','',0,0,'" + D7XAllgFunktionen.lieferHeutigenTag() + "','"
								+ D7XAllgFunktionen.lieferHeutigenTag() + "','DATEN-INIT');");

				lResultSet = lStatement.executeQuery("select * from D7XDB.TUSER " + "where STAGE = '"
						+ pD7XDB_TUserCreateIn.getSTAGE() + "' " + "  AND COMPANY = '"
						+ pD7XDB_TUserCreateIn.getCOMPANY() + "'" + "  AND DOMAIN = '"
						+ pD7XDB_TUserCreateIn.getDOMAIN() + "'" + "  AND PLAYERNAME = '" + lNameForInsert + "'");

				while (lResultSet.next()) {
					D7XAllgFunktionen.log("found " + lResultSet);

					lErg.setID(lResultSet.getInt(D7XDB_TUserRow.K_USERID));
					lErg.setNAME(lNameForInsert);

					lErg.setD7XDB_Erg(D7XKonstanten.K_SUCESS + D7XAllgFunktionen.lieferUpdate( lResultSetUpdate));
				}

			} catch (SQLException pSQLException) {
				lErg.setD7XDB_Erg(pSQLException.toString());
			}
		}

		return lErg;

	}

	/**
	 * USER-Infos mit ID update
	 */
	public D7XDB_TUserUpdateOut updateUser(D7XDB_TUserUpdateIn pD7XDB_TUserUpdateIn) {
		
		D7XDB_TUserUpdateOut lErg = new D7XDB_TUserUpdateOut();
		
		Statement lStatement = baueStatementAuf(lErg.getD7XDB_Erg());

		lErg.setD7XDB_Erg(D7XKonstanten.K_NOT_FOUND);

		if (lStatement != null) {

			try {

				ResultSet lResultSet = null;

				lResultSet = lStatement.executeQuery(
						"select * from D7XDB.TUSER " + "where USERID = " + pD7XDB_TUserUpdateIn.getID() + "");

				if (lResultSet.next()) {

					lErg.setName(lResultSet.getString(D7XDB_TUserRow.K_NAME));
					String lQuery = "update D7XDB.TUSER SET ";

					String lStringHighScoreEinzel = "";
					String lStringHighScoreGesamt = "";

					if (pD7XDB_TUserUpdateIn.getHighScoreEinzel() > 0) {
						lStringHighScoreEinzel = "HIGHSCORE_EINZEL = " + pD7XDB_TUserUpdateIn.getHighScoreEinzel()
								+ " ," + "HIGHSCORE_EINZEL_DATUM = '" + D7XAllgFunktionen.lieferHeutigenTag() + "'";

					}
					if (pD7XDB_TUserUpdateIn.getHighScoreGesamt() > 0) {
						lStringHighScoreGesamt = "HIGHSCORE_INSGESAMT = " + pD7XDB_TUserUpdateIn.getHighScoreGesamt()
								+ " ," + "HIGHSCORE_INSGESAMT_DATUM = '" + D7XAllgFunktionen.lieferHeutigenTag() + "'";
					}

					if (!lStringHighScoreEinzel.isEmpty() && !lStringHighScoreGesamt.isEmpty()) {
						lQuery = lQuery + lStringHighScoreEinzel + "," + lStringHighScoreGesamt;
					} else if (!lStringHighScoreEinzel.isEmpty()) {
						lQuery = lQuery + lStringHighScoreEinzel;
					} else if (!lStringHighScoreGesamt.isEmpty()) {
						lQuery = lQuery + lStringHighScoreGesamt;
					}

					lQuery = lQuery + " where USERID = " + pD7XDB_TUserUpdateIn.getID() + "";

					int lResultSetUpdate = lStatement.executeUpdate(lQuery);

					lErg.setD7XDB_Erg(D7XKonstanten.K_SUCESS +  D7XAllgFunktionen.lieferUpdate( lResultSetUpdate));
				}

			} catch (SQLException pSQLException) {
				lErg.setD7XDB_Erg(pSQLException.toString());
			}
		}
		return lErg;
	}

	/**
	 * USER-Infos mit ID delete
	 */
	public D7XDB_TUserDeleteOut deleteUser(D7XDB_TUserDeleteIn pD7XDB_TUserDeleteIn) {
		D7XDB_TUserDeleteOut lErg = new D7XDB_TUserDeleteOut();

		lErg.setD7XDB_Erg(D7XKonstanten.K_NOT_FOUND);

		Statement lStatement = baueStatementAuf(lErg.getD7XDB_Erg());

		if (lStatement != null) {

			try {

				ResultSet lResultSet = null;

				lResultSet = lStatement.executeQuery(
						"select * from D7XDB.TUSER " + "where USERID = " + pD7XDB_TUserDeleteIn.getID() + "");

				if (lResultSet.next()) {
					
					lErg.setName(lResultSet.getString(D7XDB_TUserRow.K_NAME));

					int lResultSetUpdate = lStatement
							.executeUpdate("delete from D7XDB.TUSER where USERID = " + pD7XDB_TUserDeleteIn.getID());

					lErg.setD7XDB_Erg(D7XKonstanten.K_SUCESS+ D7XAllgFunktionen.lieferUpdate( lResultSetUpdate));
				}

			} catch (SQLException pSQLException) {
				lErg.setD7XDB_Erg(pSQLException.toString());
			}
		}
		return lErg;
	}

	/**
	 * read HighScore
	 */
	public D7XDB_TUserReadHighScoreOut readHighScore(D7XDB_TUserReadHighScoreIn pD7XDB_TUserHighScoreIn) {
		D7XDB_TUserReadHighScoreOut lErg = new D7XDB_TUserReadHighScoreOut();

		Statement lStatement = baueStatementAuf(lErg.getD7XDB_Erg());

		if (lStatement != null) {

			try {
				ResultSet lResultSet = null;

				if (pD7XDB_TUserHighScoreIn.getmWELCHE().equals(D7XKonstanten.K_EINZEL)) {
					lResultSet = lStatement
							.executeQuery("select * from D7XDB.TUSER order by HIGHSCORE_EINZEL desc LIMIT 100 OFFSET "
									+ pD7XDB_TUserHighScoreIn.getmOffset());

				} else {
					lResultSet = lStatement.executeQuery(
							"select * from D7XDB.TUSER order by HIGHSCORE_INSGESAMT desc LIMIT 100 OFFSET "
									+ pD7XDB_TUserHighScoreIn.getmOffset());

				}
				D7XAllgFunktionen.log("lResultSet " + lResultSet);

				lErg.setD7XDB_Erg(D7XKonstanten.K_NOT_FOUND);

				while (lResultSet.next()) {
					D7XAllgFunktionen.log("found " + lResultSet);

					int lHighScore = 0;
					if (pD7XDB_TUserHighScoreIn.getmWELCHE().equals(D7XKonstanten.K_EINZEL)) {
						lHighScore = lResultSet.getInt(D7XDB_TUserRow.K_HIGHSCORE_EINZEL);
					} else {
						lHighScore = lResultSet.getInt(D7XDB_TUserRow.K_HIGHSCORE_INSGESAMT);
					}
					String lHighScoreDatum = "";
					if (pD7XDB_TUserHighScoreIn.getmWELCHE().equals(D7XKonstanten.K_EINZEL)) {
						lHighScoreDatum = lResultSet.getString(D7XDB_TUserRow.K_HIGHSCORE_EINZEL_DATUM);
					} else {
						lHighScoreDatum = lResultSet.getString(D7XDB_TUserRow.K_HIGHSCORE_INSGESAMT_DATUM);
					}

					lErg.addUserMitHighScore(lResultSet.getString(D7XDB_TUserRow.K_NAME), lHighScore, lHighScoreDatum);

					lErg.setD7XDB_Erg(D7XKonstanten.K_SUCESS);
				}

			} catch (SQLException pSQLException) {
				lErg.setD7XDB_Erg(pSQLException.toString());
			}

		}

		return lErg;
	}

	public Statement baueStatementAuf(D7XDB_Erg pD7xdb_Erg) {

		Statement lErg = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			D7XAllgFunktionen.log("com.mysql.cj.jdbc.Driver geladen");

			Connection lConnection = DriverManager.getConnection(D7XKonstanten.K_URL, D7XKonstanten.K_DB_NUTZER,
					D7XKonstanten.K_DB_PASSWORT);
			D7XAllgFunktionen.log("lConnection " + lConnection);

			lErg = lConnection.createStatement();
			D7XAllgFunktionen.log("lStatement " + lErg);

		} catch (SQLException pSQLException) {
			D7XAllgFunktionen.log("pSQLException" + pSQLException.getMessage());
			pD7xdb_Erg.setErgHinweis("SQLException + " + pSQLException.getMessage());
		} catch (ClassNotFoundException pClassNotFoundException) {
			D7XAllgFunktionen.log("fClassNotFoundException" + pClassNotFoundException.getMessage());
			pD7xdb_Erg.setErgHinweis("ClassNotFoundException + " + pClassNotFoundException.getMessage());
		} catch (Throwable pThrowable) {
			D7XAllgFunktionen.log("pThrowable" + pThrowable.getMessage());
			pD7xdb_Erg.setErgHinweis("Throwable + " + pThrowable.getMessage());
		}

		return lErg;
	}

}
