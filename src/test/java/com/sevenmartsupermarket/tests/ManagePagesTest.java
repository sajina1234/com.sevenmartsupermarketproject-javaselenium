package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.dataprovider.*;
import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ManagePagesPage;
import com.sevenmartsupermarket.utilities.ExcelReader;

public class ManagePagesTest extends Base {
	LoginPage loginpage;
	ManagePagesPage managepagespage;
	ExcelReader excelreader;
	@Test(dataProvider = "ManagePage creation data", dataProviderClass = Data_Provider.class)
	public void verifyNewPageCreation(String title,String description,String pageName,String imageName) {
		loginpage=new LoginPage(driver);
		managepagespage=new ManagePagesPage(driver);
		loginpage.loginUtility();
		managepagespage.clickManageContent();
		managepagespage.clickManagePages();
		managepagespage.addPageContent(title, description, pageName,imageName);
		Assert.assertTrue(managepagespage.checkAlertMessageIsDisplayed());
		}
@Test
public void verifySearchPages() {
	loginpage=new LoginPage(driver);
	managepagespage=new ManagePagesPage(driver);
	excelreader=new ExcelReader();
	loginpage.loginUtility();
	managepagespage.clickManageContent();
	managepagespage.clickManagePages();
	excelreader.setExcelFile("project test data","Sheet14");
	String searchtitle=excelreader.getCellData(0, 0);
	managepagespage.searchPageContent(searchtitle);
	String actualPageSearchResult=managepagespage.getPageSearchResult();
	Assert.assertEquals(actualPageSearchResult,Constants.EXPECTEDPAGE_SEARCH_RESULT);
}
}
