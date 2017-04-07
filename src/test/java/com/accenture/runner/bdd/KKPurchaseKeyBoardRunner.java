package com.accenture.runner.bdd;

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
@CucumberOptions(features = "target/test-classes/cucumber/features/", tags = { "@keyboard" }, format = { "html:target/cucumber-report/software" }, glue = { "cucumber.stepdefs",
    "cucumber.stepdefs.KKPurchaseKeyBoard" })
public class KKPurchaseKeyBoardRunner {
	
	 //Added as part of Live Reporting
  public static String RUNNER_SLNO;

  static ExtentReports extent;
  static String scriptName = "konakart purchaseKeyboard";

  /**
   * Method is used to set instructions before executing class
   * 
   */

  @BeforeClass
  public static void runOnceBeforeClass() {

	extent = ExtentManager.getExtentManager();
	ExtentTestManager.startTest("Cucumber Test : " + scriptName, "Online Store - konakart purchaseSoftware", "com.accenture.runner.bdd.KKPurchaseKeyBoardRunner");
	CTLogger.writeToLog("KKPurchaseKeyBoardRunner MAP AFTER - " + ExtentTestManager.extentTestMap.size() + "Thread id - " + Thread.currentThread().getId());
  }

  /**
   * Method is used to set instructions after execution
   *
   */
  @AfterClass
  public static void runOnceAfterClass() {
	CTLogger.writeToLog("@@AfterClass - KKPurchaseKeyBoardRunner");
	ExtentManager.getReporter().endTest(ExtentTestManager.getTest());
	ExtentManager.getReporter().flush();
	// ExtentManager.getReporter().close();
	
	String status = ExtentTestManager.getThreadStatus();
	if (status == null || status.trim().equals("")) {
		status = "p";
	}
	RestCall rc = new RestCall();
	rc.simpleGet(ExtentTestManager.getTestCaseNumber(), status);
  }
}
