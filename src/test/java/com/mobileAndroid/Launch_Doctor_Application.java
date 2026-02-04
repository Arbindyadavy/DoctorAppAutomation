package com.mobileAndroid;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.neuro.GenericMethodAppium.Base_Test_Class2;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Launch_Doctor_Application extends Base_Test_Class2 {

	@Test
	public void Verify_Doctor_Login_Page() throws Exception {
		Thread.sleep(2000);
		WebElement TodysClick = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Today']"));
		Thread.sleep(2000);
		TodysClick.click();
		Thread.sleep(2000);

		WebElement AllClick = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='All']"));
		Thread.sleep(1000);
		AllClick.click();
		Thread.sleep(1000);

		WebElement ReportsClick = driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Reports']"));
		Thread.sleep(1000);
		ReportsClick.click();
		Thread.sleep(1000);
		WebElement AllClick1 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='All']"));
		Thread.sleep(1000);
		AllClick1.click();
		Thread.sleep(1000);

		WebElement PrescriptionClick = driver
				.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Prescription']"));
		Thread.sleep(1000);
		PrescriptionClick.click();
		Thread.sleep(1000);

		WebElement ChatsClick = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Chats']"));
		Thread.sleep(1000);
		ChatsClick.click();
		Thread.sleep(1000);

	}

	public void VerifyLoginPage() throws InterruptedException {
		Thread.sleep(2000);
		WebElement getStart = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Get Started']"));
		Thread.sleep(2000);
		getStart.click();

		Thread.sleep(2000);
		WebElement EmailId = driver
				.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Enter your Email ID']"));
		Thread.sleep(2000);
		EmailId.click();
		EmailId.sendKeys("testing@neuroequilibrium.in");
		WebElement MobileNumber = driver
				.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Enter your mobile number']"));
		Thread.sleep(2000);
		MobileNumber.sendKeys("7793828943");
		WebElement GetOTp = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Get OTP']"));
		Thread.sleep(2000);
		GetOTp.click();
		
		    driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));	
			Thread.sleep(1000);
			driver.pressKey(new KeyEvent(AndroidKey.DIGIT_4));
			Thread.sleep( 500);
			driver.pressKey(new KeyEvent(AndroidKey.DIGIT_5));
			Thread.sleep(500);
			driver.pressKey(new KeyEvent(AndroidKey.DIGIT_8));
			Thread.sleep(500);
			driver.pressKey(new KeyEvent(AndroidKey.DIGIT_5));
			Thread.sleep(500);
			driver.pressKey(new KeyEvent(AndroidKey.DIGIT_6));
			Thread.sleep(1000);


		
	}
}
