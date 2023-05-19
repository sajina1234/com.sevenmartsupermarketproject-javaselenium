package com.sevenmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.utilities.PageUtility;
import com.sevenmartsupermarket.utilities.WaitUtility;

public class ManageDeliveryBoyPage {
	WebDriver driver;
	PageUtility pageutility;
	WaitUtility waitutility;
	@FindBy(xpath = "//li[@class='nav-item']//p[contains(text(),'Manage Delivery Boy')]")
	private WebElement manageDeliveryBoy;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath = "//input[@id='name']")
	private WebElement nameField;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailField;
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phonenumberField;
	@FindBy(xpath = "//textarea[@name='address']")
	private WebElement addressField;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement userNameField;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement deliveryBoyCreationAlert;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	@FindBy(xpath = "//input[@id='un']")
	private WebElement search_Name;
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement search_Search;
	@FindBy(xpath = "(//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1])[1]")
	private WebElement searchResult;
	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	/**
	 * method to click managedeliveryboy
	 */
public void clickManageDeliveryBoy() {
	manageDeliveryBoy.click();
}
/**
 * method to add new delivery boy
 * @param name
 * @param eMail
 * @param phoneNumber
 * @param address
 * @param userName
 * @param password
 */
public void addNewDeliveryBoy(String name,String eMail,String phoneNumber,String address,String userName,String password) {
	newButton.click();
	nameField.sendKeys(name);
	emailField.sendKeys(eMail);
	phonenumberField.sendKeys(phoneNumber);
	addressField.sendKeys(address);
	userNameField.sendKeys(userName);
	passwordField.sendKeys(password);
}
/**
 * method to  scrollandclick save button
 */
public void clickSaveButton()
{
	pageutility=new PageUtility(driver);
	waitutility=new WaitUtility(driver);
	waitutility.waitForElementToBeVisible(saveButton);
	pageutility.scrollAndClick(saveButton);
	
}
/**
 * method to get success alert text  
 * @return boolean
 */
public boolean getResultText() {
	String deliveryBoyCreationAlertResult = deliveryBoyCreationAlert.getText();
	if (deliveryBoyCreationAlertResult.contains("Delivery Boy Details Created Successfully"))
		return true;

	else
		return false;

}
/**
 * method to search delivery boy
 */
public void searchDeliveryBoy(String deliveryBoyName) {
	searchButton.click();
	search_Name.sendKeys(deliveryBoyName);
	search_Search.click();
	
}
/**
 * method to get search result of delivery boy
 * @return
 */
public String getDeliveryBoySearchResult() {
	return searchResult.getText();
}
}
