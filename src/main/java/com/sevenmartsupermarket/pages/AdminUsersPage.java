package com.sevenmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.utilities.GeneralUtility;
import com.sevenmartsupermarket.utilities.PageUtility;
import com.sevenmartsupermarket.utilities.WaitUtility;

public class AdminUsersPage {
	WebDriver driver;
	PageUtility pageutility;
	GeneralUtility generalutility;
	WaitUtility waitutility;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

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
	@FindBy(xpath = "//a[@class='nav-link' and @data-toggle='dropdown']")
	private WebElement adminRight;
	@FindBy(xpath = "//a[@class='dropdown-item']//following::i[@class='ace-icon fa fa-power-off']")
	private WebElement logoutElement;
	@FindBy(xpath = "//a[@class='d-block']")
	private WebElement adminLeft;

	/**
	 * method to click admin users
	 */
	public void clickOnAdminUsers() {
PageUtility.element_Click(adminUsers);
		
	}

	/**
	 * method to get click new button
	 */
	public void clickOnNewButton() {
		PageUtility.element_Click(newButton);
		
	}

	/**
	 * method to inputdata for username field
	 * @param userName
	 */
	public void inputUserName(String userName) {
		PageUtility.element_SendKeys(userNameElement,userName);
		userNameElement.sendKeys(userName);
	}

	/**
	 * method to input data for password field
	 * @param password
	 */
	public void inputPassword(String password) {
		PageUtility.element_SendKeys(passwordElement,password);
		passwordElement.sendKeys(password);
	}

	/**
	 * method to create user
	 * @param usersName
	 * @param password
	 * @param userType
	 */
	public void createUser(String usersName, String password, String userType) {
		pageutility = new PageUtility(driver);
		clickOnNewButton();
		inputUserName(usersName);
		inputPassword(password);
		pageutility.select_ByVisibleText(userType, userTypeElement);
		clickOnSaveButton();
	}

	/**
	 * method to click save button
	 */
	public void clickOnSaveButton() {
		waitutility = new WaitUtility(driver);
		waitutility.waitForElementToBeClickable(saveButton);
		PageUtility.element_Click(saveButton);
		
	}

	/**
	 * method to get user creation success message
	 * @return string
	 */
	public String getSuccessAlertMessage() {
		return successAlertMessage.getText();
	}

	/**
	 * method to click search button
	 */
	public void clickSearchButton() {
		PageUtility.element_Click(searchButton);
		
	}

	/**
	 * method to search users
	 * 
	 * @return
	 */
	public void inputSearchUsers(String username) {
		PageUtility.element_SendKeys(searchUserNameElement, username);
		
	}

	/**
	 * method to click searchElement
	 */
	public void clickSearchElement() {
		PageUtility.element_Click(searchField);
	
	}

	/**
	 * method to get searchresult
	 * 
	 * @return string
	 */
	public String getSearchresult() {
		return searchResult.getText();
	}

	/**
	 * method to logout adminusers
	 */
	public void adminLogOut() {
		waitutility = new WaitUtility(driver);
		adminRight.click();
		waitutility.waitForElementToBeVisible(logoutElement);
		PageUtility.element_Click(logoutElement);
	
	}

	/**
	 * method to get text of adminuser
	 * @return string
	 */
	public boolean getAdminUserText(String userName) {
		// return adminLeft.getText();
		if (adminLeft.getText().contains(userName))
			return true;
		else
			return false;
	}

}
