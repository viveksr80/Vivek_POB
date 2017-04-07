package com.accenture.runner.platform;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.accenture.aaft.logger.CTLogger;
import com.accenture.aaft.report.ExtentManager;
import com.accenture.aaft.report.ExtentTestManager;
import com.relevantcodes.extentreports.ExtentReports;

import com.accenture.aaft.selenium.library.utility.RestCall;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * Class is used for cucumber test
 *
 * @author vijay.venkatappa
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "target/test-classes/cucumber/features/", tags = { "@HeartRateCalc" }, format = { "html:target/cucumber-report/HeartRateCalc" }, glue = { "cucumber.stepdefs",
    "cucumber.stepdefs.CalculateHeartRate" })
public class CalculateHeartRate_Android_APP_Runner {

  //Live reporting
  public static String RUNNER_SLNO;
  
  static ExtentReports extent;
  static String scriptName = "CalculateHeartRate";

  /**
   * Method is used to set instructions before executing class
   * 
   */
  @BeforeClass
  public static void runOnceBeforeClass() {
	CTLogger.writeToLog("@BeforeClass - CalculateHeartRate_Android_APP_Runner extent - " + extent);
	extent = ExtentManager.getExtentManager();
	ExtentTestManager.startTest("Platform Test : Android App : " + scriptName, " HeartRate calculation for a person", RUNNER_SLNO);
	CTLogger.writeToLog("CalculateHeartRate_Android_APP_Runner MAP AFTER - " + ExtentTestManager.extentTestMap.size() + "Thread id - " + Thread.currentThread().getId());
  }

  /**
   * Method is used to set instructions after execution
   *
   */
  @AfterClass
  public static void runOnceAfterClass() {
	CTLogger.writeToLog("@@AfterClass - CalculateHeartRate_Android_APP_Runner");
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
