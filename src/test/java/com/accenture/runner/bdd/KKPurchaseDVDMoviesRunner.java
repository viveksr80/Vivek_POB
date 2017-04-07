package com.accenture.runner.bdd;

import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.accenture.aaft.logger.CTLogger;
import com.accenture.aaft.report.ExtentManager;
import com.accenture.aaft.report.ExtentTestManager;
import com.accenture.aaft.selenium.library.utility.RestCall;
import com.relevantcodes.extentreports.ExtentReports;

/**
 * Class is used for cucumber test
 *
 * @author vijay.venkatappa
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "target/test-classes/cucumber/features/", tags = { "@dvdmovies" }, format = { "html:target/cucumber-report/software" }, glue = { "cucumber.stepdefs",
    "cucumber.stepdefs.KKPurchaseDVDMovies" })
public class KKPurchaseDVDMoviesRunner {

  //Live reporting
  public static String RUNNER_SLNO;
  
  static ExtentReports extent;
  static String scriptName = "konakart purchaseDVDMovies";

  /**
   * Method is used to set instructions before executing class
   * 
   */
  @BeforeClass
  public static void runOnceBeforeClass() {
	extent = ExtentManager.getExtentManager();
	ExtentTestManager.startTest("Cucumber Test : " + scriptName, "Online Store - konakart purchaseDVDMovies", "com.accenture.runner.bdd.KKPurchaseDVDMoviesRunner");
	CTLogger.writeToLog("KKPurchaseDVDMoviesRunner MAP AFTER - " + ExtentTestManager.extentTestMap.size() + "Thread id - " + Thread.currentThread().getId());
  }

  /**
   * Method is used to set instructions after execution
   *
   */
  @AfterClass
  public static void runOnceAfterClass() {
	CTLogger.writeToLog("@@AfterClass - KKPurchaseDVDMoviesRunner");
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
