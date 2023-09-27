package com.genericUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.Home_Page;
import pageObject.Login_Page;

public class Base_Class {

	webdriverUtility webDriverUtiltiy = new webdriverUtility();
	ExcelUtility excelUtiltiy = new ExcelUtility();
	propertiesUtility propUtiltiy = new propertiesUtility();
	databaseUtility dbUtility = new databaseUtility();
	public static WebDriver driver;
	static WebDriver sdriver;
	
	
	public Login_Page loginPage = new Login_Page(driver);
	public Home_Page homePage = new Home_Page(driver);
	
	
	
	/*
	 * @sachinkumar_biradar
	 * Connect to the database using valid URL, username and password
	 */
	public void connection_To_DB(String URL, String username, String password) throws Throwable {
		dbUtility.connectToDB(URL, username, password);
	}
	
	/*
	 * @sachinkumar_biradar
	 * Close connection from the database
	 */
	public void close_connection_from_DB() throws SQLException {
		dbUtility.closeFromDB();
	}
	
	/*
	 * @sachinkumar_biradar
	 * Launch the required browser
	 */
	@Parameters("BROWSER")
	@BeforeClass
	public void launch_Browser(String browser) {
		
	 switch (browser) {
	 case "chrome":
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--remote-allow-origins=*");
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver(options);
		 break;
	 case "firefox":
		 WebDriverManager.firefoxdriver().setup();
		 driver = new FirefoxDriver();
		 break;
	 case "edge":
		 WebDriverManager.edgedriver().setup();
		 driver = new EdgeDriver();
		 break;
	 default: 
		 System.out.println("Browser is invalid");
	 }
	    webDriverUtiltiy.maximizeBrowser(driver);
		webDriverUtiltiy.implicityWait(driver, 10);
	}
	
	/*
	 * @author sachinkumar_biradar
	 * close the browser
	 */
	@AfterClass
	public void close_browser() {
		driver.quit();
	}
	
	/*
	 * @author sachinkumar_biradar
	 * Login to the application
	 */
	@BeforeMethod
	public void login_application() throws IOException {
		driver.get(propUtiltiy.readData_prop("URL"));
		loginPage.enter_Username(propUtiltiy);
		loginPage.enter_Password(propUtiltiy);
		loginPage.click_submit();
		
		
	}
	
	/*
	 * @author sachinkumar_biradar
	 * Logout from the application
	 */
	public void logout_application() {
		homePage.click_on_LogoutButton();
	}
	
}
