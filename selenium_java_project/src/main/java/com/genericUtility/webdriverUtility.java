package com.genericUtility;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webdriverUtility {

	/*
	 * @param
	 * maximize the browser
	 */
	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/*
	 * @param
	 * implicit wait condition
	 */
	public void implicityWait(WebDriver driver, long time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	
	/*
	 * @param
	 * element to be clickable with explicitly wait condition
	 */
	
	public void clickExplicitWait(WebElement element, WebDriver driver, long time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/*
	 * @param
	 * check visibility of element with explicit wait condition
	 */
	public void visibilityExplicitWait(WebElement element, WebDriver driver, long time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/*
	 * @param
	 * check element to selectable with explicit wait condition
	 */
	public void selectedExpplicitlyWait(WebElement element, WebDriver driver, long time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	
	/*
	 * @param
	 * check alert is present or not with explicit wait condition
	 */
	public void alertIsPresenet_ExpelicitlyWait(WebDriver driver, long time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	/*
	 * @param
	 * dropdownn action
	 * select By index
	 */
	public void index_select(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	/*
	 * @param
	 * dropdown action
	 * select by visible text
	 */
	public void visibleText_select(WebElement element, String Text) {
		Select select = new Select(element);
		select.selectByVisibleText(Text);
	}
	
	/*
	 * @param
	 * dropdown action
	 * select by value
	 */
	public void value_select(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	public int optionsCount_select(WebElement element) {
		Select select = new Select(element);
		return select.getOptions().size();
	}
	
	public void index_deSelect(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}
	
	public void value_deSelect(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}
	
	public void text_deSelect(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}
	
	public void moveToElement_Actions(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	public void moveByOffset_Actions(WebDriver driver, int x, int y) {
		Actions action = new Actions(driver);
		action.moveByOffset(x, y).perform();
	}
	
	public void moveToElement_Actions(WebDriver driver, WebElement element, int x, int y) {
		Actions action = new Actions(driver);
		action.moveToElement(element, x, y).perform();
	}
	
	public void contectClick_element_Actions(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}
	
	public void contextClick_Actions(WebDriver driver) {
		Actions action = new Actions(driver);
		action.contextClick().perform();
	}
	
	public void doubleClick_element_actions(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}
	
	public void doubleClick_Actions(WebDriver driver) {
		Actions action = new Actions(driver);
		action.doubleClick().perform();
	}
	
	public void dragAndDrop_Actions(WebDriver driver, int x, int y, WebElement element) {
		Actions action = new Actions(driver);
		action.dragAndDropBy(element, x, y).perform();
	}
	
	public void dragAndDrop_Actions(WebDriver driver, WebElement source, WebElement target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).perform();
	}
	
	public void clickAndHold_action(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.clickAndHold(element).perform();
	}
	
	public void clickAndHold_action(WebDriver driver) {
		Actions action = new Actions(driver);
		action.clickAndHold().perform();
	}
	
	public void click_Action(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.click(element).perform();
	}
	
	public void scrollToElement_Actions(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.scrollToElement(element).perform();
	}
	
	public void fileUpload_Actions(WebDriver driver, String filePath, WebElement element) {
		Actions action = new Actions(driver);
		action.sendKeys(element, filePath);
	}
	
	public void alert_accept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void alert_dismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void alert_getText(WebDriver driver) {
		driver.switchTo().alert().getText();
	}
	
	public void scrollBy_jse(WebDriver driver, int x, int y) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy("+x+", "+y+")");
	}
	
	public void scrollTo_jse(WebDriver driver, int x, int y) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo("+x+", "+y+")");
	}
	
	public void click_disabledElemnt(WebDriver driver, WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", element);
	}
	
	public void sendKeys_to_disabledElement(WebDriver driver, WebElement element, String text) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value=arguments[1]", element, text);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
