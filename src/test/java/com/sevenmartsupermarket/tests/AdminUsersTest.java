package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.base.Data_Provider;
import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.pages.AdminUsersPage;
import com.sevenmartsupermarket.pages.LoginPage;
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
	String user="sajina"+GeneralUtility.getTimeStamp();
	adminuserspage.createUser(user, "admin", "Staff");
	String actualAlertMessage=adminuserspage.getSuccessAlertMessage();
	Assert.assertEquals(actualAlertMessage, Constants.EXPECTED_ALERT_MESSAGE);
}
@Test
public void verifySearch() {
	adminuserspage=new AdminUsersPage(driver);
	loginpage=new LoginPage(driver);
	loginpage.loginUtility();
	adminuserspage.clickOnAdminUsers();
	String actualSearchResult=adminuserspage.searchUsers();
	Assert.assertEquals(actualSearchResult, Constants.EXPECTED_SEARCH_RESULT);
	}
@Test
public void verifyAdminUserName() {
	adminuserspage=new AdminUsersPage(driver);
	loginpage=new LoginPage(driver);
	loginpage.loginUtility();
	adminuserspage.adminLogOut();
	loginpage.loginUtility("sajina11_05_2023_08_07_58", "admin");
	String actualUserText=adminuserspage.getAdminUserText();
	String expectedUserText=" Sajina11_05_2023_08_07_58";
	Assert.assertEquals(actualUserText, expectedUserText);
}
}
