package com.accenture.runner.platform;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.accenture.aaft.logger.CTLogger;
import com.accenture.aaft.report.ExtentManager;
import com.accenture.aaft.report.ExtentTestManager;
import com.relevantcodes.extentreports.ExtentReports;

import com.accenture.aaft.selenium.library.utility.RestCall;

/**
 * Class is used for cucumber test
 *
 * @author vijay.venkatappa
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "target/test-classes/cucumber/features/", tags = { "@BMICalc" }, format = { "html:target/cucumber-report/CalculateBMI" }, glue = { "cucumber.stepdefs",
    "cucumber.stepdefs.CalculateBMI" })
public class CalculateBMI_Android_APP_Runner {
	
  //Live reporting
  public static String RUNNER_SLNO;

  static ExtentReports extent;
  static String scriptName = "CalculateBMI";

  /**
   * Method is used to set instructions before executing class
   * 
   */
  @BeforeClass
  public static void runOnceBeforeClass() {
	extent = ExtentManager.getExtentManager();
	ExtentTestManager.startTest("Platform Test : Android App : " + scriptName, " BMI calculation for a person", "com.accenture.runner.platform.CalculateBMI_Android_APP_Runner");
	CTLogger.writeToLog("CalculateBMI_Android_APP_Runner MAP AFTER - " + ExtentTestManager.extentTestMap.size() + "Thread id - " + Thread.currentThread().getId());
  }

  /**
   * Method is used to set instructions before executing class
   * 
   */
  @AfterClass
  public static void runOnceAfterClass() {
	CTLogger.writeToLog("@@AfterClass - CalculateBMI_Android_APP_Runner");
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
