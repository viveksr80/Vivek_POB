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
public class ABCBank {

static ExtentTest extentTest;
public ABCBank() {
try{
	extentTest = ExtentTestManager.getTest();
	extentTest.log(LogStatus.INFO, "Starting test fileName");
	CTLogger.writeToLog("ABCBank extentTest - "+extentTest);
}catch(Exception ex){
	try {	
		ex.printStackTrace();
	CTLogger.writeToLog("ABCBank","constructor called"," exception occured");
} finally{
	String[] err = ex.getMessage().split("\n");
	String status = "Exception " +err[0].replaceAll("'", "") + " Occurred";
	extentTest.log(LogStatus.FAIL, "failed to load dependency classes "+status);
}
}
}
/**
* Step definition for I am in ABC1 bank site
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@Given("^I am in ABC1 bank site$")
	 public void i_am_in_abc1_bank_site() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered i_am_in_abc1_bank_site");
	 CTLogger.writeToLog("i_am_in_abc1_bank_site");
	 extentTest.log(LogStatus.INFO, "Coming out of i_am_in_abc1_bank_site");
	  //throw new PendingException();
	 } 

/**
* Step definition for I login and select the payment option in ABC1
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@When("^I login and select the payment option in ABC1$")
	 public void i_login_and_select_the_payment_option_in_abc1() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered i_login_and_select_the_payment_option_in_abc1");
	 CTLogger.writeToLog("i_login_and_select_the_payment_option_in_abc1");
	 extentTest.log(LogStatus.INFO, "Coming out of i_login_and_select_the_payment_option_in_abc1");
	  //throw new PendingException();
	 } 

/**
* Step definition for I should be able to do payment from ABC1 bank
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@Then("^I should be able to do payment from ABC1 bank$")
	 public void i_should_be_able_to_do_payment_from_abc1_bank() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered i_should_be_able_to_do_payment_from_abc1_bank");
	 CTLogger.writeToLog("i_should_be_able_to_do_payment_from_abc1_bank");
	 extentTest.log(LogStatus.INFO, "Coming out of i_should_be_able_to_do_payment_from_abc1_bank");
	  //throw new PendingException();
	 } 

}
