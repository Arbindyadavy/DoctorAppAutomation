package com.neuro.GenericMethodAppium;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.BeforeSuite;
import com.google.common.collect.ImmutableMap;


import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.AppiumBy;

public class Base_Test_Class2 {
	//public static AndroidDriver driver;
	public static AndroidDriver driver;
	//public UiAutomator2Options option;

	@BeforeSuite
	public void getCapabilities() throws Exception {

	    System.out.println("Starting Appium session...");

	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability("deviceName", "emulator-5554");
	    capabilities.setCapability("platformName", "Android");
	    capabilities.setCapability("automationName", "UiAutomator2");
	    capabilities.setCapability("platformVersion", "11");
	    capabilities.setCapability("appPackage", "com.nedsappdoc");
	    capabilities.setCapability("appActivity", "com.nedsappdoc.MainActivity");
	    capabilities.setCapability("noReset", true);

	    driver = new AndroidDriver(
	            new URL("http://localhost:4723/wd/hub"),
	            capabilities
	    );
	
	    
	       Thread.sleep(5000);
	      driver.quit();
	}
	
	public void loginIfRequired() {
        try {
            if (driver.findElement(AppiumBy.accessibilityId("Login")).isDisplayed()) {

                driver.findElement(AppiumBy.id("mobile_input"))
                      .sendKeys("9999999999");

                driver.findElement(AppiumBy.id("otp_input"))
                      .sendKeys("123456");

                driver.findElement(AppiumBy.accessibilityId("Login")).click();

                Thread.sleep(5000);
            }
        } catch (Exception e) {
            System.out.println("✅ Already logged in, dashboard loaded");
        }
    }
	

	public void LongPressAction(WebElement ele) {

		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(),"duration", 2000));
	}
	public void launchDoctorApp() {
        driver.activateApp("com.neuroequilibrium.doctor");
    }



	public void scrollToEndAction() {
		
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0
					// [170,1074][803,1242]
					));
		} while (canScrollMore);
	}

	
	public void swipeAction(WebElement ele, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(),
						//it is direction must be importent Enterd Here like Left or Right 
						"direction", direction, "percent", 0.75));

	}

	public Double getFormattedAmount(String amount) {
		Double price = Double.parseDouble(amount.substring(1));
		return price;

	}
	
	public void DragDropTest(WebElement  source) throws MalformedURLException, InterruptedException
	{
		
		
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) source).getId(),
			    "endX", 619,
			    "endY", 560
			));
		

	
		
			
	}
	

	
	
	public void WebDriverWait() {
		
		WebDriverWait();
	}

	//@AfterClass
	public void Close_App() {
		if (driver != null) {
			driver.quit();
		}

	}
}
