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

/**
 * Class is used for cucumber test
 *
 * @author vijay.venkatappa
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "target/test-classes/cucumber/features/", tags = { "@iPhone" }, format = { "html:target/cucumber-report/iPhone" }, glue = { "cucumber.stepdefs",
    "cucumber.stepdefs.PurchaseIPhone" })
public class PurchaseIPhoneRunner {

  static ExtentReports extent;
  static String scriptName = "Purchase IPhone";

  /**
   * Method is used to set instructions before executing class
   * 
   */
  @BeforeClass
  public static void runOnceBeforeClass() {
	extent = ExtentManager.getExtentManager();
	ExtentTestManager.startTest("Cucumber Test : " + scriptName, "Online Store - Purchase IPhone");
	CTLogger.writeToLog("PurchaseIPhoneRunner MAP AFTER - " + ExtentTestManager.extentTestMap.size() + "Thread id - " + Thread.currentThread().getId());
  }

  /**
   * Method is used to set instructions after execution
   *
   */
  @AfterClass
  public static void runOnceAfterClass() {
	CTLogger.writeToLog("@@AfterClass - PurchaseIPhoneRunner");
	ExtentManager.getReporter().endTest(ExtentTestManager.getTest());
	ExtentManager.getReporter().flush();
  }
}
