package com.desvenx.db;

import java.util.Calendar;

public abstract class D7XAllgFunktionen {

	public static void log(String pMessage) {
		System.out.println("D7XLOG:" + pMessage);
	}

	public static String lieferHeutigenTag() {
		Calendar lCalendar = Calendar.getInstance();

		int lTag = lCalendar.get(Calendar.DAY_OF_MONTH);
		int lMonat = lCalendar.get(Calendar.MONTH)+1;
		int lJahr = lCalendar.get(Calendar.YEAR);

		return String.format("%02d.%02d.%04d", lTag, lMonat, lJahr);
	}

	public static String lieferDatumKorrekt(String pHighScoreDatum) {

		if (pHighScoreDatum != null) {
			if (pHighScoreDatum.length() == 10) {

				if (pHighScoreDatum.indexOf("-") == 4) {
					return pHighScoreDatum.substring(8, 10) + "." + pHighScoreDatum.substring(5, 7) + "."
							+ pHighScoreDatum.substring(0, 4);
				}
				if (pHighScoreDatum.indexOf(".") == 4) {
					return  pHighScoreDatum.substring(8, 10) + "." + pHighScoreDatum.substring(5, 7) + "."
							+ pHighScoreDatum.substring(0, 4);
				}
				if (pHighScoreDatum.indexOf("-") == 2) {
					return pHighScoreDatum.substring(0, 2) + "." + pHighScoreDatum.substring(3, 5) + "."
							+ pHighScoreDatum.substring(6, 10);
				}
				
				return pHighScoreDatum;
			}
		}

		return "01.01.0001";
	}

	public static String lieferUpdate(int pResultSetUpdate) {
		return " RC-Update :" + pResultSetUpdate;
	}

	public static int lieferInteger(String pPoffset) {
		return Integer.parseInt(pPoffset);
	}

}
