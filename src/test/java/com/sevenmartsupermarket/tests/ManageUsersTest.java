package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ManageUsersPage;

public class ManageUsersTest extends Base {
	LoginPage loginpage;
	ManageUsersPage manageuserspage;
	@Test
	public void verifyUserStatusAction() {
		manageuserspage=new ManageUsersPage(driver);
		loginpage=new LoginPage(driver);
		loginpage.loginUtility();
		manageuserspage.clickManageUsers();
		manageuserspage.clickOnDeActivationButton("CIJIN SJ");
		String actualStatus=manageuserspage.getUserStatus("CIJIN SJ");
		Assert.assertEquals(actualStatus, Constants.EXPECTED_STATUS);
		
	}
	@Test(retryAnalyzer = com.sevenmartsupermarket.listeners.RetryAnalyser.class)
	public void verifyUserSearch() {
		manageuserspage=new ManageUsersPage(driver);
		loginpage=new LoginPage(driver);
		loginpage.loginUtility();
		manageuserspage.clickManageUsers();
		manageuserspage.deleteUser("Neena Neena");
		manageuserspage.searchUser("Neena Neena");
		String actualResult=manageuserspage.getSearchResult();
		Assert.assertEquals(actualResult, Constants.EXPECTED_USER_SEARCH_RESULT);
	}
}
