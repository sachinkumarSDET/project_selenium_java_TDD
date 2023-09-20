package com.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class propertiesUtility {

	
	public String readData_prop(String key) throws IOException {
		FileInputStream fis = new FileInputStream("/src/test/resources/propertiesFile");
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
	}
}
