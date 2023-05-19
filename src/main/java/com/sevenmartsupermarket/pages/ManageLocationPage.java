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
	public ManageLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
public void clickManageLocation() {
	manageLocation.click();
}
public void clickNewButton() {
	newButton.click();
}
public void inputCountry(int index) {
	pageutility=new PageUtility(driver);
	countryElement.click();
	pageutility.select_ByIndex(index, countryElement);;
	
}
public void inputState(String text) {
	pageutility=new PageUtility(driver);
	stateElement.click();
	pageutility.select_ByVisibleText(text, stateElement);
	
}
public void inputLocation(String location) {
	locationElement.sendKeys(location);
	
}
public void InputDeliveryCharge(String charge) {
	deliveryChargeElement.sendKeys(charge);
}
public void clickSavebutton() {
	saveButton.click();
}
public void locationCreation(int index,String text,String location,String charge) {
	clickNewButton();
	inputCountry(index);
	inputState(text);
	inputLocation(location);
	InputDeliveryCharge(charge);
	clickSavebutton();
}
public boolean checkSuccessAlertMesageIsDisplayed() {
	generalutility=new GeneralUtility(driver);
	return generalutility.is_Displayed(successAlertMessage);
	
}
}
