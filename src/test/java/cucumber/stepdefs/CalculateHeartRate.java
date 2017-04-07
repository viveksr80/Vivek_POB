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
public class CalculateHeartRate {
  private WebDriver driver;
  String appPath = "sauce-storage:HealthCalculator.apk";
  static ExtentTest extentTest;
  PropertyFileReader propertyFileReader;
  LinkedHashMap<String, List<ExcelTestDataVO>> testDataMap = null;
  String scriptName = "CalculateHeartRate";
  String scenario = scriptName + " Calculating Heart Rate for a person";
  String objectMapFile = "healthcalculator.xls";

  static LinkedHashMap<String, ObjectMapVO> objectMap;
  static List<ExcelTestDataVO> voList;
  ObjectMapVO vo;

  HealthCalculator_PO pageObj = null;
  
  String executionType = "saucelabs-app"; 

  /**
   * Constructor
   */
  public CalculateHeartRate() {

	try {
	  propertyFileReader = new PropertyFileReader();
	  extentTest = ExtentTestManager.getTest();
	  extentTest.log(LogStatus.INFO, "Starting test HealthCalculator App");
	  CTLogger.writeToLog("CalculateHeartRate extentTest - " + extentTest);

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
		CTLogger.writeToLog("CalculateHeartRate", "constructor called", " exception occured");

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
  @Given("^I am on the HealtCalculator App for HeartRate calc \"([^\"]*)\"$")
  public void i_am_on_the_HealtCalculator_App_for_HeartRate_calc(String arg1) throws Throwable {
	CTLogger.writeToLog("i_am_on_the_HealtCalculator_App_for_HeartRate_calc");
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
   * Method is used to select HeartRate from the options
   *
   * @throws Throwable - represents exception
   */
  @When("^I select HeartRate from the options$")
  public void i_select_HeartRate_from_the_options() throws Throwable {
	CTLogger.writeToLog("i_select_HeartRate_from_the_options");
	pageObj.openHealtCalculatorApp(objectMap, "HeartRate");
  }

  /**
   * Method is used to provide the necessary details for HeartRate calculation
   *
   * @throws Throwable - represents exception
   */
  @When("^I provided the necessary details for HeartRate calc and clicked Calculate$")
  public void i_provided_the_necessary_details_for_HeartRate_calc_and_clicked_Calculate() throws Throwable {
	CTLogger.writeToLog("i_provided_the_necessary_details_for_HeartRate_calc_and_clicked_Calculate");
	pageObj.executeHealtCalculatorApp(objectMap, voList, "HeartRate");
  }

  /**
   * Method is used to see the calculated heart rate result
   *
   * @throws Throwable - represents exception
   */
  @Then("^I should see the calculated HeartRate result$")
  public void i_should_see_the_calculated_HeartRate_result() throws Throwable {
	CTLogger.writeToLog("i_should_see_the_calculated_HeartRate_result");
	pageObj.verifyHealtCalculatorApp(objectMap, "HeartRate");
	driver.quit();
  }

}
