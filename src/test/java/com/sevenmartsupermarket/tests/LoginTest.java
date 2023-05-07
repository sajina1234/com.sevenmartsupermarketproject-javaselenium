package com.sevenmartsupermarket.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.utilities.ExcelReader;

public class LoginTest extends Base {
	LoginPage loginpage;
	ExcelReader excelreader;

	@Test
	public void verifyLogo() {
		loginpage = new LoginPage(driver);
		loginpage.loginUtility();
		String actualLogoText = loginpage.getLogoText();
		String expectedLogoText = "7rmart supermarket";
		Assert.assertEquals(actualLogoText, expectedLogoText);

	}

	@Test
	public void verifyLoginFunctionality() {
		loginpage = new LoginPage(driver);
		loginpage.loginUtility();
		String expectedProfileName = "Admin";
		String actualProfileName = loginpage.getProfileText();
		Assert.assertEquals(actualProfileName, expectedProfileName);
	}

	@Test
	public void verifyInvalidLoginErrorMessage() {
		loginpage = new LoginPage(driver);
		excelreader=new ExcelReader();
		excelreader.setExcelFile("logindata","invalidlogincredentials");
		String userName=excelreader.getCellData(0, 0);
		String password=excelreader.getCellData(0, 1);
		loginpage.loginUtility(userName, password);
		//loginpage.loginUtility("avbshj", "dffhjg");
		String actualErrorMessage = loginpage.getErrorMessage();
		String expectedErrorMessage = "Alert!";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

	}

	@Test
	public void verifyRememberCheckBox() {
		loginpage = new LoginPage(driver);
		boolean actualResult = loginpage.is_RememberCheckBoxDisplayed();
		Assert.assertTrue(actualResult);
	}

	@Test
	public void verifySignInButtonEnabled() {
		loginpage = new LoginPage(driver);
		boolean actualResult = loginpage.is_SignInButtonEnabled();
		Assert.assertTrue(actualResult);
	}
}
