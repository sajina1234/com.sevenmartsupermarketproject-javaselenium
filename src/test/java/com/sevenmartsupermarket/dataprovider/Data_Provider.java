package com.sevenmartsupermarket.dataprovider;

import org.testng.annotations.DataProvider;

import com.sevenmartsupermarket.utilities.ExcelReader;

public class Data_Provider {
	ExcelReader excelreader=new ExcelReader();
	@DataProvider(name="Logindata")
	public Object[][] DataProviderLoginData()
	{
	excelreader.setExcelFile("project test data","Sheet1");
	Object data[][]=excelreader.getMultidimentionalData(3,2);
	return data;
	}
	@DataProvider(name = "DeliveryBoy creation data")
	public Object[][] DataProviderDeliveryBoyCreation() {
		excelreader.setExcelFile("project test data","Sheet7");
		Object data[][]=excelreader.getMultidimentionalData(2,6);
		return data;
	}
	@DataProvider(name = "AdminUsers creation data")
	public Object[][] DataProviderAdminUsersCreation() {
		excelreader.setExcelFile("project test data","Sheet8");
		Object data[][]=excelreader.getMultidimentionalData(2,2);
		return data;
	}
	@DataProvider(name="ManagePage creation data")
	public Object[][] DataProviderManagePageData()
	{
	excelreader.setExcelFile("project test data","Sheet3");
	Object data[][]=excelreader.getMultidimentionalData(2,4);
	return data;
	}
	@DataProvider(name = "pageslider creation data")
	public Object[][] DataProviderPageSliderCreation() {
		excelreader.setExcelFile("project test data","Sheet6");
		Object data[][]=excelreader.getMultidimentionalData(3,2);
		return data;
	}
	@DataProvider(name = "Expense data")
	public Object[][] DataProviderexpenseCreation() {
		excelreader.setExcelFile("project test data","Sheet5");
		Object data[][]=excelreader.getMultidimentionalData(4,1);
		return data;
	}
}
