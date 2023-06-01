package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.dataprovider.*;
import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ManageDeliveryBoyPage;
import com.sevenmartsupermarket.utilities.ExcelReader;
import com.sevenmartsupermarket.utilities.FakerUtility;
import com.sevenmartsupermarket.utilities.GeneralUtility;
import com.sevenmartsupermarket.utilities.PageUtility;

public class ManageDeliveryBoyTest extends Base {
	LoginPage loginpage;
	ExcelReader excelreader;
	ManageDeliveryBoyPage managedeliveryboypage;

	@Test
	public void verifyDeliveryBoy() {
		loginpage = new LoginPage(driver);
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		excelreader = new ExcelReader();
		loginpage.loginUtility();
		managedeliveryboypage.clickManageDeliveryBoy();
		String Name = FakerUtility.getRandomFullName();
		String Address = FakerUtility.getRandomAddress();
		String UserName = FakerUtility.getRandomName();
		String EMail = FakerUtility.getRandomLastName() + "@gmail.com";
		excelreader.setExcelFile("project test data", "Sheet11");
		String phone = excelreader.getCellData(0, 0);
		String password = excelreader.getCellData(0, 1);
		managedeliveryboypage.addNewDeliveryBoy(Name, EMail, phone, Address, UserName, password);
		managedeliveryboypage.clickSaveButton();
		boolean actualAlertText = managedeliveryboypage.getResultText();
		Assert.assertTrue(actualAlertText);
	}

	@Test(dataProvider = "DeliveryBoy creation data", dataProviderClass = Data_Provider.class)
	public void verifyDeliveryBoyWithDataProvider(String Name, String mailId, String phone, String Adress,
			String UserName, String Passwrd) {
		loginpage = new LoginPage(driver);
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		loginpage.loginUtility();
		managedeliveryboypage.clickManageDeliveryBoy();
		Name = FakerUtility.getRandomFullName();
		UserName = FakerUtility.getRandomName();
		managedeliveryboypage.addNewDeliveryBoy(Name, mailId, phone, Adress, UserName, Passwrd);
		managedeliveryboypage.clickSaveButton();
		boolean actualAlertText = managedeliveryboypage.getResultText();
		Assert.assertTrue(actualAlertText);

	}

	@Test
	public void verifyDeliveryBoySearch() {
		loginpage = new LoginPage(driver);
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		excelreader = new ExcelReader();
		loginpage.loginUtility();
		managedeliveryboypage.clickManageDeliveryBoy();
		excelreader.setExcelFile("project test data", "Sheet12");
		String deliveryBoy = excelreader.getCellData(0, 0);
		managedeliveryboypage.searchDeliveryBoy(deliveryBoy);
		String actualSearchResult = managedeliveryboypage.getDeliveryBoySearchResult();
		Assert.assertEquals(actualSearchResult, Constants.EXPECTED_DELIVERYBOY_SEARCH_RESULT);
	}
}
