package com.sevenmartsupermarket.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.utilities.ScreenShot;
import com.sevenmartsupermarket.utilities.WaitUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver driver;
	Properties properties = new Properties();
	FileInputStream fileinputstream;
ScreenShot screenshot=new ScreenShot();
	public Base() {
		try {
			fileinputstream=new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(fileinputstream);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void intialize(String browser, String url) {
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
@Parameters("browser")
	@BeforeMethod(enabled=false,alwaysRun=true)
	public void launchBrowser(String browser) {
		
		String url=properties.getProperty("url");
		intialize(browser,url);
	}
@BeforeMethod(enabled=true ,alwaysRun=true)
public void launchBrowser() {
	String browser=properties.getProperty("browser");
	String url=properties.getProperty("url");
	intialize(browser,url);
}
	@AfterMethod
	public void terminateBrowser(ITestResult itest) {
		if(itest.getStatus()==ITestResult.FAILURE) {
			screenshot.takeScreenShot(driver, itest.getName());
		}
		driver.close();
	}
}
