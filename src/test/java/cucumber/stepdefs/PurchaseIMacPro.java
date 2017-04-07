package cucumber.stepdefs;

import com.accenture.aaft.logger.CTLogger;
import com.accenture.aaft.propertyreader.PropertyFileReader;
import com.accenture.aaft.report.ExtentTestManager;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Class is used as future Definitions for running tests using Cucumber
 *
 * @author vijay.venkatappa
 *
 */
public class PurchaseIMacPro {
  ExtentTest extentTest;
  PropertyFileReader propertyFileReader;
  String scriptName = "Online Store";
  String scenario = scriptName + "_Purchase iMacPro";

  /**
   * Constructor
   */
  public PurchaseIMacPro() {
	propertyFileReader = new PropertyFileReader();
	extentTest = ExtentTestManager.getTest();
	CTLogger.writeToLog("PurchaseIMacPro extentTest - " + extentTest);
	extentTest.log(LogStatus.PASS, "I_am_on_website - URL Opened");
  }

  /**
   * Method is used to run a test
   *
   * @throws Throwable - represents exception
   */
  @Given("^I want to run a test$")
  public void I_want_to_run_a_test() throws Throwable {
	extentTest.log(LogStatus.PASS, "PurchaseIMacPro - TEST Complete");
	extentTest.log(LogStatus.PASS, "TEST Complete");
  }

  /**
   * Method is used to run a test
   *
   * @throws Throwable - represents exception
   */
  @When("^I need to run a test$")
  public void I_need_to_run_a_test() throws Throwable {
	extentTest.log(LogStatus.PASS, "TEST Complete");
  }

  /**
   * Method is used to run a test
   *
   * @throws Throwable - represents exception
   */
  @Then("^I should able to run a test$")
  public void I_should_able_to_run_a_test() throws Throwable {
	extentTest.log(LogStatus.PASS, "TEST Complete");
  }
}