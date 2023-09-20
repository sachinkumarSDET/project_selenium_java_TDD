package com.genericUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Ignore;

public class Base_Class {

	webdriverUtility webDriverUtiltiy = new webdriverUtility();
	ExcelUtility excelUtiltiy = new ExcelUtility();
	propertiesUtility propUtiltiy = new propertiesUtility();
	databaseUtility dbUtility = new databaseUtility();
	static WebDriver driver;
	
	@Ignore
	@BeforeSuite
	public void connection_To_DB(String URL, String username, String password) throws SQLException {
		dbUtility.connect_To_DB(URL, username, password);
	}
	
	@Ignore
	@AfterSuite
	public void close_connection_from_DB() throws SQLException {
		dbUtility.close_database();
	}
	
	@BeforeClass
	public void launch_Browser(String browser) {
	 switch (browser) {
	 case "chrome":
		 driver = new ChromeDriver();
		 break;
	 case "firefox":
		 driver = new FirefoxDriver();
		 break;
	 case "edge":
		 driver = new EdgeDriver();
		 break;
	 default: 
		 System.out.println("Browser is invalid");
	 }
	}
	
	@AfterClass
	public void close_browser() {
		driver.quit();
	}
	
	@AfterMethod
	public void login_application(String URL) throws IOException {
		driver.get(propUtiltiy.readData_prop(URL));
		webDriverUtiltiy.maximizeBrowser(driver);
		webDriverUtiltiy.implicityWait(driver, 10);
	}
	
	public void logout_application() {
		
	}
	
}
