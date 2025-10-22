package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
	}

	public BrowserUtility(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
		} else if (browser.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
		} else {
			System.err.println("Please choose browser from [Chrome, Edge]");
		}
	}

	public void goToWebsite(String url) {
		logger.info("Navigating to website");
		driver.get().get(url);
	}

	public void maximizeWindow() {
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		WebElement element = driver.get().findElement(locator);
		element.click();
	}

	public void enterText(By locator, String text) {
		WebElement element = driver.get().findElement(locator);
		element.sendKeys(text);
	}

	public String getVisibleText(By locator) {
		WebElement element = driver.get().findElement(locator);
		return element.getText();
	}

	public BrowserUtility(Browser browser) {
		if (browser == Browser.CHROME) {
			driver.set(new ChromeDriver());
		} else if (browser == Browser.EDGE) {
			driver.set(new EdgeDriver());
		} else {
			System.err.println("Please choose browser from [Chrome, Edge]");
		}
	}
	
	public BrowserUtility(Browser browser, boolean isHeadless) {
		if (browser == Browser.CHROME){
			if(isHeadless) {
				ChromeOptions options=new ChromeOptions();
				options.addArguments("--headless=new");
	            options.addArguments("--no-sandbox");
	            options.addArguments("--disable-gpu");
	            options.addArguments("--disable-dev-shm-usage");
	            options.addArguments("--remote-allow-origins=*");
	            options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
			}
			else {
				driver.set(new ChromeDriver()); 	
			}
			
		} else if (browser == Browser.EDGE) {
			if(isHeadless) {
				EdgeOptions options=new EdgeOptions();
				options.addArguments("--headless=new");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
			}
			else {
				driver.set(new EdgeDriver());	
			}
			
		} else {
			System.err.println("Please choose browser from [Chrome, Edge]");
		}
	}

	public String takeScreenshot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		String path = System.getProperty("user.dir") + "//screenshots//" + name + "-" + timeStamp + ".jpg";
		File screenshotFile = new File(path);

		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {

			e.printStackTrace();
		}

		return path;
	}

}
