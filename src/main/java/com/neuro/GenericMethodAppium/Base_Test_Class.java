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
import io.appium.java_client.remote.MobileCapabilityType;

public class Base_Test_Class {
	public AndroidDriver driver;



	@BeforeSuite
	public void ConfigureAppium() throws MalformedURLException, Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10000);
		//capabilities.setCapability("autoGrantPermissions", true);
		capabilities.setCapability("newCommandTimeout", 300);


		
	capabilities.setCapability(MobileCapabilityType.APP, "E:\\APKFile\\app-release.apk");   
	//	capabilities.setCapability(MobileCapabilityType.APP,"E:\\APKFile\\ApiDemos-debug.apk");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver(url, capabilities);
		Thread.sleep(2000);

	}

	public void LongPressAction(WebElement ele) {

		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(),"duration", 2000));
	}



	public void scrollToEndAction() {
		
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of(
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
