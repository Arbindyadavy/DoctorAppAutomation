package org.neuro.doctor_app_page_or;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Doctor_App_Login_OR_Page {

	
	@FindBy(xpath = "//android.widget.TextView[@text='Today']")
    protected WebElement TodysClick;

	@FindBy(xpath = "//android.widget.TextView[@text='All']")
    protected WebElement ALLClick;

	@FindBy(xpath = "//android.view.View[@content-desc='Reports']")
    protected WebElement ReportsClick;


	@FindBy(xpath = "//android.widget.TextView[@text='Prescription']")
    protected WebElement PrescriptionClick;

	@FindBy(xpath = "//android.widget.TextView[@text='Chats']")
    protected WebElement ChatsClick;
	
	

	@FindBy(xpath = "//android.view.View[@content-desc='Prescription']")
    protected WebElement Prescription;
	
	
	
	
	
	
	
	
	
	
}
