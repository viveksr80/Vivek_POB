package cucumber.stepdefs;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.accenture.aaft.excel.utility.ExcelTestDataReader;
import com.accenture.aaft.excel.utility.ObjectMapReader;
import com.accenture.aaft.logger.CTLogger;
import com.accenture.aaft.pageobject.HealthCalculator_PO;
import com.accenture.aaft.propertyreader.PropertyFileReader;
import com.accenture.aaft.propertyreader.SeleniumConfigXmlReader;
import com.accenture.aaft.report.ExtentTestManager;
import com.accenture.aaft.selenium.driver.SeleniumDriver;
import com.accenture.aaft.vo.ExcelTestDataVO;
import com.accenture.aaft.vo.ObjectMapVO;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Class is used as future Definitions for running tests using Cucumber
 *
 * @author vijay.venkatappa
 *
 */
public class CalculateBMI {
  private WebDriver driver;
  String appPath = "sauce-storage:HealthCalculator.apk";
  static ExtentTest extentTest;
  PropertyFileReader propertyFileReader;
  LinkedHashMap<String, List<ExcelTestDataVO>> testDataMap = null;
  String scriptName = "CalculateBMI";
  String scenario = scriptName + " Calculating BMI for a person";
  String objectMapFile = "healthcalculator.xls";

  static LinkedHashMap<String, ObjectMapVO> objectMap;
  static List<ExcelTestDataVO> voList;
  ObjectMapVO vo;

  HealthCalculator_PO pageObj = null;
  
  String executionType = "saucelabs-app"; 

  /**
   * Constructor
   */
  public CalculateBMI() {

	try {
	  propertyFileReader = new PropertyFileReader();
	  extentTest = ExtentTestManager.getTest();
	  extentTest.log(LogStatus.INFO, "Starting test HealthCalculator App");
	  CTLogger.writeToLog("BMICalculator extentTest - " + extentTest);

	  ObjectMapReader objectMapReader = new ObjectMapReader();
	  objectMap = objectMapReader.readObjectMap(objectMapFile);

	  ExcelTestDataReader excelTestDataReader = new ExcelTestDataReader();
	  testDataMap = excelTestDataReader.readTestData(scriptName);
	  Set<String> set = testDataMap.keySet();
	  Iterator<String> it = set.iterator();
	  String key = it.next();
	  voList = (List<ExcelTestDataVO>) testDataMap.get(key);

	  pageObj = new HealthCalculator_PO();
	  pageObj.setExtentTest(extentTest);

	} catch (Exception ex) {
	  try {
		ex.printStackTrace();
		CTLogger.writeToLog("CalculateBMI", "constructor called", " exception occured");

	  } finally {

		String[] err = ex.getMessage().split("\n");
		String status = "Exception " + err[0].replaceAll("'", "") + " Occurred";
		extentTest.log(LogStatus.FAIL, "failed to load dependency classes " + status);
		extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(ExtentTestManager.captureScreen(driver, propertyFileReader.getValue("IMAGE_PATH") + "dataread")));
		driver.quit();
	  }

	}
  }

  /**
   * Method is used to set DesiredCapabilities
   *
   * @param arg1 - represents dummy argument
   * @throws Throwable - represents exception
   */
  @Given("^I am on the HealtCalculator App \"([^\"]*)\"$")
  public void i_am_on_the_HealtCalculator_App(String arg1) throws Throwable {
	CTLogger.writeToLog("i_am_on_the_HealtCalculator_App");
	
    SeleniumConfigXmlReader seleniunConfigXmlReader = new SeleniumConfigXmlReader();	
	LinkedList<String[]> listArray= seleniunConfigXmlReader.getBrowserList(executionType);
	String browserConfig[] = listArray.get(1);

	String os = browserConfig[3];
	String version = browserConfig[4];
	String browser = browserConfig[2];
	String device = browserConfig[6];
	String deviceOrientation = browserConfig[5];
	String appiumVersion = browserConfig[7];
	String app = browserConfig[8];

	driver = SeleniumDriver.getRemoteWebDriver(executionType, os, version, browser,
			device, deviceOrientation, appiumVersion, app, scriptName);
	pageObj.setDriver(driver);
  }

  /**
   * Method is used to select BMI from the options
   *
   * @throws Throwable - represents exception
   */
  @When("^I select BMI from the options$")
  public void i_select_BMI_from_the_options() throws Throwable {
	CTLogger.writeToLog("i_am_on_the_HealtCalculator_App");
	pageObj.openHealtCalculatorApp(objectMap, "BMI");
  }

  /**
   * Method is used to provide the necessary details and clicking Calculate
   *
   * @throws Throwable - represents exception
   */
  @When("^I provided the necessary details and clicked Calculate$")
  public void i_provided_the_necessary_details_and_clicked_Calculate() throws Throwable {
	CTLogger.writeToLog("i_provided_the_necessary_details");
	pageObj.executeHealtCalculatorApp(objectMap, voList, "BMI");
  }

  /**
   * Method is used to calculated BMI result
   *
   * @throws Throwable - represents exception
   */
  @Then("^I should see the calculated BMI result$")
  public void i_should_see_the_calculated_BMI_result() throws Throwable {
	CTLogger.writeToLog("i_provided_the_necessary_details");
	pageObj.verifyHealtCalculatorApp(objectMap, "BMI");
	driver.quit();
  }

}
