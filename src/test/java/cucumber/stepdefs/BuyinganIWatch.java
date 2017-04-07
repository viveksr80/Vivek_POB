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
public class BuyinganIWatch {

static ExtentTest extentTest;
public BuyinganIWatch() {
try{
	extentTest = ExtentTestManager.getTest();
	extentTest.log(LogStatus.INFO, "Starting test fileName");
	CTLogger.writeToLog("BuyinganIWatch extentTest - "+extentTest);
}catch(Exception ex){
	try {	
		ex.printStackTrace();
	CTLogger.writeToLog("BuyinganIWatch","constructor called"," exception occured");
} finally{
	String[] err = ex.getMessage().split("\n");
	String status = "Exception " +err[0].replaceAll("'", "") + " Occurred";
	extentTest.log(LogStatus.FAIL, "failed to load dependency classes "+status);
}
}
}
/**
* Step definition for John has having a accoutn balance of $6500
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@Given("^John has having a accoutn balance of \\$6500$")
	 public void john_has_having_a_accoutn_balance_of_6500() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered john_has_having_a_accoutn_balance_of_$6500");
	 CTLogger.writeToLog("john_has_having_a_accoutn_balance_of_$6500");
	 extentTest.log(LogStatus.INFO, "Coming out of john_has_having_a_accoutn_balance_of_$6500");
	  //throw new PendingException();
	 } 

/**
* Step definition for he has a American Express card
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@And("^he has a American Express card$")
	 public void he_has_a_american_express_card() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered he_has_a_american_express_card");
	 CTLogger.writeToLog("he_has_a_american_express_card");
	 extentTest.log(LogStatus.INFO, "Coming out of he_has_a_american_express_card");
	  //throw new PendingException();
	 } 

/**
* Step definition for he swipes the American Express card
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@When("^he swipes the American Express card$")
	 public void he_swipes_the_american_express_card() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered he_swipes_the_american_express_card");
	 CTLogger.writeToLog("he_swipes_the_american_express_card");
	 extentTest.log(LogStatus.INFO, "Coming out of he_swipes_the_american_express_card");
	  //throw new PendingException();
	 } 

/**
* Step definition for John should be delivered with an iWatch
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@Then("^John should be delivered with an iWatch$")
	 public void john_should_be_delivered_with_an_iwatch() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered john_should_be_delivered_with_an_iwatch");
	 CTLogger.writeToLog("john_should_be_delivered_with_an_iwatch");
	 extentTest.log(LogStatus.INFO, "Coming out of john_should_be_delivered_with_an_iwatch");
	  //throw new PendingException();
	 } 

}
