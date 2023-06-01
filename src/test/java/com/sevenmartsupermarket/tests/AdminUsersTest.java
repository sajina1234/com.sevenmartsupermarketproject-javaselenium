package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.dataprovider.*;
import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.pages.AdminUsersPage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.utilities.ExcelReader;
import com.sevenmartsupermarket.utilities.FakerUtility;
import com.sevenmartsupermarket.utilities.GeneralUtility;
import com.sevenmartsupermarket.utilities.ScreenShot;



public class AdminUsersTest extends Base{
	LoginPage loginpage;
	AdminUsersPage adminuserspage;
	ExcelReader excelreader;

@Test(groups = {"sanity","smoke"})
public void verifyAdminUsers() {
	adminuserspage=new AdminUsersPage(driver);
	loginpage=new LoginPage(driver);
	loginpage.loginUtility();
	excelreader=new ExcelReader();
	adminuserspage.clickOnAdminUsers();
	excelreader.setExcelFile("project test data","Sheet10");
	String designation=excelreader.getCellData(0, 1);
	String type=excelreader.getCellData(0, 2);
	String user=FakerUtility.getRandomFullName();
	adminuserspage.createUser(user,designation,type);
	String actualAlertMessage=adminuserspage.getSuccessAlertMessage();
	Assert.assertEquals(actualAlertMessage, Constants.EXPECTED_ALERT_MESSAGE);
}
@Test(groups = "smoke")
public void verifyUserSearch() {
	adminuserspage=new AdminUsersPage(driver);
	loginpage=new LoginPage(driver);
	excelreader=new ExcelReader();
	loginpage.loginUtility();
	adminuserspage.clickOnAdminUsers();
	adminuserspage.clickSearchButton();
	excelreader.setExcelFile("project test data","Sheet9");
	String search=excelreader.getCellData(0, 0);
	adminuserspage.inputSearchUsers(search);
	adminuserspage.clickSearchElement();
	String actualSearchResult=adminuserspage.getSearchresult();
	Assert.assertEquals(actualSearchResult, Constants.EXPECTED_SEARCH_RESULT);
     }
@Test(dataProvider = "AdminUsers creation data", dataProviderClass = Data_Provider.class)
public void verifyAdminUserName(String userName,String password) {
	adminuserspage=new AdminUsersPage(driver);
	loginpage=new LoginPage(driver);
	loginpage.loginUtility();
	adminuserspage.adminLogOut();
	loginpage=new LoginPage(driver);
	loginpage.loginUtility(userName,password);
	boolean actualUserText=adminuserspage.getAdminUserText(userName);
	Assert.assertTrue(actualUserText);
}
}
