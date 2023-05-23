package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.base.Data_Provider;
import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.pages.AdminUsersPage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.utilities.FakerUtility;
import com.sevenmartsupermarket.utilities.GeneralUtility;
import com.sevenmartsupermarket.utilities.ScreenShot;



public class AdminUsersTest extends Base{
	LoginPage loginpage;
	AdminUsersPage adminuserspage;
	

@Test(groups = {"sanity","smoke"})
public void verifyAdminUsers() {
	adminuserspage=new AdminUsersPage(driver);
	loginpage=new LoginPage(driver);
	loginpage.loginUtility();
	adminuserspage.clickOnAdminUsers();
	String user=FakerUtility.getRandomFullName();
	adminuserspage.createUser(user, "admin", "Staff");
	String actualAlertMessage=adminuserspage.getSuccessAlertMessage();
	Assert.assertEquals(actualAlertMessage, Constants.EXPECTED_ALERT_MESSAGE);
}
@Test(groups = "smoke")
public void verifyUserSearch() {
	adminuserspage=new AdminUsersPage(driver);
	loginpage=new LoginPage(driver);
	loginpage.loginUtility();
	adminuserspage.clickOnAdminUsers();
	adminuserspage.clickSearchButton();
	adminuserspage.inputSearchUsers("pf");
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
