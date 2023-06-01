package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.dataprovider.*;
import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ManageSliderPage;
import com.sevenmartsupermarket.utilities.ExcelReader;

public class ManageSliderTest extends Base{
	LoginPage loginpage;
	ManageSliderPage managesliderpage;
	ExcelReader excelreader;
	@Test(dataProvider = "pageslider creation data", dataProviderClass = Data_Provider.class)
	public void verifyNewSliderCreation(String imageName,String linkName) {
		loginpage=new LoginPage(driver);
		managesliderpage=new ManageSliderPage(driver);
		loginpage.loginUtility();
		managesliderpage.clickManageSlider();
		managesliderpage.addPageSliders(imageName,linkName);
		Assert.assertTrue(managesliderpage.successAlertMessageIsDisplayed());
	}
@Test
public void verifyLinkStatus() {
	loginpage=new LoginPage(driver);
	managesliderpage=new ManageSliderPage(driver);
	excelreader=new ExcelReader();
	loginpage.loginUtility();
	managesliderpage.clickManageSlider();
	managesliderpage=new ManageSliderPage(driver);
	excelreader.setExcelFile("project test data","Sheet15");
	String link=excelreader.getCellData(0, 0);
	managesliderpage.clickOnDeActivationButton(link);
	String actualLinkStatus=managesliderpage.getLinkStatusText(link);
    Assert.assertEquals(actualLinkStatus,Constants.EXPECTEDLINK_STATUS);
}
}
