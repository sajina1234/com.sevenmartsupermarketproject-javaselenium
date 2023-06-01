package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ManageUsersPage;
import com.sevenmartsupermarket.utilities.ExcelReader;

public class ManageUsersTest extends Base {
	LoginPage loginpage;
	ExcelReader excelreader;
	ManageUsersPage manageuserspage;
	@Test
	public void verifyUserStatusAction() {
		manageuserspage=new ManageUsersPage(driver);
		loginpage=new LoginPage(driver);
		excelreader=new ExcelReader();
		loginpage.loginUtility();
		manageuserspage.clickManageUsers();
		excelreader.setExcelFile("project test data","Sheet16");
		String user=excelreader.getCellData(0, 0);
		manageuserspage.clickOnDeActivationButton(user);
		String actualStatus=manageuserspage.getUserStatus(user);
		Assert.assertEquals(actualStatus, Constants.EXPECTED_STATUS);
		
	}
	@Test(retryAnalyzer = com.sevenmartsupermarket.listeners.RetryAnalyser.class)
	public void verifyUserSearch() {
		manageuserspage=new ManageUsersPage(driver);
		loginpage=new LoginPage(driver);
		excelreader=new ExcelReader();
		loginpage.loginUtility();
		manageuserspage.clickManageUsers();
		excelreader.setExcelFile("project test data","Sheet16");
		String users=excelreader.getCellData(1, 0);
		manageuserspage.deleteUser(users);
		manageuserspage.searchUser(users);
		String actualResult=manageuserspage.getSearchResult();
		Assert.assertEquals(actualResult, Constants.EXPECTED_USER_SEARCH_RESULT);
	}
}
