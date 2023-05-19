package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.base.Data_Provider;
import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ManagePagesPage;

public class ManagePagesTest extends Base {
	LoginPage loginpage;
	ManagePagesPage managepagespage;
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
	loginpage.loginUtility();
	managepagespage.clickManageContent();
	managepagespage.clickManagePages();
	managepagespage.searchPageContent("page1");
	String actualPageSearchResult=managepagespage.getPageSearchResult();
	Assert.assertEquals(actualPageSearchResult,Constants.EXPECTEDPAGE_SEARCH_RESULT);
}
}
