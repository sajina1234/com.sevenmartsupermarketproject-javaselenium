package com.sevenmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageExpensePage {
	WebDriver driver;
	public ManageExpensePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//p[contains(text(),'Manage Expense')])[1]")
	private WebElement manageExpense;
@FindBy(xpath = "//p[text()='Expense Category']")
private WebElement expenseCategory; 
@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
private WebElement newButton;
@FindBy(xpath = "//input[@id='name']")
private WebElement titleElement; 
@FindBy(xpath = "//button[@name='Create']")
private WebElement savebutton;
@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
private WebElement SuccessAlert;
/**
 * method to click on manageexpense
 */
public void clickOnManageExpense() {
	manageExpense.click();
	
}
/**
 * method to click on expensecategory
 */
public void clickonExpenseCategory() {
	expenseCategory.click();
}
/**
 * method to click on new button
 */
public void clickOnNewButton() {
	newButton.click();
}
/**
 * method to input title element
 * @param title
 */
public void inputExpenseTitle(String title) {
	titleElement.sendKeys(title);
}
/**
 * method to click on save button
 */
public void clickOnSaveButton() {
	savebutton.click();
}
/**
 * method to create expense category
 * @param title
 */
public void expenseCategoryCreation(String title) {
	clickOnManageExpense();
	clickonExpenseCategory();
	clickOnNewButton();
	inputExpenseTitle(title);
	clickOnSaveButton();
	}
/**
 * method to check the expense creation success alert message
 * @return boolean
 */
public boolean checkSuccessAlert() {
	String ExpenseCreationAlert=SuccessAlert.getText();
	if(ExpenseCreationAlert.contains("Expense Category Created Successfully"))
		return true;
	else
		return false;
}
}
