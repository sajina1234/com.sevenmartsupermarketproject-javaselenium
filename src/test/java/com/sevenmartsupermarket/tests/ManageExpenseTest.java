package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.dataprovider.*;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ManageExpensePage;
import com.sevenmartsupermarket.utilities.FakerUtility;

public class ManageExpenseTest extends Base {
	ManageExpensePage manageexpensepage;
	LoginPage loginpage;
	@Test(dataProvider = "Expense data", dataProviderClass = Data_Provider.class)
	public void verifyexpensecategoryCreation(String title) {
		loginpage=new LoginPage(driver);
		manageexpensepage=new ManageExpensePage(driver);
		loginpage.loginUtility();
		manageexpensepage.expenseCategoryCreation(title);
		Assert.assertTrue(manageexpensepage.checkSuccessAlert());
		
	}

}
