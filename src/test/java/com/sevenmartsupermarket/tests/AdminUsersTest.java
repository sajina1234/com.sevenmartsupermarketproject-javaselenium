package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.AdminUsersPage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.utilities.GeneralUtility;
import com.sevenmartsupermarket.utilities.ScreenShot;

public class AdminUsersTest extends Base{
	LoginPage loginpage;
	AdminUsersPage adminuserspage;
	
@Test
public void verifyAdminUsers() {
	adminuserspage=new AdminUsersPage(driver);
	loginpage=new LoginPage(driver);
	loginpage.loginUtility();
	adminuserspage.clickOnAdminUsers();
	String user="sajina"+GeneralUtility.getTimeStamp();
	adminuserspage.createUser(user, "admin", "Staff");
	String actualAlertMessage=adminuserspage.getSuccessAlertMessage();
	String expectedAlertMessage="Alert!";
	Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
}
@Test
public void verifySearch() {
	adminuserspage=new AdminUsersPage(driver);
	loginpage=new LoginPage(driver);
	loginpage.loginUtility();
	adminuserspage.clickOnAdminUsers();
	String actualSearchResult=adminuserspage.searchUsers();
	String expectedSearchResult="pf";
	Assert.assertEquals(actualSearchResult, expectedSearchResult);
	
	
}
}
