package org.test.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static Date format(String data) {

		Date date = null;
		try {
			date = sdf.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}
