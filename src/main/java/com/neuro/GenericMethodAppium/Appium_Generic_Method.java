package com.neuro.GenericMethodAppium;
import org.openqa.selenium.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Appium_Generic_Method {
	private Properties prop;
	 private WebDriverWait wait;
	
	//private static AndroidDriver <MobileElement>driver;
	private static AndroidDriver driver;
	private DesiredCapabilities capabilities;
	private URL url;
	private WebDriverWait waits;
	private static Appium_Generic_Method utils;

	public static Appium_Generic_Method getObject() {

		if (utils == null) {

			utils = new Appium_Generic_Method();

		}

		return utils;

	}

	private Appium_Generic_Method() {

		loadPropertyFile();

	}

	public void loadPropertyFile() {
		prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(
					"C:\\Users\\NEUROEQUILIBRIUM\\eclipse-workspace\\AppiumTesting\\src\\test\\resources\\config.propeties");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public AndroidDriver GETDRIVER() {

		return driver;

	}

	public AndroidDriver LaunchPhon(String DeviceType, String uiAutomator, String version, String deviceName,
			String AppName, String deviceId) {

		if (DeviceType.equalsIgnoreCase("Android")) {

			capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, deviceId);
			capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, waits);
			capabilities.setCapability("adbExecTimeout", "20000");
			capabilities.setCapability(MobileCapabilityType.APP, "");
			try {

				url = new URL("http://127.0.0.1:4723/wd/hub");

			} catch (MalformedURLException e) {

				e.printStackTrace();
			}

			driver = new AndroidDriver(url, capabilities);

		} else if (deviceName.equalsIgnoreCase("IOS")) {

			try {

				url = new URL("http://127.0.0.1:4723/wd/hub");

			} catch (MalformedURLException e) {

				e.printStackTrace();
			}
			driver = new AndroidDriver(url, capabilities);

		}
		return driver;

	}
	 public void click(WebElement element) {
	        try {
	            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	        } catch (Exception e) {
	            System.out.println("Click failed: " + e.getMessage());
	        }
	    }
	
	 
	 public void scrollToText(String visibleText) {
	        driver.findElement(AppiumBy.androidUIAutomator(
	                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"" + visibleText + "\"))"));
	    }
	 
	 
	 
	 public void takeScreenshot(String filename) {
	        try {
	            File src = driver.getScreenshotAs(OutputType.FILE);
	            File dest = new File("screenshots/" + filename + ".png");
	            Files.copy(src.toPath(), dest.toPath());
	        } catch (IOException e) {
	            System.out.println("Screenshot failed: " + e.getMessage());
	        }
	    } 
}
