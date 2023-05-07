package com.sevenmartsupermarket.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	WebDriverWait wait;
	WebDriver driver;
	public static final long IMPLICIT_WAIT = 10;
	public static final long EXPLICIT_WAIT = 20;

	public WaitUtility(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * wait method for xpath to be visible
	 * @param xpath
	 */
	public void waitForElementToBeVisible(String xpath) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

	/**
	 * wait method for element to be visible
	 * @param element
	 */
	public void waitForElementToBeVisible(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * wait method for element to be clickable
	 * @param element
	 */
	public void waitForElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * wait method for alert to be present
	 * @param element
	 */
	public void waitForAlertToBePresent(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	/**
	 * wait method for invisibility of element
	 * @param element
	 */
	public void waitForInvisibilityOfElement(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
}
