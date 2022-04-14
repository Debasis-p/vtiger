package com.crm.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class used to perform operations related to java
 * @author Deb
 *
 */
public class JavaUtility {
	
	/**
	 * This method is used to generate random number
	 * @param limit
	 * @return
	 */
	public static int generateRandomNumber(int limit) {
		Random ran= new Random();
		int randomNumber = ran.nextInt(limit);
		return randomNumber;
	}
	
	/**
	 * This method is used to get the current system date and time in specified format
	 * @return
	 */
	public static String getCurrentTimeAndDate() {
		SimpleDateFormat sdf= new SimpleDateFormat("dd_MM_yy_HH_mm_ss");
		Date date= new Date();
		String requiredDateFormat = sdf.format(date);
		return requiredDateFormat;		
	}
	
	public static long convertStringToLong(String value) {
		 long data = Long.parseLong(value);
		 return data;
	}

}
