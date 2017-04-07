package cucumber.stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import com.accenture.aaft.report.ExtentTestManager;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Class is used as future Definitions for running tests using Cucumber
 *
 * @author vijay.venkatappa
 *
 */
public class DriveCarDefinition {
  ExtentTest extentTest;

  /**
   * Constructor
   */
  public DriveCarDefinition() {
	extentTest = ExtentTestManager.getTest();
	System.out.println("in Drive Car");
  }

  /**
   * Method is used for ExtentReport log
   *
   * @throws Throwable - represents exception
   */
  @Given("^I have a car$")
  public void I_have_a_car() throws Throwable {
	extentTest.log(LogStatus.PASS, "I_have_a_car");
  }

  /**
   * Method is used for ExtentReport log
   *
   * @throws Throwable - represents exception
   */
  @When("^I learn driving$")
  public void I_learn_driving() throws Throwable {
	extentTest.log(LogStatus.PASS, "I_learn_driving");
  }

  /**
   * Method is used for ExtentReport log
   *
   * @throws Throwable - represents exception
   */
  @Then("^I can drive a car$")
  public void I_can_drive_a_car() throws Throwable {
	extentTest.log(LogStatus.PASS, "I_can_drive_a_car");
  }
}
