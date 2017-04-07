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
public class Flipkart2 {

static ExtentTest extentTest;
public Flipkart2() {
try{
	extentTest = ExtentTestManager.getTest();
	extentTest.log(LogStatus.INFO, "Starting test fileName");
	CTLogger.writeToLog("Flipkart2 extentTest - "+extentTest);
}catch(Exception ex){
	try {	
		ex.printStackTrace();
	CTLogger.writeToLog("Flipkart2","constructor called"," exception occured");
} finally{
	String[] err = ex.getMessage().split("\n");
	String status = "Exception " +err[0].replaceAll("'", "") + " Occurred";
	extentTest.log(LogStatus.FAIL, "failed to load dependency classes "+status);
}
}
}
/**
* Step definition for I want to deposit1
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@Given("^I want to deposit1$")
	 public void i_want_to_deposit1() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered i_want_to_deposit1");
	 CTLogger.writeToLog("i_want_to_deposit1");
	 extentTest.log(LogStatus.INFO, "Coming out of i_want_to_deposit1");
	  throw new PendingException();
	 } 

/**
* Step definition for I make a deposit of amount1
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@When("^I make a deposit of amount1$")
	 public void i_make_a_deposit_of_amount1() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered i_make_a_deposit_of_amount1");
	 CTLogger.writeToLog("i_make_a_deposit_of_amount1");
	 extentTest.log(LogStatus.INFO, "Coming out of i_make_a_deposit_of_amount1");
	  throw new PendingException();
	 } 

/**
* Step definition for my account contains amount1
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@Then("^my account contains amount1$")
	 public void my_account_contains_amount1() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered my_account_contains_amount1");
	 CTLogger.writeToLog("my_account_contains_amount1");
	 extentTest.log(LogStatus.INFO, "Coming out of my_account_contains_amount1");
	  throw new PendingException();
	 } 

}
