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


@RunWith(Cucumber.class) 
@CucumberOptions(features = "target/test-classes/cucumber/features/", tags = { "@EBAYPurchase" }, format = { "html:target/cucumber-report/step" },
glue = { "cucumber.stepdefs", "cucumber.stepdefs.EBAY" })
public class EBAYRunner {
	static ExtentReports extent;
	static String scriptName = "EBAY";


@BeforeClass
public static void runOnceBeforeClass() {
	extent = ExtentManager.getExtentManager();
	ExtentTestManager.startTest("Cucumber Test : " + scriptName, "EBAY");
	CTLogger.writeToLog("@BeforeClass EBAY extent - "+extent);
 }


@AfterClass
public static void runOnceAfterClass() {
	CTLogger.writeToLog("@AfterClass EBAY extent - "+extent);
	ExtentManager.getReporter().endTest(ExtentTestManager.getTest());
	ExtentManager.getReporter().flush();
 }
}
