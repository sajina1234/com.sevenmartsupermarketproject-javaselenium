package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ManageLocationPage;

public class ManageLocationTest extends Base {
	ManageLocationPage managelocationpage;
	LoginPage loginpage;

@Test
public void verifyCreationOfLocation() {
	loginpage=new LoginPage(driver);
	managelocationpage=new ManageLocationPage(driver);
	loginpage.loginUtility();
	managelocationpage.clickManageLocation();
	managelocationpage.locationCreation(1,"Aberdeen","adgdfgf","₹1000");
	Assert.assertTrue(managelocationpage.checkSuccessAlertMesageIsDisplayed());
}
}