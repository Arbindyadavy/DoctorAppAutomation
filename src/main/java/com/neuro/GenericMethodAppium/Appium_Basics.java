package com.neuro.GenericMethodAppium;


import org.testng.annotations.Test;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;


public class Appium_Basics{

	
	
@Test	
public void AppiumTest() throws  InterruptedException, MalformedURLException {
	//AppiumDriverLocalService service=new AppiumServiceBuilder().withAppiumJS(new File ("C:\\Users\\NEUROEQUILIBRIUM\\AppData\\Roaming\\npm\\node_modules\\appium\\lib\\main.js"))
			//.withIPAddress("127.0.0.1").usingPort(4723).build();
	//service.start();
	UiAutomator2Options option=new UiAutomator2Options();
	option.setDeviceName("emulator-5554");
	option.setApp("E:\\Apk_File\\ApiDemos-debug.apk");
	
	AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),option);
	//Thread.sleep(500);

	
	//driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Accessibility']")).click();
	//Thread.sleep(1000);
	//driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Accessibility Service']")).click();

   





}
	
	
	
	
	
	
	
	
	
	
	
}
  