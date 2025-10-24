package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private Logger logger = LoggerUtility.getLogger(this.getClass());
	private WebDriverWait wait;

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
	}

	public BrowserUtility(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else if (browser.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else {
			System.err.println("Please choose browser from [Chrome, Edge]");
		}
	}

	public void goToWebsite(String url) {
		logger.info("Navigating to website");
		driver.get().get(url);
	}

	public void maximizeWindow() {
		logger.info("Maximizing the window");
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		logger.info("Finding the element");
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
	
	public void clickOnCheckbox(By locator) {
		logger.info("Finding the element");
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.click();
	}

	public void clickOn(WebElement el) {
		logger.info("Clicking on the first element");
		el.click();
	}

	public void enterText(By locator, String text) {
		logger.info("Entering the text");
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(text);
	}

	public void enterSpecialKey(By locator, Keys key) {
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(key);
	}

	public String getVisibleText(By locator) {
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		return element.getText();
	}

	public void clearText(By locator) {
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.clear();
	}

	public void selectFromDropdown(By locator, String choice) {
		new WebDriverWait(getDriver(), Duration.ofSeconds(30L));
		WebElement element=driver.get().findElement(locator);
		Select select = new Select(element);
		select.selectByVisibleText(choice);
	}

	public List<String> getAllVisibleText(By locator) {
		new WebDriverWait(getDriver(), Duration.ofSeconds(30L));
		List<WebElement> elementList = driver.get().findElements(locator);
		logger.info("Priniting list of products found");
		List<String> itemList = new ArrayList<String>();
		for (WebElement el : elementList) {
			itemList.add(getVisibleText(el));
		}
		return itemList;
	}

	public List<WebElement> getAllElements(By locator) {
		new WebDriverWait(getDriver(), Duration.ofSeconds(5));
		List<WebElement> list = driver.get().findElements(locator);

		return list;
	}

	public String getVisibleText(WebElement el) {
		return el.getText();
	}

	public BrowserUtility(Browser browser) {
		if (browser == Browser.CHROME) {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else if (browser == Browser.EDGE) {
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30l));
		} else {
			System.err.println("Please choose browser from [Chrome, Edge]");
		}
	}

	public BrowserUtility(Browser browser, boolean isHeadless) {
		if (browser == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=new");
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-gpu");
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("--remote-allow-origins=*");
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {
				driver.set(new ChromeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}

		} else if (browser == Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=new");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {
				driver.set(new EdgeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
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
		String path = "/screenshots/" + name + "-" + timeStamp + ".jpg";
		File screenshotFile = new File(path);

		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {

			e.printStackTrace();
		}

		return path;
	}

}
