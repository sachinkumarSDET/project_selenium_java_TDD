package pageObject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.propertiesUtility;

public class Login_Page {

	@FindBy(id = "username")
	private WebElement UserNameTF;
	
	@FindBy(id = "password")
	private WebElement passwordTF;
	
	@FindBy(id = "submit")
	private WebElement submitButton;
	
	public Login_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserNameTF() {
		return UserNameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	//Business library
	public void enter_Username(propertiesUtility prop) {
		try {
			UserNameTF.sendKeys(prop.readData_prop("user_name"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void enter_Password(propertiesUtility prop) {
		try {
			passwordTF.sendKeys(prop.readData_prop("password"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void click_submit() {
		submitButton.click();
	}
}
