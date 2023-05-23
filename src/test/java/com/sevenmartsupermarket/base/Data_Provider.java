package com.sevenmartsupermarket.base;

import org.testng.annotations.DataProvider;

import com.sevenmartsupermarket.utilities.ExcelReader;

public class Data_Provider {
	ExcelReader excelreader=new ExcelReader();
	@DataProvider(name="Logindata")
	public Object[][] DataProviderLoginData()
	{
	excelreader.setExcelFile("datalogin","logdatas");
	Object data[][]=excelreader.getMultidimentionalData(3,2);
	return data;
	}
	@DataProvider(name = "DeliveryBoy creation data")
	public Object[][] DataProviderDeliveryBoyCreation() {
		return new Object[][] {
				{ "DeliveryBoy", "deliveryBoy@test.com", "32462", "DeliveryAddress",
						"Deliveryboy239", "988090" },
				{ "DeliveryBoy1", "deliveryBoy1@test.com", "679597", "Address1",
						"Deliveryboy1234", "paswrd" } };
	}
	@DataProvider(name = "AdminUsers creation data")
	public Object[][] DataProviderAdminUsersCreation() {
		return new Object[][] {{"Carlo","a3bnfoivwz7"},{"Erica","dbxeuwa0l6z"}};
	}
	@DataProvider(name="ManagePage creation data")
	public Object[][] DataProviderManagePageData()
	{
	excelreader.setExcelFile("managepage","pagedata");
	Object data[][]=excelreader.getMultidimentionalData(2,4);
	return data;
	}
	@DataProvider(name = "pageslider creation data")
	public Object[][] DataProviderPageSliderCreation() {
		return new Object[][] {{"slideimage.jpg","https:\\sevemmart.com"},
			{"Beautiful.jpg","https:\\grocery.com"},
			{"slideimage.jpg","https://grocerysevenmart.com"}};
	}
	@DataProvider(name = "Expense data")
	public Object[][] DataProviderexpenseCreation() {
		return new Object[][] {{"Daily"},{"Annual"},{"Weekly"},{"Twice a day"}};
	}
}
