package com.sevenmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.utilities.GeneralUtility;

public class LoginPage {
	WebDriver driver;
	Properties properties = new Properties();
	FileInputStream fileinputstream;
	GeneralUtility generalutility;
	 public LoginPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			try {
				fileinputstream = new FileInputStream(Constants.CONFIG_FILE_PATH);
				properties.load(fileinputstream);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	@CacheLookup
	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameElement;
	@CacheLookup
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordElement;
	@FindBy(xpath = "//button[contains(text(),'Sign In')]")
	private WebElement signInButton;
	@FindBy(xpath = "//label[@for='remember']")
	private WebElement rememberCheckBox;
	@FindBy(xpath = "//div[@class='info']")
	private WebElement profileName;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	private WebElement invalidLoginErrorMessage;
	
  
	/**
	 * method to enter username
	 * @param userName
	 */
	public void enterUserName(String userName) {
		userNameElement.sendKeys(userName);
	}

	/**
	 * method to enter password
	 * @param password
	 */
	public void enterPassword(String password) {
		passwordElement.sendKeys(password);
	}

	/**
	 * method to click signin button
	 */
	public void clickSignInButton() {
		signInButton.click();
	}

	/**
	 * method for login
	 * @param userName
	 * @param password
	 */

	public void loginUtility(String userName, String password) {
		enterUserName(userName);
		enterPassword(password);
		clickSignInButton();
	}

	/**
	 * method for login without parameters
	 */
	public void loginUtility() {
		String userName = properties.getProperty("username");
		String password = properties.getProperty("password");
		enterUserName(userName);
		enterPassword(password);
		clickSignInButton();

	}

	/**
	 * method for checking checkbox is displayed
	 * @return boolean
	 */
	public boolean is_RememberCheckBoxDisplayed() {
		generalutility = new GeneralUtility(driver);
		return generalutility.is_Displayed(rememberCheckBox);

	}
	/**
	 * method for checking signIn button is enabled
	 * @return boolean
	 */
	public boolean is_SignInButtonEnabled() {
		generalutility = new GeneralUtility(driver);
		return generalutility.is_enabled(signInButton);

	}
	/**
	 * method to get invalid login error message
	 * @return
	 */

	public String getErrorMessage() {
		generalutility = new GeneralUtility(driver);
		return generalutility.get_textOfElement(invalidLoginErrorMessage);
	}

	/**
	 * method to read profile name
	 * @return String
	 */
	public String getProfileText() {
		generalutility = new GeneralUtility(driver);
		return generalutility.get_textOfElement(profileName);

	}
	
}
