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
@CucumberOptions(features = "target/test-classes/cucumber/features/", tags = { "@TouchlessTestingDemo" }, format = { "html:target/cucumber-report/step" },
glue = { "cucumber.stepdefs", "cucumber.stepdefs.WelcomeToTTP3Demo" })
public class WelcomeToTTP3DemoRunner {
	static ExtentReports extent;
	static String scriptName = "WelcomeToTTP3Demo";


@BeforeClass
public static void runOnceBeforeClass() {
	extent = ExtentManager.getExtentManager();
	ExtentTestManager.startTest("Cucumber Test : " + scriptName, "WelcomeToTTP3Demo");
	CTLogger.writeToLog("@BeforeClass WelcomeToTTP3Demo extent - "+extent);
 }


@AfterClass
public static void runOnceAfterClass() {
	CTLogger.writeToLog("@AfterClass WelcomeToTTP3Demo extent - "+extent);
	ExtentManager.getReporter().endTest(ExtentTestManager.getTest());
	ExtentManager.getReporter().flush();
 }
}
