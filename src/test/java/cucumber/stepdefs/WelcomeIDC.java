package cucumber.stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import com.accenture.aaft.report.ExtentTestManager;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.accenture.aaft.logger.CTLogger;

/**
* Step Definitions for running tests using Cucumber
* 
* @author      Lalitha Yengaldas
* @version     1.0
*/
@RunWith(Cucumber.class)
public class WelcomeIDC {

static ExtentTest extentTest;
public WelcomeIDC() {
try{
	extentTest = ExtentTestManager.getTest();
	extentTest.log(LogStatus.INFO, "Starting test fileName");
	CTLogger.writeToLog("WelcomeIDC extentTest - "+extentTest);
}catch(Exception ex){
	try {	
		ex.printStackTrace();
	CTLogger.writeToLog("WelcomeIDC","constructor called"," exception occured");
} finally{
	String[] err = ex.getMessage().split("\n");
	String status = "Exception " +err[0].replaceAll("'", "") + " Occurred";
	extentTest.log(LogStatus.FAIL, "failed to load dependency classes "+status);
}
}
}
/**
* Step definition for I am in to the Touchless Testing Demo
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@Given("^I am in to the Touchless Testing Demo$")
	 public void i_am_in_to_the_touchless_testing_demo() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered i_am_in_to_the_touchless_testing_demo");
	 CTLogger.writeToLog("i_am_in_to_the_touchless_testing_demo");
	 extentTest.log(LogStatus.INFO, "Coming out of i_am_in_to_the_touchless_testing_demo");
	  //throw new PendingException();
	 } 

/**
* Step definition for I bought a purchase for ipad in ebay
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@When("^I bought a purchase for ipad in ebay$")
	 public void i_bought_a_purchase_for_ipad_in_ebay() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered i_bought_a_purchase_for_ipad_in_ebay");
	 CTLogger.writeToLog("i_bought_a_purchase_for_ipad_in_ebay");
	 extentTest.log(LogStatus.INFO, "Coming out of i_bought_a_purchase_for_ipad_in_ebay");
	  //throw new PendingException();
	 } 

/**
* Step definition for I should be able to see the confirmation page in ebay
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@Then("^I should be able to see the confirmation page in ebay$")
	 public void i_should_be_able_to_see_the_confirmation_page_in_ebay() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered i_should_be_able_to_see_the_confirmation_page_in_ebay");
	 CTLogger.writeToLog("i_should_be_able_to_see_the_confirmation_page_in_ebay");
	 extentTest.log(LogStatus.INFO, "Coming out of i_should_be_able_to_see_the_confirmation_page_in_ebay");
	  //throw new PendingException();
	 } 

}
