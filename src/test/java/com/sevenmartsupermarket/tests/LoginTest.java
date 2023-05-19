package com.sevenmartsupermarket.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.base.Data_Provider;
import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.utilities.ExcelReader;



public class LoginTest extends Base {
	LoginPage loginpage;
	ExcelReader excelreader;

	

	@Test
	public void verifyLoginFunctionality() {
		loginpage = new LoginPage(driver);
		loginpage.loginUtility();
		String actualProfileName = loginpage.getProfileText();
		Assert.assertEquals(actualProfileName, Constants.EXPECTED_PROFILE_NAME);
	}

	@Test(dataProvider = "Logindata",dataProviderClass = Data_Provider.class)
	public void verifyInvalidLogin(String username,String passwrd) {
		loginpage = new LoginPage(driver);
		loginpage.loginUtility(username, passwrd);
		String actualErrorMessage = loginpage.getErrorMessage();
		Assert.assertEquals(actualErrorMessage, Constants.EXPECTED_INVALIDLOGIN_ERROR_MESSAGE);

	}
	@Test
	public void verifyInvalidLoginErrorMessage() {
		loginpage = new LoginPage(driver);
		excelreader=new ExcelReader();
		excelreader.setExcelFile("logindata","invalidlogincredentials");
		String userName=excelreader.getCellData(0, 0);
		String password=excelreader.getCellData(0, 1);
		loginpage.loginUtility(userName, password);
		String actualErrorMessage = loginpage.getErrorMessage();
		Assert.assertEquals(actualErrorMessage,Constants.EXPECTED_ERROR_MESSAGE);

	}


	@Test(groups = "smoke")
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
