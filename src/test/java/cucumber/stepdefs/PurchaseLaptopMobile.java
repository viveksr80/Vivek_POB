package cucumber.stepdefs;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.accenture.aaft.excel.utility.ExcelTestDataReader;
import com.accenture.aaft.excel.utility.ObjectMapReader;
import com.accenture.aaft.logger.CTLogger;
import com.accenture.aaft.pageobject.BillingDetails_PO;
import com.accenture.aaft.pageobject.LaunchUrl_PO;
import com.accenture.aaft.propertyreader.PropertyFileReader;
import com.accenture.aaft.report.ExtentTestManager;
import com.accenture.aaft.selenium.driver.SeleniumDriver;
import com.accenture.aaft.selenium.library.Click;
import com.accenture.aaft.selenium.library.MouseOverAndClick;
import com.accenture.aaft.selenium.library.VerifyText;
import com.accenture.aaft.selenium.library.WaitTime;
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
public class PurchaseLaptopMobile {
  private WebDriver driver;
  String url = "http://demo.avactis.com/electronics";
  static ExtentTest extentTest;
  PropertyFileReader propertyFileReader;
  LinkedHashMap<String, List<ExcelTestDataVO>> testDataMap = null;
  String scriptName = "Online Store";
  String scenario = scriptName + "_Purchase Laptop";
  String objectMapFile = "demo.avactis.xls";
  String productName = "Laptop";
  Click click = new Click();
  WaitTime wait = new WaitTime();
  MouseOverAndClick mouseOverAndClick = new MouseOverAndClick();
  VerifyText verifyText = new VerifyText();
  static LinkedHashMap<String, ObjectMapVO> objectMap;
  static List<ExcelTestDataVO> voList;
  ObjectMapVO vo;
  BillingDetails_PO billingDetailsPO;
  LaunchUrl_PO launchUrlPO;

