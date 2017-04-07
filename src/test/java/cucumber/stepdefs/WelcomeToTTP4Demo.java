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
public class WelcomeToTTP4Demo {

static ExtentTest extentTest;
public WelcomeToTTP4Demo() {
try{
	extentTest = ExtentTestManager.getTest();
	extentTest.log(LogStatus.INFO, "Starting test fileName");
	CTLogger.writeToLog("WelcomeToTTP4Demo extentTest - "+extentTest);
}catch(Exception ex){
	try {	
		ex.printStackTrace();
	CTLogger.writeToLog("WelcomeToTTP4Demo","constructor called"," exception occured");
} finally{
	String[] err = ex.getMessage().split("\n");
	String status = "Exception " +err[0].replaceAll("'", "") + " Occurred";
	extentTest.log(LogStatus.FAIL, "failed to load dependency classes "+status);
}
}
}
/**
* Step definition for Log in to the Touchless Testing Platform for TTP4 Demo
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@Given("^Log in to the Touchless Testing Platform for TTP4 Demo$")
	 public void log_in_to_the_touchless_testing_platform_for_ttp4_demo() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered log_in_to_the_touchless_testing_platform_for_ttp4_demo");
	 CTLogger.writeToLog("log_in_to_the_touchless_testing_platform_for_ttp4_demo");
	 extentTest.log(LogStatus.INFO, "Coming out of log_in_to_the_touchless_testing_platform_for_ttp4_demo");
	  //throw new PendingException();
	 } 

/**
* Step definition for upload the TTP4 Test case data through Test Optimization
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@When("^upload the TTP4 Test case data through Test Optimization$")
	 public void upload_the_ttp4_test_case_data_through_test_optimization() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered upload_the_ttp4_test_case_data_through_test_optimization");
	 CTLogger.writeToLog("upload_the_ttp4_test_case_data_through_test_optimization");
	 extentTest.log(LogStatus.INFO, "Coming out of upload_the_ttp4_test_case_data_through_test_optimization");
	  //throw new PendingException();
	 } 

/**
* Step definition for should be able to see the Optimizied TTP4 Test case
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@Then("^should be able to see the Optimizied TTP4 Test case$")
	 public void should_be_able_to_see_the_optimizied_ttp4_test_case() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered should_be_able_to_see_the_optimizied_ttp4_test_case");
	 CTLogger.writeToLog("should_be_able_to_see_the_optimizied_ttp4_test_case");
	 extentTest.log(LogStatus.INFO, "Coming out of should_be_able_to_see_the_optimizied_ttp4_test_case");
	  //throw new PendingException();
	 } 

}
