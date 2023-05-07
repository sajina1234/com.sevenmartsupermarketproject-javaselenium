package com.sevenmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.PushNotificationPage;
import com.sevenmartsupermarket.utilities.ExcelReader;

public class PushNotificationTest extends Base{
	LoginPage loginpage;
	PushNotificationPage pushnotificationpage;
	ExcelReader excelreader=new ExcelReader();
@Test
public void verifyPushNotification() {
	loginpage=new LoginPage(driver);
	pushnotificationpage=new PushNotificationPage(driver);
	loginpage.loginUtility();
	pushnotificationpage.clickPushNotification();
	excelreader.setExcelFile("pushnotificationdata","notificationdata");
	String title=excelreader.getCellData(0, 0);
	System.out.println(title);
	excelreader.setExcelFile("logindata","invalidlogincredentials");
	String username=excelreader.getCellData(0, 0);
	System.out.println(username);
}
}
