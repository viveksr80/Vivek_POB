package com.accenture.runner.platform;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.accenture.aaft.logger.CTLogger;
import com.accenture.aaft.propertyreader.PropertyFileReader;
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
public class CalculateBMI_Android_APP_Selenium_Runner {

  //Live reporting
  public static String RUNNER_SLNO;
  
  static ExtentReports extent;
  static String scriptName = "CalculateBMI";
  static PropertyFileReader prop = new PropertyFileReader();

  /**
   * Method is used to execute script
   *
   */
  @Test
  public void test() {
	ExecuteScript executeScript1 = new ExecuteScript();
	executeScript1.executeScript(scriptName, "saucelabs_app_" + prop.getValue("MOBILE_DEVICE_NAME"),"","","");
  }

  /**
   * Method is used to set instructions before executing class
   * 
   */
  @BeforeClass
  public static void runOnceBeforeClass() {
	extent = ExtentManager.getExtentManager();
	ExtentTestManager.startTest("Platform Test : Android App : " + scriptName, "Online Store - Purchase Laptop", RUNNER_SLNO);
	CTLogger.writeToLog("CalculateBMI_Android_APP_Selenium_Runner MAP AFTER - " + ExtentTestManager.extentTestMap.size() + "Thread id - " + Thread.currentThread().getId());
  }

  /**
   * Method is used to set instructions after execution
   *
   */
  @AfterClass
  public static void runOnceAfterClass() {
	CTLogger.writeToLog("@@AfterClass - CalculateBMI_Android_APP_Selenium_Runner");
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
