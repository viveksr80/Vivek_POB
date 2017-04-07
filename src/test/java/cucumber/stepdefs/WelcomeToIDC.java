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
public class WelcomeToIDC {

static ExtentTest extentTest;
public WelcomeToIDC() {
try{
	extentTest = ExtentTestManager.getTest();
	extentTest.log(LogStatus.INFO, "Starting test fileName");
	CTLogger.writeToLog("WelcomeToIDC extentTest - "+extentTest);
}catch(Exception ex){
	try {	
		ex.printStackTrace();
	CTLogger.writeToLog("WelcomeToIDC","constructor called"," exception occured");
} finally{
	String[] err = ex.getMessage().split("\n");
	String status = "Exception " +err[0].replaceAll("'", "") + " Occurred";
	extentTest.log(LogStatus.FAIL, "failed to load dependency classes "+status);
}
}
}
/**
* Step definition for I Log in to the Touchless Testing Platform
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@Given("^I Log in to the Touchless Testing Platform$")
	 public void i_log_in_to_the_touchless_testing_platform() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered i_log_in_to_the_touchless_testing_platform");
	 CTLogger.writeToLog("i_log_in_to_the_touchless_testing_platform");
	 extentTest.log(LogStatus.INFO, "Coming out of i_log_in_to_the_touchless_testing_platform");
	  //throw new PendingException();
	 } 

/**
* Step definition for I upload the Defect data through Defect Optimization
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@When("^I upload the Defect data through Defect Optimization$")
	 public void i_upload_the_defect_data_through_defect_optimization() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered i_upload_the_defect_data_through_defect_optimization");
	 CTLogger.writeToLog("i_upload_the_defect_data_through_defect_optimization");
	 extentTest.log(LogStatus.INFO, "Coming out of i_upload_the_defect_data_through_defect_optimization");
	  //throw new PendingException();
	 } 

/**
* Step definition for I should be able to see the Optimizied Defect Details
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@Then("^I should be able to see the Optimizied Defect Details$")
	 public void i_should_be_able_to_see_the_optimizied_defect_details() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered i_should_be_able_to_see_the_optimizied_defect_details");
	 CTLogger.writeToLog("i_should_be_able_to_see_the_optimizied_defect_details");
	 extentTest.log(LogStatus.INFO, "Coming out of i_should_be_able_to_see_the_optimizied_defect_details");
	  //throw new PendingException();
	 } 

}
