package cucumber.stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
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
public class ReturninganiPhone {

static ExtentTest extentTest;
public ReturninganiPhone() {
try{
	extentTest = ExtentTestManager.getTest();
	extentTest.log(LogStatus.INFO, "Starting test fileName");
	CTLogger.writeToLog("ReturninganiPhone extentTest - "+extentTest);
}catch(Exception ex){
	try {	
		ex.printStackTrace();
	CTLogger.writeToLog("ReturninganiPhone","constructor called"," exception occured");
} finally{
	String[] err = ex.getMessage().split("\n");
	String status = "Exception " +err[0].replaceAll("'", "") + " Occurred";
	extentTest.log(LogStatus.FAIL, "failed to load dependency classes "+status);
}
}
}
/**
* Step definition for Johanna has bought an iPhone for $900
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@Given("^Johanna has bought an iPhone for \\$900$")
	 public void johanna_has_bought_an_iphone_for_900() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered johanna_has_bought_an_iphone_for_$900");
	 CTLogger.writeToLog("johanna_has_bought_an_iphone_for_$900");
	 extentTest.log(LogStatus.INFO, "Coming out of johanna_has_bought_an_iphone_for_$900");
	  //throw new PendingException();
	 } 

/**
* Step definition for he has a receipt for the iPhone purchase
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@And("^he has a receipt for the iPhone purchase$")
	 public void he_has_a_receipt_for_the_iphone_purchase() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered he_has_a_receipt_for_the_iphone_purchase");
	 CTLogger.writeToLog("he_has_a_receipt_for_the_iphone_purchase");
	 extentTest.log(LogStatus.INFO, "Coming out of he_has_a_receipt_for_the_iphone_purchase");
	  //throw new PendingException();
	 } 

/**
* Step definition for he returns the iPhone
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@When("^he returns the iPhone$")
	 public void he_returns_the_iphone() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered he_returns_the_iphone");
	 CTLogger.writeToLog("he_returns_the_iphone");
	 extentTest.log(LogStatus.INFO, "Coming out of he_returns_the_iphone");
	  //throw new PendingException();
	 } 

/**
* Step definition for Johanna should be refunded $900
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@Then("^Johanna should be refunded \\$900$")
	 public void johanna_should_be_refunded_900() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered johanna_should_be_refunded_$900");
	 CTLogger.writeToLog("johanna_should_be_refunded_$900");
	 extentTest.log(LogStatus.INFO, "Coming out of johanna_should_be_refunded_$900");
	  //throw new PendingException();
	 } 

}
