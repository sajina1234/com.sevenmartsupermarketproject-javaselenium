package com.sevenmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.utilities.PageUtility;

public class ManagePagesPage {
	WebDriver driver;
	PageUtility pageutility;
	public ManagePagesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//li[@class='nav-item has-treeview']//p[contains(text(),'Manage Content')]")
	private WebElement manageContent;
	@FindBy(xpath = "//p[contains(text(),'Manage Pages')]")
	private WebElement managePages;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath = "//input[@id='title']")
	private WebElement titleElement;
	@FindBy(xpath = "//div[@class='note-editable card-block']")
	private WebElement descriptionElement;
	@FindBy(xpath = "//input[@placeholder='Enter Page Name']")
	private WebElement pagenameElement;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement uploadElement;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement alertMessage;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	@FindBy(xpath = "//input[@placeholder='Title']")
	private WebElement searchTitleElement;
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement searchElement;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]")
	private WebElement pageSearchResult;
	
	/**
	 * method to click on managecontent
	 */
public void clickManageContent() {
	PageUtility.element_Click(manageContent);
}
/**
 * method to click manage pages
 */
public void clickManagePages() {
	PageUtility.element_Click(managePages);
}
/**
 * method to click new button
 */
public void clickNewButton() {
	PageUtility.element_Click(newButton);
}
/**
 * method to input title element
 * @param title
 */
public void inputTitle(String title) {
	PageUtility.element_SendKeys(titleElement, title);
}
/**
 * method to input description
 * @param description
 */
public void inputDescription(String description) {
	PageUtility.element_SendKeys(descriptionElement, description);
}
/**
 * method to input page name
 * @param pageName
 */
public void inputPageName(String pageName) {
	PageUtility.element_SendKeys(pagenameElement, pageName);
	}
/**
 * method to upload image content
 * @param imageName
 */
public void uploadPageContentImage(String imageName) {
	pageutility=new PageUtility(driver);
	pageutility.fileUpload(uploadElement, imageName);
	}
/**
 * method to click on save button
 */
public void clickSaveButton() {
	pageutility=new PageUtility(driver);
	pageutility.scrollAndClick(saveButton);
}
/**
 * method to create page content
 * @param title
 * @param description
 * @param pageName
 * @param imageName
 */
public void addPageContent(String title,String description,String pageName,String imageName) {
	clickNewButton();
	inputTitle(title);
	inputDescription(description);
	inputPageName(pageName);
	uploadPageContentImage(imageName);
	clickSaveButton();
}
/**
 * method to check success alert message
 * @return
 */
public boolean checkAlertMessageIsDisplayed() {
	return alertMessage.isDisplayed();
}
/**
 * method to click on search button
 */
public void clickSearchbutton() {
	PageUtility.element_Click(searchButton);
	}
/**
 * method to input search element
 * @param pageTitle
 */
public void inputSearchTitle(String pageTitle) {
	PageUtility.element_SendKeys(searchTitleElement, pageTitle);
	}
/**
 * method to search content
 * @param pageTitle
 */
public void searchPageContent(String pageTitle) {
	clickSearchbutton();
	inputSearchTitle(pageTitle);
	searchElement.click();
}
/**
 * method to get serach result
 * @return
 */
public String getPageSearchResult() {
	return pageSearchResult.getText();
	}
}
