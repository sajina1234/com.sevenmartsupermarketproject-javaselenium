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
}
