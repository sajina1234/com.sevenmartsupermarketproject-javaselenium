package com.sevenmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.utilities.WaitUtility;

public class PushNotificationPage {
	WebDriver driver;

	@FindBy(xpath = "//li[@class='nav-item']//p[contains(text(),'Push Notifications')]")
	private WebElement pushNotification;
	@FindBy(xpath = "//input[@id='title']")
	private WebElement titleElement;
	@FindBy(xpath = "//input[@id='description']")
	private WebElement descriptionElement;
	@FindBy(xpath = "//button[@name='create']")
	private WebElement sendButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement successalertMessage;
	public PushNotificationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	/**
	 * method to get click on pushnotification
	 */
public void clickPushNotification() {
	pushNotification.click();
}
/**
 * method to input value to title element
 * @param title
 */
public void inputTitleElement(String title) {
	titleElement.sendKeys(title);
}
/**
 * method to input values to description element
 * @param description
 */
public void inputDescription(String description) {
	descriptionElement.sendKeys(description);
}
/**
 * method to click send button
 */
public void clickSendButton() {
	sendButton.click();
}
/**
 * method to create push notification
 * @param title
 * @param description
 */
public void createPushNotification(String title,String description) {
	inputTitleElement(title);
	inputDescription(description);
	clickSendButton();
	
}
public boolean checkSuccessAlertIsDisplayed() {
	return successalertMessage.isDisplayed();
}
}
