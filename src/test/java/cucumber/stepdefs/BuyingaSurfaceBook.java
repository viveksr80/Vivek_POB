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
public class BuyingaSurfaceBook {

static ExtentTest extentTest;
public BuyingaSurfaceBook() {
try{
	extentTest = ExtentTestManager.getTest();
	extentTest.log(LogStatus.INFO, "Starting test fileName");
	CTLogger.writeToLog("BuyingaSurfaceBook extentTest - "+extentTest);
}catch(Exception ex){
	try {	
		ex.printStackTrace();
	CTLogger.writeToLog("BuyingaSurfaceBook","constructor called"," exception occured");
} finally{
	String[] err = ex.getMessage().split("\n");
	String status = "Exception " +err[0].replaceAll("'", "") + " Occurred";
	extentTest.log(LogStatus.FAIL, "failed to load dependency classes "+status);
}
}
}
/**
* Step definition for John has having a accoutn balance of $7500
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@Given("^John has having a accoutn balance of \\$7500$")
	 public void john_has_having_a_accoutn_balance_of_7500() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered john_has_having_a_accoutn_balance_of_$7500");
	 CTLogger.writeToLog("john_has_having_a_accoutn_balance_of_$7500");
	 extentTest.log(LogStatus.INFO, "Coming out of john_has_having_a_accoutn_balance_of_$7500");
	  //throw new PendingException();
	 } 

/**
* Step definition for he has a VISA credit card
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@And("^he has a VISA credit card$")
	 public void he_has_a_visa_credit_card() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered he_has_a_visa_credit_card");
	 CTLogger.writeToLog("he_has_a_visa_credit_card");
	 extentTest.log(LogStatus.INFO, "Coming out of he_has_a_visa_credit_card");
	  //throw new PendingException();
	 } 

/**
* Step definition for he swipes the VISA credit card
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@When("^he swipes the VISA credit card$")
	 public void he_swipes_the_visa_credit_card() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered he_swipes_the_visa_credit_card");
	 CTLogger.writeToLog("he_swipes_the_visa_credit_card");
	 extentTest.log(LogStatus.INFO, "Coming out of he_swipes_the_visa_credit_card");
	  //throw new PendingException();
	 } 

/**
* Step definition for John should be delivered with the Surface Book
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@Then("^John should be delivered with the Surface Book$")
	 public void john_should_be_delivered_with_the_surface_book() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered john_should_be_delivered_with_the_surface_book");
	 CTLogger.writeToLog("john_should_be_delivered_with_the_surface_book");
	 extentTest.log(LogStatus.INFO, "Coming out of john_should_be_delivered_with_the_surface_book");
	  //throw new PendingException();
	 } 

}
