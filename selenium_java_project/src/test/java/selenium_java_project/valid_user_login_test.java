package selenium_java_project;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.genericUtility.Base_Class;

public class valid_user_login_test extends Base_Class {

	
	@Test
	public void login_valid_user() {
		System.out.println("Logout button display? ==> "+ homePage.getLogoutButton().isDisplayed());
		Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/logged-in-successfully/");
		Assert.assertEquals(driver.getTitle(), "Logged In Successfully | Practice Test Automation");
		System.out.println("Test completed");
	}
}
