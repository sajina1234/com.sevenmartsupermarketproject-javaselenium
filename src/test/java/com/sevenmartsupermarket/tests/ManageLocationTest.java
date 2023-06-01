package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ManageLocationPage;
import com.sevenmartsupermarket.utilities.ExcelReader;

public class ManageLocationTest extends Base {
	ManageLocationPage managelocationpage;
	LoginPage loginpage;
	ExcelReader excelreader;

@Test
public void verifyCreationOfLocation() {
	loginpage=new LoginPage(driver);
	managelocationpage=new ManageLocationPage(driver);
	excelreader=new ExcelReader();
	loginpage.loginUtility();
	managelocationpage.clickManageLocation();
	excelreader.setExcelFile("project test data","Sheet13");
	String state=excelreader.getCellData(0, 1);
	String location=excelreader.getCellData(0, 2);
	String charge=excelreader.getCellData(0, 3);
	managelocationpage.locationCreation(1,state,location,charge);
	Assert.assertTrue(managelocationpage.checkSuccessAlertMesageIsDisplayed());
}
}