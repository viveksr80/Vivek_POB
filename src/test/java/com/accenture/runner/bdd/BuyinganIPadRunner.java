package com.accenture.runner.bdd;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber; 

import org.junit.AfterClass;
import org.junit.BeforeClass;
import com.accenture.aaft.logger.CTLogger;
import com.accenture.aaft.report.ExtentManager;
import com.accenture.aaft.report.ExtentTestManager;
import com.relevantcodes.extentreports.ExtentReports;

import com.accenture.aaft.selenium.library.utility.RestCall;


@RunWith(Cucumber.class) 
@CucumberOptions(features = "target/test-classes/cucumber/features/", tags = { "@buyaniPad" }, format = { "html:target/cucumber-report/step" },
glue = { "cucumber.stepdefs", "cucumber.stepdefs.BuyinganIPad" })
public class BuyinganIPadRunner {
	
 //Added as part of Live Reporting
  public static String RUNNER_SLNO;
  
	static ExtentReports extent;
	static String scriptName = "BuyinganIPad";


@BeforeClass
public static void runOnceBeforeClass() {
	extent = ExtentManager.getExtentManager();
	ExtentTestManager.startTest("Cucumber Test : " + scriptName, "BuyinganIPad", "com.accenture.runner.bdd.BuyinganIPadRunner");
	CTLogger.writeToLog("@BeforeClass BuyinganIPad extent - "+extent);
 }


@AfterClass
public static void runOnceAfterClass() {
	CTLogger.writeToLog("@AfterClass BuyinganIPad extent - "+extent);
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
