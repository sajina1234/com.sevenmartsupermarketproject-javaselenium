package com.sevenmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.utilities.GeneralUtility;
import com.sevenmartsupermarket.utilities.WaitUtility;

public class HomePagePage {
	WebDriver driver;
	GeneralUtility generalutility;
	WaitUtility waitutility;

	public HomePagePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='brand-text font-weight-light']")
	private WebElement sevenMartLogo;

	/**
	 * method for get text of Sevenmartlogo
	 * @return
	 */
	public String getLogoText() {
		generalutility = new GeneralUtility(driver);
		waitutility = new WaitUtility(driver);
		waitutility.fluentWait(sevenMartLogo);
		return generalutility.get_textOfElement(sevenMartLogo);
	}

	/**
	 * method to get status of link
	 */
	public void getResponseCode() {
		generalutility = new GeneralUtility(driver);
		int print = generalutility.getResponseStatusCode(
				"https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png");
		System.out.println(print);
	}
}
