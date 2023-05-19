package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.pages.HomePagePage;
import com.sevenmartsupermarket.pages.LoginPage;

public class HomePageTest extends Base {
	LoginPage loginpage;
	HomePagePage homepagepage;
	@Test
	public void verifyLogoText() {
		loginpage = new LoginPage(driver);
		homepagepage=new HomePagePage(driver);
		loginpage.loginUtility();
		homepagepage.getResponseCode();
		String actualLogoText = homepagepage.getLogoText();
		Assert.assertEquals(actualLogoText, Constants.EXPECTED_LOGO_TEXT);

	}

}
