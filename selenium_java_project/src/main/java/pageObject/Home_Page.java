package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {

	@FindBy(xpath = "//a[text()='Log out']")
	private WebElement logoutButton;
	
	
	public Home_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

	public WebElement getLogoutButton() {
		return logoutButton;
	}

	//Business Library
	
	public void click_on_LogoutButton() {
		logoutButton.click();
	}
	
}
