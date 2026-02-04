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

        utils.startReport(method.getName());
        utils.getCapabilities();

        utils.logPass("Application launched successfully");
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
