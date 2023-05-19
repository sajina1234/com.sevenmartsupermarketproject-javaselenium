package com.sevenmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.utilities.PageUtility;

public class ManagePagesPage {
	WebDriver driver;
	PageUtility pageutility;
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
	public ManagePagesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
public void clickManageContent() {
	manageContent.click();
}
public void clickManagePages() {
	managePages.click();
}
public void clickNewButton() {
	newButton.click();
}
public void inputTitle(String title) {
	 titleElement.sendKeys(title);
}
public void inputDescription(String description) {
	descriptionElement.sendKeys(description);
}
public void inputPageName(String pageName) {
	pagenameElement.sendKeys(pageName);
	}
public void uploadPageContentImage(String imageName) {
	pageutility=new PageUtility(driver);
	pageutility.fileUpload(uploadElement, imageName);
	}
public void clickSaveButton() {
	pageutility=new PageUtility(driver);
	pageutility.scrollAndClick(saveButton);
}
public void addPageContent(String title,String description,String pageName,String imageName) {
	clickNewButton();
	inputTitle(title);
	inputDescription(description);
	inputPageName(pageName);
	uploadPageContentImage(imageName);
	clickSaveButton();
}
public boolean checkAlertMessageIsDisplayed() {
	return alertMessage.isDisplayed();
}
public void clickSearchbutton() {
	searchButton.click();
}
public void inputSearchTitle(String pageTitle) {
	searchTitleElement.sendKeys(pageTitle);
}
public void searchPageContent(String pageTitle) {
	clickSearchbutton();
	inputSearchTitle(pageTitle);
	searchElement.click();
}
public String getPageSearchResult() {
	return pageSearchResult.getText();
	}
}
