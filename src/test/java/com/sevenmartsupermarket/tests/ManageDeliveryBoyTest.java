package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.base.Data_Provider;
import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ManageDeliveryBoyPage;
import com.sevenmartsupermarket.utilities.GeneralUtility;
import com.sevenmartsupermarket.utilities.PageUtility;

public class ManageDeliveryBoyTest extends Base {
	LoginPage loginpage;

	ManageDeliveryBoyPage managedeliveryboypage;

	@Test
	public void verifyDeliveryBoy() {
		loginpage = new LoginPage(driver);
        managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		loginpage.loginUtility();
		managedeliveryboypage.clickManageDeliveryBoy();
		String Name = "sajina"+ GeneralUtility.getTimeStamp();
		managedeliveryboypage.addNewDeliveryBoy(Name, "saj@123", "6345278765", Name, "saji", "45637");
		managedeliveryboypage.clickSaveButton();
		boolean actualAlertText = managedeliveryboypage.getResultText();
		Assert.assertEquals(actualAlertText, true);

	}
	@Test(dataProvider = "DeliveryBoy creation data", dataProviderClass = Data_Provider.class)
	public void verifyDeliveryBoyWithDataProvider(String Name,String mailId,String phone,String Adress,String UserName,String Passwrd) {
		loginpage = new LoginPage(driver);
        managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		loginpage.loginUtility();
		managedeliveryboypage.clickManageDeliveryBoy();
		 Name = "sajina"+ GeneralUtility.getTimeStamp();
		managedeliveryboypage.addNewDeliveryBoy(Name, mailId,phone, Adress, UserName, Passwrd);
		managedeliveryboypage.clickSaveButton();
		boolean actualAlertText = managedeliveryboypage.getResultText();
		Assert.assertEquals(actualAlertText, true);

	}
	@Test
	public void verifyDeliveryBoySearch() {
		loginpage = new LoginPage(driver);
        managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		loginpage.loginUtility();
		managedeliveryboypage.clickManageDeliveryBoy();
		managedeliveryboypage.searchDeliveryBoy("sajin");
		String actualSearchResult=managedeliveryboypage.getDeliveryBoySearchResult();
		Assert.assertEquals(actualSearchResult, Constants.EXPECTED_DELIVERYBOY_SEARCH_RESULT);
	}
}
