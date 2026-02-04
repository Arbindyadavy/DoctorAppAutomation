package org.neuro.doctor_app_pagewise;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import java.time.Duration;
import org.neuro.doctor_app_page_or.Doctor_App_Login_OR_Page;
import org.openqa.selenium.support.PageFactory;
import com.neuro.GenericMethodAppium.Appium_Generic_Method;



public class Doctor_App_Login_Page extends Doctor_App_Login_OR_Page{
	
	Appium_Generic_Method WebUtil =Appium_Generic_Method.getObject();
	   public Doctor_App_Login_Page() {
	     

	        PageFactory.initElements(
	                new AppiumFieldDecorator(WebUtil.getDriver(), Duration.ofSeconds(10)),
	                this
	        );
	    }
	


	public void LoginFunctionality () throws Exception {
		WebUtil.click(TodysClick, "Doctor App Click Successfully");
		Thread.sleep(1500);
		WebUtil.click(ALLClick, "Doctor App ALL Tab Click Successfully");
		Thread.sleep(1500);
		

		WebUtil.click(ReportsClick, "Doctor App Prescription Click Successfully");
		Thread.sleep(1500);
		WebUtil.click(PrescriptionClick, "Doctor App Reports Tab Click Successfully");
		Thread.sleep(1500);
//		Thread.sleep(1000);
//		ReportsClick.click();
//		Thread.sleep(1000);
//		PrescriptionClick.click();
//		Thread.sleep(1000);
//		ChatsClick.click();
//		Thread.sleep(1000);

	
	}
	
}
