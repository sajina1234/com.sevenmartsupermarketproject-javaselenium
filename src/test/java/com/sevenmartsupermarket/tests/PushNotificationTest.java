package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.PushNotificationPage;
import com.sevenmartsupermarket.utilities.ExcelReader;

public class PushNotificationTest extends Base{
	LoginPage loginpage;
	PushNotificationPage pushnotificationpage;
	ExcelReader excelreader=new ExcelReader();
@Test(groups = "Smoke")
public void verifyPushNotification() {
	loginpage=new LoginPage(driver);
	pushnotificationpage=new PushNotificationPage(driver);
	loginpage.loginUtility();
	pushnotificationpage.clickPushNotification();
	excelreader.setExcelFile("project test data","Sheet4");
	String title=excelreader.getCellData(0, 0);
	String description=excelreader.getCellData(0, 1);
	pushnotificationpage.createPushNotification(title, description);
	Assert.assertTrue(pushnotificationpage.checkSuccessAlertIsDisplayed());
}
}
