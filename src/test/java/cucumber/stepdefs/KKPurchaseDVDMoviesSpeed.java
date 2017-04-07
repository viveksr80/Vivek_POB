package cucumber.stepdefs;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.accenture.aaft.excel.utility.ExcelTestDataReader;
import com.accenture.aaft.excel.utility.ObjectMapReader;
import com.accenture.aaft.logger.CTLogger;
import com.accenture.aaft.propertyreader.PropertyFileReader;
import com.accenture.aaft.propertyreader.SeleniumConfigXmlReader;
import com.accenture.aaft.report.ExtentTestManager;
import com.accenture.aaft.selenium.component.konakart.LoginComponentKonakart;
import com.accenture.aaft.selenium.driver.SeleniumDriver;
import com.accenture.aaft.selenium.library.ClickCP;
import com.accenture.aaft.selenium.library.LaunchUrl;
import com.accenture.aaft.selenium.library.MouseOverAndClick;
import com.accenture.aaft.selenium.library.WaitTime;
import com.accenture.aaft.vo.ExcelTestDataVO;
import com.accenture.aaft.vo.ObjectMapVO;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
* Step Definitions for running tests using Cucumber
* 
* @author      Lalitha Yengaldas
* @version     1.0
*/
public class KKPurchaseDVDMoviesSpeed {

	private WebDriver driver;
	  String url = "http://localhost:8780/konakart/LogIn.action";
	  static ExtentTest extentTest;
	  PropertyFileReader propertyFileReader;
	  LinkedHashMap<String, List<ExcelTestDataVO>> testDataMap = null;
	  String scriptName = "Online Store";
	  String scenario = scriptName + "_konakart purchaseDVDMoviesSpeed";
	  String objectMapFile = "konakart-objectmap.xls";
	  String productName = "dvdmovies";
	  ClickCP click = new ClickCP();
	  WaitTime wait = new WaitTime();
	  MouseOverAndClick mouseOverAndClick = new MouseOverAndClick();
	  LinkedHashMap<String, ObjectMapVO> objectMap;
	  List<ExcelTestDataVO> voList;

	  ObjectMapVO objectMapVO = null;
	  String executionType = "local";
/**
 * Constructor
 */
public KKPurchaseDVDMoviesSpeed() {

	try {
		SeleniumConfigXmlReader seleniunConfigXmlReader = new SeleniumConfigXmlReader();	
    	LinkedList<String[]> listArray = seleniunConfigXmlReader.getBrowserList(executionType);
    	
    	Random random = new Random();
    	String browserConfig[] = listArray.get(random.nextInt(listArray.size()));
		String os = browserConfig[0];
		String version = browserConfig[1];
		String browser = browserConfig[2];
		
		System.out.println("OS - "+browserConfig[0] + "--version - "+browserConfig[1] + "..browser - "+browserConfig[2]); 
		
    
	  driver = SeleniumDriver.getWebDriver(os, version, browser);

	  propertyFileReader = new PropertyFileReader();
	  extentTest = ExtentTestManager.getTest();
	  extentTest.log(LogStatus.INFO, "Starting test konakart purchaseDVDMoviesSpeed");
	  CTLogger.writeToLog("KKPurchasedvdmoviesSpeed extentTest - " + extentTest);

	  ObjectMapReader objectMapReader = new ObjectMapReader();
	  objectMap = objectMapReader.readObjectMap(objectMapFile);

	  ExcelTestDataReader excelTestDataReader = new ExcelTestDataReader();
	  testDataMap = excelTestDataReader.readTestData("konakart purchaseDVDMoviesSpeed");
	  Set<String> set = testDataMap.keySet();
	  Iterator<String> it = set.iterator();
	  String key = it.next();
	  voList = (List<ExcelTestDataVO>) testDataMap.get(key);

	} catch (Exception ex) {
	  try {
		ex.printStackTrace();
		CTLogger.writeToLog("KKPurchaseDVDMoviesSpeed", "constructor called", " exception occured");

	  } finally {

		String[] err = ex.getMessage().split("\n");
		String status = "Exception " + err[0].replaceAll("'", "") + " Occurred";
		extentTest.log(LogStatus.FAIL, "failed to load dependency classes " + status);
		extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(ExtentTestManager.captureScreen(driver, propertyFileReader.getValue("IMAGE_PATH") + "dataread")));
		driver.close();
		driver.quit();
	  }

	}
  }
