package com.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	/*
	 * @sachinkumar_biradar
	 * generate random number
	 */
	public int random_number() {
		Random random = new Random();
		return random.nextInt(1000);
	}
	
	/*
	 * @author Sachinkumar_Biradar
	 * fetch date 
	 */
	public String getSystemDateAndtime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("DD-MM-YYYY hh:mm:ss");
		Date systemdate = new Date();
		String dateAndTime = dateFormat.format(systemdate);
		System.out.println(dateAndTime);
		return dateAndTime.replaceAll(":", "-");
	}
}
