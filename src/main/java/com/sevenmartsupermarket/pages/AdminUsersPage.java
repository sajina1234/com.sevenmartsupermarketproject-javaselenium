package com.sevenmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.utilities.PageUtility;

public class AdminUsersPage {
	WebDriver driver;
	PageUtility pageutility;

	@FindBy(xpath = "//li[@class='nav-item']//p[contains(text(),'Admin Users')] ")
	private WebElement adminUsers;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement userNameElement;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordElement;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement userTypeElement;
	@FindBy(xpath = "//div[@class='card-footer center']//button[@type='submit']")
	private WebElement saveButton;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	private WebElement successAlertMessage;
@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
private WebElement searchButton;
@FindBy(xpath = "//input[@id='un']")
private WebElement searchUserNameElement;
@FindBy(xpath = "//button[@name='Search']")
private WebElement searchField;
@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]")
private WebElement searchResult;
	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnAdminUsers() {

		adminUsers.click();
	}

	public void clickOnNewButton() {
		newButton.click();
	}

	public void inputUserName(String userName) {
		userNameElement.sendKeys(userName);
	}

	public void inputPassword(String password) {
		passwordElement.sendKeys(password);
	}

	public void createUser(String usersName, String password, String userType) {
		pageutility = new PageUtility(driver);
		clickOnNewButton();
		inputUserName(usersName);
		inputPassword(password);
		pageutility.select_ByVisibleText(userType, userTypeElement);
		clickOnSaveButton();
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}

	public String getSuccessAlertMessage() {
		return successAlertMessage.getText();

	}
	public String searchUsers() {
		searchButton.click();
		searchUserNameElement.sendKeys("pf");
		searchField.click();
		return searchResult.getText();
		
	}
}
