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
public class MakePayment {

static ExtentTest extentTest;
public MakePayment() {
try{
	extentTest = ExtentTestManager.getTest();
	extentTest.log(LogStatus.INFO, "Starting test fileName");
	CTLogger.writeToLog("MakePayment extentTest - "+extentTest);
}catch(Exception ex){
	try {	
		ex.printStackTrace();
	CTLogger.writeToLog("MakePayment","constructor called"," exception occured");
} finally{
	String[] err = ex.getMessage().split("\n");
	String status = "Exception " +err[0].replaceAll("'", "") + " Occurred";
	extentTest.log(LogStatus.FAIL, "failed to load dependency classes "+status);
}
}
}
/**
* Step definition for I am in ABC bank site
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@Given("^I am in ABC bank site$")
	 public void i_am_in_abc_bank_site() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered i_am_in_abc_bank_site");
	 CTLogger.writeToLog("i_am_in_abc_bank_site");
	 extentTest.log(LogStatus.INFO, "Coming out of i_am_in_abc_bank_site");
	  //throw new PendingException();
	 } 

/**
* Step definition for I login and select the payment option in ABC
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@When("^I login and select the payment option in ABC$")
	 public void i_login_and_select_the_payment_option_in_abc() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered i_login_and_select_the_payment_option_in_abc");
	 CTLogger.writeToLog("i_login_and_select_the_payment_option_in_abc");
	 extentTest.log(LogStatus.INFO, "Coming out of i_login_and_select_the_payment_option_in_abc");
	  //throw new PendingException();
	 } 

/**
* Step definition for I should be able to do payment from ABC bank
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@Then("^I should be able to do payment from ABC bank$")
	 public void i_should_be_able_to_do_payment_from_abc_bank() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered i_should_be_able_to_do_payment_from_abc_bank");
	 CTLogger.writeToLog("i_should_be_able_to_do_payment_from_abc_bank");
	 extentTest.log(LogStatus.INFO, "Coming out of i_should_be_able_to_do_payment_from_abc_bank");
	  //throw new PendingException();
	 } 

}
