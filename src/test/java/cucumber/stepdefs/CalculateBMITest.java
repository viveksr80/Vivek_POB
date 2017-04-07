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
public class CalculateBMITest {

static ExtentTest extentTest;
public CalculateBMITest() {
try{
	extentTest = ExtentTestManager.getTest();
	extentTest.log(LogStatus.INFO, "Starting test fileName");
	CTLogger.writeToLog("CalculateBMITest extentTest - "+extentTest);
}catch(Exception ex){
	try {	
		ex.printStackTrace();
	CTLogger.writeToLog("CalculateBMITest","constructor called"," exception occured");
} finally{
	String[] err = ex.getMessage().split("\n");
	String status = "Exception " +err[0].replaceAll("'", "") + " Occurred";
	extentTest.log(LogStatus.FAIL, "failed to load dependency classes "+status);
}
}
}
/**
* Step definition for I am on the HealtCalculator App Test "./testscriptrepository/testdata/TestData.xls"
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@Given("^I am on the HealtCalculator App Test \"([^\"]*)\"$")
	 public void i_am_on_the_healtcalculator_app_test_(String args1) throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered i_am_on_the_healtcalculator_app_test_");
	 CTLogger.writeToLog("i_am_on_the_healtcalculator_app_test_");
	 extentTest.log(LogStatus.INFO, "Coming out of i_am_on_the_healtcalculator_app_test_");
	  //throw new PendingException();
	 } 

/**
* Step definition for I select BMI from the options Test
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@When("^I select BMI from the options Test$")
	 public void i_select_bmi_from_the_options_test() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered i_select_bmi_from_the_options_test");
	 CTLogger.writeToLog("i_select_bmi_from_the_options_test");
	 extentTest.log(LogStatus.INFO, "Coming out of i_select_bmi_from_the_options_test");
	  //throw new PendingException();
	 } 

/**
* Step definition for I provided the necessary details and clicked Calculate Test
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@And("^I provided the necessary details and clicked Calculate Test$")
	 public void i_provided_the_necessary_details_and_clicked_calculate_test() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered i_provided_the_necessary_details_and_clicked_calculate_test");
	 CTLogger.writeToLog("i_provided_the_necessary_details_and_clicked_calculate_test");
	 extentTest.log(LogStatus.INFO, "Coming out of i_provided_the_necessary_details_and_clicked_calculate_test");
	  //throw new PendingException();
	 } 

/**
* Step definition for I should see the calculated BMI result Test
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@Then("^I should see the calculated BMI result Test$")
	 public void i_should_see_the_calculated_bmi_result_test() throws Throwable {
	 extentTest.log(LogStatus.PASS, "Entered i_should_see_the_calculated_bmi_result_test");
	 CTLogger.writeToLog("i_should_see_the_calculated_bmi_result_test");
	 extentTest.log(LogStatus.INFO, "Coming out of i_should_see_the_calculated_bmi_result_test");
	  //throw new PendingException();
	 } 

}
