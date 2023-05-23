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

public class ManageUsersPage {
	WebDriver driver;
	GeneralUtility generalutility;
	PageUtility pageUtility;
	public ManageUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//p[contains(text(),'Manage Users')])[1]")
	private WebElement manageUsers;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]")
	private List<WebElement> nameElement;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	@FindBy(xpath = "//input[@id='un']")
	private WebElement search_UserName;
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement search_Search;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td")
	private WebElement searchResult;
	
	/**
	 * method to click ManageUsers
	 */
public void clickManageUsers() {
	manageUsers.click();
}
/**
 * method for status DeActivation of users
 * @param name
 */
public void clickOnDeActivationButton(String name) {
	generalutility=new GeneralUtility(driver);
	pageUtility=new PageUtility(driver);
	List<String> userNames= new ArrayList<String>();
	userNames=generalutility.GetTextOfElements(nameElement);
	int i=0;
	for(i=0;i<userNames.size();i++) {
		if(name.equals(userNames.get(i))) {
			i++;
			break;
		}
	}
	WebElement deActivateButton=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']/tbody/tr["+i+"]/td[6]/a[1]"));
	pageUtility.scrollAndClick(deActivateButton);
	deActivateButton.click();
}
/**
 * 	method to get user status
 * @param name
 * @return
 */
public String getUserStatus(String name) {
	generalutility=new GeneralUtility(driver);
	pageUtility=new PageUtility(driver);
	List<String> userNames= new ArrayList<String>();
	userNames=generalutility.GetTextOfElements(nameElement);
	int i=0;
	for(i=0;i<userNames.size();i++) {
		if(name.equals(userNames.get(i))) {
			i++;
			break;
		}
	}
	WebElement status=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']/tbody/tr["+i+"]/td[5]"));
	return status.getText();
}
/**
 * method to delete user
 * @param name
 */
public void deleteUser(String name) {
	generalutility=new GeneralUtility(driver);
	pageUtility=new PageUtility(driver);
	List<String> userNames= new ArrayList<String>();
	userNames=generalutility.GetTextOfElements(nameElement);
	int i=0;
	for(i=0;i<userNames.size();i++) {
		if(name.equals(userNames.get(i))) {
			i++;
			break;
		}
	}
	WebElement deleteButton=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']/tbody/tr["+i+"]/td[6]/a[2]"));
	pageUtility.scrollAndClick(deleteButton);
	pageUtility.alert_Accept();
	deleteButton.click();
	
}
/**
 * method to search user
 * @param user
 */
public void searchUser(String user) {
	searchButton.click();
	search_UserName.sendKeys(user);
	search_Search.click();
	
}
/**
 * method to get search result
 * @return
 */
public String getSearchResult() {
	return searchResult.getText();
}
}
