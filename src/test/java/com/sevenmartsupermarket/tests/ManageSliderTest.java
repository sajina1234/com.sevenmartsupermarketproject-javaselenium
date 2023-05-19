package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.base.Data_Provider;
import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ManageSliderPage;

public class ManageSliderTest extends Base{
	LoginPage loginpage;
	ManageSliderPage managesliderpage;
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
	loginpage.loginUtility();
	managesliderpage.clickManageSlider();
	managesliderpage=new ManageSliderPage(driver);
	managesliderpage.clickOnDeActivationButton("https:\\grocery.com");
	String actualLinkStatus=managesliderpage.getLinkStatusText("https:\\grocery.com");
    Assert.assertEquals(actualLinkStatus,Constants.EXPECTEDLINK_STATUS);
}
}