/**
* Step definition for I Login to Konakart dvdmovies store "./testscriptrepository/testdata/TestData.xls"
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@Given("^I Login to Konakart dvdmovies store \"([^\"]*)\"$")
	 public void i_login_to_konakart_dvdmovies_store_(String args1) throws Throwable {
		
		CTLogger.writeToLog("I_Login_to_Konakart_dvdmovies_store");
		LaunchUrl launchUrl = new LaunchUrl();
		launchUrl.launchUrl(driver, url, extentTest);
		LoginComponentKonakart loginComponentKonakart = new LoginComponentKonakart();
		loginComponentKonakart.executeLoginComponent(driver, extentTest, objectMap, voList);
	    extentTest.log(LogStatus.INFO, "Entered i_login_to_konakart_dvdmovies_store_");
	    CTLogger.writeToLog("i_login_to_konakart_dvdmovies_store_");
	    extentTest.log(LogStatus.INFO, "Coming out of i_login_to_konakart_dvdmovies_store_");
	  //throw new PendingException();
	 } 

/**
* Step definition for I select dvdmovies Speed
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@When("^I select dvdmovies Speed$")
	 public void i_select_dvdmovies_speed() throws Throwable {
	 extentTest.log(LogStatus.INFO, "Entered i_select_dvdmovies_speed");
	 CTLogger.writeToLog("i_select_dvdmovies_speed");
	    objectMapVO = objectMap.get("ClickOnDVDMovies");
		click.click(driver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), extentTest, objectMapVO.getControlName());
        
        
		objectMapVO = objectMap.get("clickOnAction");
		click.click(driver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), extentTest, objectMapVO.getControlName());
		
		objectMapVO = objectMap.get("clickOnSpeed");
		click.click(driver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), extentTest, objectMapVO.getControlName());
        extentTest.log(LogStatus.INFO, "Coming out of i_select_dvdmovies_speed");
	  //throw new PendingException();
	 } 

/**
* Step definition for Add dvdmovie speed to cart and checkout
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@And("^Add dvdmovie speed to cart and checkout$")
	 public void add_dvdmovie_speed_to_cart_and_checkout() throws Throwable {
		
	 extentTest.log(LogStatus.INFO, "Entered add_dvdmovie_speed_to_cart_and_checkout");
	 CTLogger.writeToLog("add_dvdmovie_speed_to_cart_and_checkout");
	 objectMapVO = objectMap.get("clickOnAddtoCart");
	 click.click(driver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), extentTest, objectMapVO.getControlName());
	 
	 //objectMapVO = objectMap.get("clickcheckout");
	 //click.click(driver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), extentTest, objectMapVO.getControlName());
	 extentTest.log(LogStatus.INFO, "Coming out of add_dvdmovie_speed_to_cart_and_checkout");
	  //throw new PendingException();
	 } 

/**
* Step definition for Edit billing details for the movies speed and checkout
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@And("^Edit billing details for the movies speed and checkout$")
	 public void edit_billing_details_for_the_movies_speed_and_checkout() throws Throwable {
	
	 extentTest.log(LogStatus.INFO, "Entered edit_billing_details_for_the_movies_speed_and_checkout");
	 CTLogger.writeToLog("edit_billing_details_for_the_movies_speed_and_checkout");
	 //EditAddressComponentKonakartCP editAddressComponentKonakart = new EditAddressComponentKonakartCP();
	 //editAddressComponentKonakart.executeEditAddressComponent(driver, extentTest, objectMap, voList);
	 extentTest.log(LogStatus.INFO, "Coming out of edit_billing_details_for_the_movies_speed_and_checkout");
	  //throw new PendingException();
	 } 

/**
* Step definition for I should be on the purchase dvdmovies speed and confirmation page
*
* @param keyword  the keyword to display. 
* @param currentLine  description of step definition. 
* @param featureLine  the step definition to be invoked. 
*/
	@Then("^I should be on the purchase dvdmovies speed and confirmation page$")
	 public void i_should_be_on_the_purchase_dvdmovies_speed_and_confirmation_page() throws Throwable {
	 extentTest.log(LogStatus.INFO, "Entered i_should_be_on_the_purchase_dvdmovies_speed_and_confirmation_page");
	 CTLogger.writeToLog("i_should_be_on_the_purchase_dvdmovies_speed_and_confirmation_page");
	 //objectMapVO = objectMap.get("clickConfirmOrder");
	 //click.click(driver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), extentTest, objectMapVO.getControlName());

	 //objectMapVO = objectMap.get("clickOnLogOff");
	 //click.click(driver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), extentTest, objectMapVO.getControlName());
	 extentTest.log(LogStatus.INFO, "Logged Off");
	 driver.quit();
	  //throw new PendingException();
	 } 

}
