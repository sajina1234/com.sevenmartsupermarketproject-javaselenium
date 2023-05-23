package com.sevenmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sevenmartsupermarket.utilities.GeneralUtility;
import com.sevenmartsupermarket.utilities.PageUtility;

public class ManageLocationPage {
	WebDriver driver;
	GeneralUtility generalutility;
	PageUtility pageutility;
	public ManageLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//li[@class='nav-item']//p[contains(text(),'Manage Location')]")
	private WebElement manageLocation;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath = "//select[@id='country_id']")
	private WebElement countryElement;
	@FindBy(xpath = "//select[@class='form-control selectpicker' and @id='st_id']")
	private WebElement stateElement;
	@FindBy(xpath = "//input[@id='location']")
	private WebElement locationElement;
	@FindBy(xpath = "//input[@id='delivery']")
	private WebElement deliveryChargeElement;
	@FindBy(xpath = "//button[@name='create']")
	private WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement successAlertMessage;
	/**method to click on manage location
	 */
public void clickManageLocation() {
	manageLocation.click();
}
/**
 * method to click new button
 */
public void clickNewButton() {
	newButton.click();
}
/**
 * method to input country field
 * @param index
 */
public void inputCountry(int index) {
	pageutility=new PageUtility(driver);
	countryElement.click();
	pageutility.select_ByIndex(index, countryElement);;
	
}
/**
 * method to input state field
 * @param text
 */
public void inputState(String text) {
	pageutility=new PageUtility(driver);
	stateElement.click();
	pageutility.select_ByVisibleText(text, stateElement);
	
}
/**
 * method to input location field
 * @param location
 */
public void inputLocation(String location) {
	locationElement.sendKeys(location);
	
}
/**
 * method to input delivery charge
 * @param charge
 */
public void InputDeliveryCharge(String charge) {
	deliveryChargeElement.sendKeys(charge);
}
/**
 * method to click on save button
 */
public void clickSavebutton() {
	saveButton.click();
}
/**
 * method to create location
 * @param index
 * @param text
 * @param location
 * @param charge
 */
public void locationCreation(int index,String text,String location,String charge) {
	clickNewButton();
	inputCountry(index);
	inputState(text);
	inputLocation(location);
	InputDeliveryCharge(charge);
	clickSavebutton();
}
/**
 * method to check loaction creation success alert message
 * @return
 */
public boolean checkSuccessAlertMesageIsDisplayed() {
	generalutility=new GeneralUtility(driver);
	return generalutility.is_Displayed(successAlertMessage);
	
}
}
