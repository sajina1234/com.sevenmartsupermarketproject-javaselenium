package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
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
		String expectedStatus="Active";
		Assert.assertEquals(actualStatus, expectedStatus);
		
	}
	@Test
	public void verifyUserSearch() {
		manageuserspage=new ManageUsersPage(driver);
		loginpage=new LoginPage(driver);
		loginpage.loginUtility();
		manageuserspage.clickManageUsers();
		manageuserspage.deleteUser("Neena Neena");
		manageuserspage.searchUser("Neena Neena");
		String actualResult=manageuserspage.getSearchResult();
		String expectedResult=".........RESULT NOT FOUND.......";
	    Assert.assertEquals(actualResult, expectedResult);
	}

}
