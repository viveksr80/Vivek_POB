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
public class BuyinganIMac {

static ExtentTest extentTest;
public BuyinganIMac() {
try{
	extentTest = ExtentTestManager.getTest();
	extentTest.log(LogStatus.INFO, "Starting test fileName");
	CTLogger.writeToLog("BuyinganIMac extentTest - "+extentTest);
}catch(Exception ex){
	try {	
		ex.printStackTrace();
	CTLogger.writeToLog("BuyinganIMac","constructor called"," exception occured");
} finally{
	String[] err = ex.getMessage().split("\n");
	String status = "Exception " +err[0].replaceAll("'", "") + " Occurred";
	extentTest.log(LogStatus.FAIL, "failed to load dependency classes "+status);
}
}
}
/**
* Step definition for John has having a accoutn balance of $3000
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@Given("^John has having a accoutn balance of \\$3000$")
	 public void john_has_having_a_accoutn_balance_of_3000() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered john_has_having_a_accoutn_balance_of_$3000");
	 CTLogger.writeToLog("john_has_having_a_accoutn_balance_of_$3000");
	 extentTest.log(LogStatus.INFO, "Coming out of john_has_having_a_accoutn_balance_of_$3000");
	  //throw new PendingException();
	 } 

/**
* Step definition for he has a Mastero debit card
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@And("^he has a Mastero debit card$")
	 public void he_has_a_mastero_debit_card() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered he_has_a_mastero_debit_card");
	 CTLogger.writeToLog("he_has_a_mastero_debit_card");
	 extentTest.log(LogStatus.INFO, "Coming out of he_has_a_mastero_debit_card");
	  //throw new PendingException();
	 } 

/**
* Step definition for he swipes the Mastero debit card
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@When("^he swipes the Mastero debit card$")
	 public void he_swipes_the_mastero_debit_card() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered he_swipes_the_mastero_debit_card");
	 CTLogger.writeToLog("he_swipes_the_mastero_debit_card");
	 extentTest.log(LogStatus.INFO, "Coming out of he_swipes_the_mastero_debit_card");
	  //throw new PendingException();
	 } 

/**
* Step definition for John should be delivered with an iMac
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@Then("^John should be delivered with an iMac$")
	 public void john_should_be_delivered_with_an_imac() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered john_should_be_delivered_with_an_imac");
	 CTLogger.writeToLog("john_should_be_delivered_with_an_imac");
	 extentTest.log(LogStatus.INFO, "Coming out of john_should_be_delivered_with_an_imac");
	  //throw new PendingException();
	 } 

}