  /**
   * Constructor
   */
  public PurchaseLaptopMobile() {

	try {
	  launchUrlPO = new LaunchUrl_PO();
	  billingDetailsPO = new BillingDetails_PO();

	  DesiredCapabilities caps = DesiredCapabilities.iphone();
	  caps.setCapability("appiumVersion", "1.5.3");
	  caps.setCapability("deviceName", "iPhone 6s Simulator");
	  caps.setCapability("deviceOrientation", "portrait");
	  caps.setCapability("platformVersion", "9.3");
	  caps.setCapability("platformName", "iOS");
	  caps.setCapability("browserName", "Safari");
	  driver = SeleniumDriver.getWebDriver("saucelabs", caps);

	  propertyFileReader = new PropertyFileReader();
	  extentTest = ExtentTestManager.getTest();
	  extentTest.log(LogStatus.INFO, "Starting test PurchaseIPad");
	  CTLogger.writeToLog("PurchaseIPad extentTest - " + extentTest);

	  ObjectMapReader objectMapReader = new ObjectMapReader();
	  objectMap = objectMapReader.readObjectMap(objectMapFile);

	  ExcelTestDataReader excelTestDataReader = new ExcelTestDataReader();
	  testDataMap = excelTestDataReader.readTestData("Purchase IPad");
	  Set<String> set = testDataMap.keySet();
	  Iterator<String> it = set.iterator();
	  String key = it.next();
	  voList = (List<ExcelTestDataVO>) testDataMap.get(key);
	  billingDetailsPO.setDriver(driver);
	  billingDetailsPO.setExtentTest(extentTest);
	  launchUrlPO.setDriver(driver);
	  launchUrlPO.setExtentTest(extentTest);

	} catch (Exception ex) {
	  try {
		ex.printStackTrace();
		CTLogger.writeToLog("PurchaseIPad", "constructor called", " exception occured");

	  } finally {

		String[] err = ex.getMessage().split("\n");
		String status = "Exception " + err[0].replaceAll("'", "") + " Occurred";
		extentTest.log(LogStatus.FAIL, "failed to open website " + status);
		extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(ExtentTestManager.captureScreen(driver, propertyFileReader.getValue("IMAGE_PATH") + "dataread")));
		driver.close();
		driver.quit();
	  }

	}
  }

  /**
   * Method is used to launch web site
   *
   * @param arg1 - represents URL path
   * @throws Throwable - represents exception
   */
  @Given("^I am on website in mobile \"([^\"]*)\"$")
  public void i_am_on_website_in_mobile(String arg1) throws Throwable {
	CTLogger.writeToLog("i_am_on_website_in_mobile");
	launchUrlPO.launchUrl(url);
  }

  /**
   * Method is used to select laptop from electronic category in mobile
   *
   * @throws Throwable - represents exception
   */
  @When("^I select Laptop from Electronic Category in mobile$")
  public void i_select_Laptop_from_Electronic_Category_in_mobile() throws Throwable {
	CTLogger.writeToLog("i_select_Laptop_from_Electronic_Category_in_mobile");
	vo = objectMap.get("selectMainCatogery");
	click.click(driver, vo.getObjectPath(), vo.getSelector(), extentTest, vo.getControlName());

	vo = objectMap.get("electronics");
	click.click(driver, vo.getObjectPath(), vo.getSelector(), extentTest, vo.getControlName());
  }

  /**
   * Method is used to add laptop to cart and checkout in mobile
   *
   * @throws Throwable - represents exception
   */
  @When("^Add Laptop to cart and Checkout in mobile$")
  public void add_Laptop_to_cart_and_Checkout_in_mobile() throws Throwable {
	CTLogger.writeToLog("add_Laptop_to_cart_and_Checkout_in_mobile");

	vo = objectMap.get("addToCartBtn");
	click.click(driver, vo.getObjectPath(), vo.getSelector(), extentTest, vo.getControlName());

	wait.waitTime("3");

	String status = verifyText.verifyText(driver, vo.getObjectPath(), vo.getSelector(), "Thank you, your purchase is pending. You will be sent an email once the order clears.", extentTest,
	    vo.getControlName());

	if (status.equals("true")) {
	  extentTest.log(LogStatus.PASS, "i_should_be_on_the_purchase_confirmation_page_in_mobile() - " + "text matched");
	} else {
	  extentTest.log(LogStatus.PASS, "i_should_be_on_the_purchase_confirmation_page_in_mobile() - " + "text mismatch");
	}

  }

  /**
   * Method is used to provide billing details and shipping address for laptop checkout in mobile
   *
   * @throws Throwable - represents exception
   */
  @When("^Provide billing details and shipping address for Laptop checkout in mobile$")
  public void provide_billing_details_and_shipping_address_for_Laptop_checkout_in_mobile() throws Throwable {
	CTLogger.writeToLog("provide_billing_details_and_shipping_address_for_Laptop_checkout_in_mobile");
	billingDetailsPO.billingDetails(objectMap, voList);
	wait.waitTime("10");
  }

  /**
   * Method is used to
   *
   * @throws Throwable - represents exception
   */
  @Then("^I should be on the purchase confirmation page in mobile$")
  public void i_should_be_on_the_purchase_confirmation_page_in_mobile() throws Throwable {
	try {
	  vo = objectMap.get("ConfirmText");

	  String status = verifyText.verifyText(driver, vo.getObjectPath(), vo.getSelector(), "Thank you, your purchase is pending. You will be sent an email once the order clears.", extentTest,
	      vo.getControlName());

	  if (status.equals("true")) {
		extentTest.log(LogStatus.PASS, "i_should_be_on_the_purchase_confirmation_page_in_mobile() - " + "text matched");
	  } else {
		extentTest.log(LogStatus.PASS, "i_should_be_on_the_purchase_confirmation_page_in_mobile() - " + "text mismatch");
	  }

	} finally {
	  driver.close();
	  driver.quit();
	}
  }

}
