package com.sevenmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.utilities.GeneralUtility;
import com.sevenmartsupermarket.utilities.PageUtility;

public class ManageSliderPage {
	WebDriver driver;
	PageUtility pageutility;
	GeneralUtility generalutility;
	public ManageSliderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//li[@class='nav-item']//p[contains(text(),'Manage Slider')]")
	private WebElement manageSlider;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement uploadImageElement;
	@FindBy(xpath = "//input[@id='link']")
	private WebElement linkElement;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement successAlertMessage;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[2]")
	private List<WebElement> linkElements;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[3]/a[1]")
	private WebElement statusElement;
	
	/**
	 * method to get click on Mnageslider
	 */
	public void clickManageSlider() {
		PageUtility.element_Click(manageSlider);
		}
	/**
	 * method to click on  New button
	 */
	public void clickNewButton() {
		PageUtility.element_Click(newButton);
	}
	/**
	 * method to input for linkElement
	 * @param linkName
	 */
public void inputLinkElement(String linkName) {
	PageUtility.element_SendKeys(linkElement, linkName);
}
/**
 * method to upload image
 * @param imageName
 */
public void uploadImage(String imageName) {
	pageutility=new PageUtility(driver);
	pageutility.fileUpload(uploadImageElement, imageName);
	}
/**
 * method to click save button
 */
public void clicksaveButton() {
	PageUtility.element_Click(saveButton);
}
/**
 * method to add pageSliders
 * @param imageName
 * @param linkName
 */
public void addPageSliders(String imageName,String linkName) {
	clickNewButton();
	inputLinkElement(linkName);
	 uploadImage(imageName);
	 clicksaveButton();
}
/**
 * method to check for successAlert is displayed or not
 * @return
 */
public boolean successAlertMessageIsDisplayed() {
	return successAlertMessage.isDisplayed();
}
/**
 * method to click on deActivateButton
 * @param link
 */
public void clickOnDeActivationButton(String link) {
	generalutility=new GeneralUtility(driver);
	pageutility=new PageUtility(driver);
	List<String> linkNames= new ArrayList<String>();
	linkNames=generalutility.GetTextOfElements(linkElements);
	int i=0;
	for(i=0;i<linkNames.size();i++) {
		if(link.equals(linkNames.get(i))) {
			i++;
			break;
		}
	}
	WebElement deActivateButton=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']/tbody/tr["+i+"]/td[3]/a[1]"));
	pageutility.scrollAndClick(deActivateButton);
	
}
/**
 * method to status of the link
 * @param link
 * @return
 */
public String getLinkStatusText(String link) {
	generalutility=new GeneralUtility(driver);
	pageutility=new PageUtility(driver);
	List<String> linkNames= new ArrayList<String>();
	linkNames=generalutility.GetTextOfElements(linkElements);
	int i=1;
	for(i=1;i<linkNames.size();i++) {
		if(link.equals(linkNames.get(i))) 
			i++;
			break;
		}
	WebElement deActivateButton=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']/tbody/tr["+i+"]/td[3]/a[1]"));
	return deActivateButton.getText();
	}
}