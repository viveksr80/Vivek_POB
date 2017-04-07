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
public class ReturningaLaptop {

static ExtentTest extentTest;
public ReturningaLaptop() {
try{
	extentTest = ExtentTestManager.getTest();
	extentTest.log(LogStatus.INFO, "Starting test fileName");
	CTLogger.writeToLog("ReturningaLaptop extentTest - "+extentTest);
}catch(Exception ex){
	try {	
		ex.printStackTrace();
	CTLogger.writeToLog("ReturningaLaptop","constructor called"," exception occured");
} finally{
	String[] err = ex.getMessage().split("\n");
	String status = "Exception " +err[0].replaceAll("'", "") + " Occurred";
	extentTest.log(LogStatus.FAIL, "failed to load dependency classes "+status);
}
}
}
/**
* Step definition for Jacob has bought a Laptop for $800
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@Given("^Jacob has bought a Laptop for \\$800$")
	 public void jacob_has_bought_a_laptop_for_800() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered jacob_has_bought_a_laptop_for_$800");
	 CTLogger.writeToLog("jacob_has_bought_a_laptop_for_$800");
	 extentTest.log(LogStatus.INFO, "Coming out of jacob_has_bought_a_laptop_for_$800");
	  //throw new PendingException();
	 } 

/**
* Step definition for he has a receipt for the laptop purchase
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@And("^he has a receipt for the laptop purchase$")
	 public void he_has_a_receipt_for_the_laptop_purchase() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered he_has_a_receipt_for_the_laptop_purchase");
	 CTLogger.writeToLog("he_has_a_receipt_for_the_laptop_purchase");
	 extentTest.log(LogStatus.INFO, "Coming out of he_has_a_receipt_for_the_laptop_purchase");
	  //throw new PendingException();
	 } 

/**
* Step definition for he returns the laptop
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@When("^he returns the laptop$")
	 public void he_returns_the_laptop() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered he_returns_the_laptop");
	 CTLogger.writeToLog("he_returns_the_laptop");
	 extentTest.log(LogStatus.INFO, "Coming out of he_returns_the_laptop");
	  //throw new PendingException();
	 } 

/**
* Step definition for Jacob should be refunded $800
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@Then("^Jacob should be refunded \\$800$")
	 public void jacob_should_be_refunded_800() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered jacob_should_be_refunded_$800");
	 CTLogger.writeToLog("jacob_should_be_refunded_$800");
	 extentTest.log(LogStatus.INFO, "Coming out of jacob_should_be_refunded_$800");
	  //throw new PendingException();
	 } 

}
