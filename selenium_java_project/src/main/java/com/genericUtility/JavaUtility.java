package com.genericUtility;

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
}
