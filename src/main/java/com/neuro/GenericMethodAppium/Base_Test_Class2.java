package com.neuro.GenericMethodAppium;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.lang.reflect.Method;


public class Base_Test_Class2 {

    protected Appium_Generic_Method utils;

    @BeforeSuite
    public void beforeSuite() {
        utils = Appium_Generic_Method.getObject();
        System.out.println("==== Test Suite Started ====");
    }

    @BeforeMethod
    public void setup(Method method) throws Exception {
        try {
            System.out.println("=== Setting up test: " + method.getName() + " ===");
            
            utils.startReport(method.getName());
            System.out.println("Report started successfully");
            
            utils.getCapabilities();
            System.out.println("Appium capabilities set successfully");
            
            utils.logPass("Application launched successfully");
            System.out.println("Setup completed successfully");
        } catch (Exception e) {
            System.out.println("ERROR in setup: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    @AfterMethod
    public void tearDown() {

      //  utils.quitDriver();
       // utils.logPass("Driver closed");
    }

    @AfterSuite
    public void afterSuite() {

        utils.endReport();
        System.out.println("==== Test Suite Finished ====");
    }
}
