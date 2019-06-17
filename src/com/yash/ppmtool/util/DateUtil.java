package com.yash.ppmtool.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static Timestamp toDate(Date dateToTimeStamp)
	{
		return new Timestamp(dateToTimeStamp.getTime());
	}


	public static String getDateTOString(Date date) {
		SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
		return sdf.format(date);
	}
	
	public static Date stringToDate(String strdate) {
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		try {
			date= sdf.parse(strdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}
