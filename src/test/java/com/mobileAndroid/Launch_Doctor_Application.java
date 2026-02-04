package com.mobileAndroid;

import org.neuro.doctor_app_pagewise.Doctor_App_Login_Page;
import org.testng.annotations.Test;
import com.neuro.GenericMethodAppium.Base_Test_Class2;



public class Launch_Doctor_Application extends Base_Test_Class2 {

	@Test
	 public void Verify_Doctor_Login_Page() throws Exception {

		Doctor_App_Login_Page loginPage =  new Doctor_App_Login_Page();
        loginPage.LoginFunctionality();
      //  utils.logPass("Doctor Login Successful");
    }

}
