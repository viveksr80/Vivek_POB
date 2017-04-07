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
@CucumberOptions(features = "target/test-classes/cucumber/features/", tags = { "@iPad" }, format = { "html:target/cucumber-report/iPad" }, glue = { "cucumber.stepdefs",
    "cucumber.stepdefs.PurchaseIPad" })
public class PurchaseIPadRunner {

  static ExtentReports extent;
  static String scriptName = "Purchase IPad";

  /**
   * Method is used to set instructions before executing class
   * 
   */
  @BeforeClass
  public static void runOnceBeforeClass() {
	extent = ExtentManager.getExtentManager();
	ExtentTestManager.startTest("Cucumber Test : " + scriptName, "Online Store - Purchase IPad");
	CTLogger.writeToLog("PurchaseIPadRunner MAP AFTER - " + ExtentTestManager.extentTestMap.size() + "Thread id - " + Thread.currentThread().getId());
  }

  /**
   * Method is used to set instructions after execution
   *
   */
  @AfterClass
  public static void runOnceAfterClass() {
	CTLogger.writeToLog("@@AfterClass - PurchaseIPadRunner");
	ExtentManager.getReporter().endTest(ExtentTestManager.getTest());
	ExtentManager.getReporter().flush();
	ExtentManager.getReporter().close();
  }
}
