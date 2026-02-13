package com.neuro.GenericMethodAppium;

import org.openqa.selenium.*;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Appium_Generic_Method {

    private static AndroidDriver driver;
    private static Appium_Generic_Method utils;
    private WebDriverWait wait;
    private static ExtentReports extent;
    private static ExtentTest test;

 
    public static Appium_Generic_Method getObject() {
        if (utils == null) {
            utils = new Appium_Generic_Method();
        }
        return utils;
    }

    private Appium_Generic_Method() {
       
    }

    
    public AndroidDriver getDriver() {
        return driver;
    }

    
    public void getCapabilities() throws Exception {

        System.out.println("Starting Appium session...");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "0J63605127208D44");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformVersion", "15");
        capabilities.setCapability("appPackage", "com.nedsappdoc");
        //android    App appPackage RE58C6
        //emuletro appPackage com.nedsappdoc       
        //com.android.launcher3/com.android.searchlauncher.SearchLauncher
        capabilities.setCapability("appActivity", "com.nedsappdoc.MainActivity");

        capabilities.setCapability("noReset", true);

        driver = new AndroidDriver(
                new URL("http://localhost:4723/wd/hub"),
                capabilities
        );

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }


    public void startReport(String testName) {

        if (extent == null) {
            String time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            ExtentSparkReporter spark =
                    new ExtentSparkReporter("reports/AutomationReport_" + time + ".html");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        test = extent.createTest(testName);
    }

  
    public void logPass(String message) {
        if (test != null) {
            test.pass(message);
        } else {
            System.out.println("TEST OBJECT IS NULL - " + message);
        }
    }

  
    public void logFail(String message) {
        try {
            String path = takeScreenshot("FAIL");
            if (test != null) {
                test.fail(message,
                        MediaEntityBuilder.createScreenCaptureFromPath(path).build());
            } else {
                System.out.println("TEST OBJECT IS NULL - " + message);
            }
        } catch (Exception e) {
            System.out.println("Error in logFail: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public String takeScreenshot(String name) {
        String time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String path = "screenshots/" + name + "_" + time + ".png";

        try {
            File src = driver.getScreenshotAs(OutputType.FILE);
            Files.createDirectories(new File("screenshots").toPath());
            Files.copy(src.toPath(), new File(path).toPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }

   
    public void click(WebElement element, String stepName) throws Exception {
        try {
            if (element == null) {
                throw new Exception("Element is null - " + stepName);
            }
            if (driver == null) {
                throw new Exception("Driver is null - getCapabilities() might have failed");
            }
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            logPass(stepName + " clicked successfully");
        } catch (Exception e) {
            logFail(stepName + " click failed: " + e.getMessage());
            throw e;
        }
    }


    public void scrollToText(String text) {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))"
                        + ".scrollIntoView(new UiSelector().textContains(\"" + text + "\"))"));
        logPass("Scrolled to text: " + text);
    }

    
    public void endReport() {
        if (extent != null) {
            extent.flush();
        }
    }

    
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
