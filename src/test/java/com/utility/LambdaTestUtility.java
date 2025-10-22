package com.utility;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LambdaTestUtility {
	
	public static final String HUB_URL="https://hub.lambdatest.com/wd/hub";
	public static ThreadLocal<WebDriver> driverLocal=new ThreadLocal<WebDriver>();
	public static ThreadLocal<DesiredCapabilities> capabilitiesLocal=new ThreadLocal<DesiredCapabilities>();
	
	public static WebDriver initializeLambdaTestSession(String browser, String testName) {
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability("browserName", browser);
		capabilities.setCapability("browserVersion", "141");
		Map<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "yashthakur0087");
		ltOptions.put("accessKey", "LT_pxcvM4cbHqB69ga3xPtXZ2F4XSR2QApXBgNXwpdSUtKy2eP");
//									LT_pxcvM4cbHqB69ga3xPtXZ2F4XSR2QApXBgNXwpdSUtKy2eP
		ltOptions.put("build", "Selenium4");
		ltOptions.put("name", testName);
		ltOptions.put("platformName", "Windows 11");
		ltOptions.put("w3c", true);
		ltOptions.put("selenium_version", "4.25.0");
		capabilities.setCapability("LT:Options", ltOptions);
		
		capabilitiesLocal.set(capabilities);
		WebDriver driver=null;
		try {
			driver = new RemoteWebDriver(new URI(HUB_URL).toURL(),capabilitiesLocal.get());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		driverLocal.set(driver);
		
		
		return driverLocal.get();	
	}
		
	public static void quitSession() {
		if(driverLocal.get()!=null) {
			driverLocal.get().quit();
		}
	}
	
}
