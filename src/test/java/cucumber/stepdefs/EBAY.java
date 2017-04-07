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
public class EBAY {

static ExtentTest extentTest;
public EBAY() {
try{
	extentTest = ExtentTestManager.getTest();
	extentTest.log(LogStatus.INFO, "Starting test fileName");
	CTLogger.writeToLog("EBAY extentTest - "+extentTest);
}catch(Exception ex){
	try {	
		ex.printStackTrace();
	CTLogger.writeToLog("EBAY","constructor called"," exception occured");
} finally{
	String[] err = ex.getMessage().split("\n");
	String status = "Exception " +err[0].replaceAll("'", "") + " Occurred";
	extentTest.log(LogStatus.FAIL, "failed to load dependency classes "+status);
}
}
}
/**
* Step definition for Welcome to Touchless Testing
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@Given("^Welcome to Touchless Testing$")
	 public void welcome_to_touchless_testing() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered welcome_to_touchless_testing");
	 CTLogger.writeToLog("welcome_to_touchless_testing");
	 extentTest.log(LogStatus.INFO, "Coming out of welcome_to_touchless_testing");
	  //throw new PendingException();
	 } 

/**
* Step definition for I make a purchase for ipad in ebay
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@When("^I make a purchase for ipad in ebay$")
	 public void i_make_a_purchase_for_ipad_in_ebay() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered i_make_a_purchase_for_ipad_in_ebay");
	 CTLogger.writeToLog("i_make_a_purchase_for_ipad_in_ebay");
	 extentTest.log(LogStatus.INFO, "Coming out of i_make_a_purchase_for_ipad_in_ebay");
	  //throw new PendingException();
	 } 

/**
* Step definition for I should see the confirmation page in ebay
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@Then("^I should see the confirmation page in ebay$")
	 public void i_should_see_the_confirmation_page_in_ebay() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered i_should_see_the_confirmation_page_in_ebay");
	 CTLogger.writeToLog("i_should_see_the_confirmation_page_in_ebay");
	 extentTest.log(LogStatus.INFO, "Coming out of i_should_see_the_confirmation_page_in_ebay");
	  //throw new PendingException();
	 } 

}
