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
public class Returningatelevision {

static ExtentTest extentTest;
public Returningatelevision() {
try{
	extentTest = ExtentTestManager.getTest();
	extentTest.log(LogStatus.INFO, "Starting test fileName");
	CTLogger.writeToLog("Returningatelevision extentTest - "+extentTest);
}catch(Exception ex){
	try {	
		ex.printStackTrace();
	CTLogger.writeToLog("Returningatelevision","constructor called"," exception occured");
} finally{
	String[] err = ex.getMessage().split("\n");
	String status = "Exception " +err[0].replaceAll("'", "") + " Occurred";
	extentTest.log(LogStatus.FAIL, "failed to load dependency classes "+status);
}
}
}
/**
* Step definition for Immanuel has bought a television for $550
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@Given("^Immanuel has bought a television for \\$550$")
	 public void immanuel_has_bought_a_television_for_550() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered immanuel_has_bought_a_television_for_$550");
	 CTLogger.writeToLog("immanuel_has_bought_a_television_for_$550");
	 extentTest.log(LogStatus.INFO, "Coming out of immanuel_has_bought_a_television_for_$550");
	  //throw new PendingException();
	 } 

/**
* Step definition for he has a receipt for the television purchase
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@And("^he has a receipt for the television purchase$")
	 public void he_has_a_receipt_for_the_television_purchase() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered he_has_a_receipt_for_the_television_purchase");
	 CTLogger.writeToLog("he_has_a_receipt_for_the_television_purchase");
	 extentTest.log(LogStatus.INFO, "Coming out of he_has_a_receipt_for_the_television_purchase");
	  //throw new PendingException();
	 } 

/**
* Step definition for he returns the television
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@When("^he returns the television$")
	 public void he_returns_the_television() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered he_returns_the_television");
	 CTLogger.writeToLog("he_returns_the_television");
	 extentTest.log(LogStatus.INFO, "Coming out of he_returns_the_television");
	  //throw new PendingException();
	 } 

/**
* Step definition for Immanuel should be refunded $550
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@Then("^Immanuel should be refunded \\$550$")
	 public void immanuel_should_be_refunded_550() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered immanuel_should_be_refunded_$550");
	 CTLogger.writeToLog("immanuel_should_be_refunded_$550");
	 extentTest.log(LogStatus.INFO, "Coming out of immanuel_should_be_refunded_$550");
	  //throw new PendingException();
	 } 

}
