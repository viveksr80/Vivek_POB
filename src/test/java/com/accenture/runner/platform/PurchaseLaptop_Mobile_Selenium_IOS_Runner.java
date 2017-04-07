package com.accenture.runner.platform;

import java.util.LinkedList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.accenture.aaft.logger.CTLogger;
import com.accenture.aaft.propertyreader.PropertyFileReader;
import com.accenture.aaft.propertyreader.SeleniumConfigXmlReader;
import com.accenture.aaft.report.ExtentManager;
import com.accenture.aaft.report.ExtentTestManager;
import com.accenture.aaft.selenium.driver.ExecuteScript;
import com.relevantcodes.extentreports.ExtentReports;

import com.accenture.aaft.selenium.library.utility.RestCall;

/**
 * Class is used for cucumber test
 *
 * @author vijay.venkatappa
 *
 */
public class PurchaseLaptop_Mobile_Selenium_IOS_Runner {
	
  //Live reporting
  public static String RUNNER_SLNO;

  static ExtentReports extent;
  static String scriptName = "PurchaseLaptop";
  static PropertyFileReader prop = new PropertyFileReader();
  static String executionType = "saucelabs-device";

  /**
   * Method is used to execute script
   *
   */
  @Test
  public void test() {
	ExecuteScript executeScript1 = new ExecuteScript();
	
	SeleniumConfigXmlReader seleniunConfigXmlReader = new SeleniumConfigXmlReader();	
	LinkedList<String[]> listArray= seleniunConfigXmlReader.getBrowserList(executionType);
	String browserConfig[] = listArray.get(1);
	
	String os = browserConfig[3];
	String version = browserConfig[4];
	String browser = browserConfig[2];
	String device = browserConfig[6];
	String deviceOrientation = browserConfig[5];
	String appiumVersion = browserConfig[7];
	String app = browserConfig[8];	
	
	executeScript1.executeScript(app, os, version, browser, executionType, device, deviceOrientation, appiumVersion, app);
  }

  /**
   * Method is used to set instructions before executing class
   * 
   */
  @BeforeClass
  public static void runOnceBeforeClass() {
	extent = ExtentManager.getExtentManager();
	ExtentTestManager.startTest("Platform Test : iOS Browser : " + scriptName, "Online Store - Purchase Laptop", "com.accenture.runner.platform.PurchaseLaptop_Mobile_Selenium_IOS_Runner");
	CTLogger.writeToLog("PurchaseLaptop_Mobile_Selenium_IOS_Runner MAP AFTER - " + ExtentTestManager.extentTestMap.size() + "Thread id - " + Thread.currentThread().getId());
  }

  /**
   * Method is used to set instructions after execution
   *
   */
  @AfterClass
  public static void runOnceAfterClass() {
	CTLogger.writeToLog("@@AfterClass - PurchaseLaptop_Mobile_Selenium_IOS_Runner");
	ExtentManager.getReporter().endTest(ExtentTestManager.getTest());
	ExtentManager.getReporter().flush();
	
	String status = ExtentTestManager.getThreadStatus();
	if (status == null || status.trim().equals("")) {
		status = "p";
	}
	RestCall rc = new RestCall();
	rc.simpleGet(ExtentTestManager.getTestCaseNumber(), status);
  }
}
