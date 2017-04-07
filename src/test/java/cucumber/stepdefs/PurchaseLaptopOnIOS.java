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
import com.accenture.aaft.pageobject.LaunchUrl_PO;
import com.accenture.aaft.propertyreader.PropertyFileReader;
import com.accenture.aaft.report.ExtentTestManager;
import com.accenture.aaft.selenium.component.avactis.BillingDetails;
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
public class PurchaseLaptopOnIOS {
  private WebDriver driver;
  String url = "http://demo.avactis.com/electronics";
  static ExtentTest extentTest;
  PropertyFileReader propertyFileReader;
  LinkedHashMap<String, List<ExcelTestDataVO>> testDataMap = null;
  String scriptName = "PurchaseLaptop";
  String scenario = scriptName + "_Purchase Laptop";
  String objectMapFile = "demo-avactis.xls";
  String productName = "Laptop";
  Click click = new Click();
  WaitTime wait = new WaitTime();
  MouseOverAndClick mouseOverAndClick = new MouseOverAndClick();
  VerifyText verifyText = new VerifyText();
  static LinkedHashMap<String, ObjectMapVO> objectMap;
  static List<ExcelTestDataVO> voList;
  ObjectMapVO vo;
  LaunchUrl_PO launchUrlPO;

  /**
   * Constructor
   */
  public PurchaseLaptopOnIOS() {

	try {
	  launchUrlPO = new LaunchUrl_PO();

	  DesiredCapabilities caps = DesiredCapabilities.iphone();
	  caps.setCapability("appiumVersion", "1.5.3");
	  caps.setCapability("deviceName", "iPhone 6s Simulator");
	  caps.setCapability("deviceOrientation", "portrait");
	  caps.setCapability("platformVersion", "9.1");
	  caps.setCapability("platformName", "iOS");
	  caps.setCapability("browserName", "Safari");
	  driver = SeleniumDriver.getWebDriver("saucelabs", caps);

	  propertyFileReader = new PropertyFileReader();
	  extentTest = ExtentTestManager.getTest();
	  extentTest.log(LogStatus.INFO, "Starting test PurchaseLaptopOnIOS");
	  CTLogger.writeToLog("PurchaseLaptopOnIOS extentTest - " + extentTest);

	  ObjectMapReader objectMapReader = new ObjectMapReader();
	  objectMap = objectMapReader.readObjectMap(objectMapFile);

	  ExcelTestDataReader excelTestDataReader = new ExcelTestDataReader();
	  testDataMap = excelTestDataReader.readTestData(scriptName);
	  Set<String> set = testDataMap.keySet();
	  Iterator<String> it = set.iterator();
	  String key = it.next();
	  voList = (List<ExcelTestDataVO>) testDataMap.get(key);
	  launchUrlPO.setDriver(driver);
	  launchUrlPO.setExtentTest(extentTest);

	} catch (Exception ex) {
	  try {
		ex.printStackTrace();
		CTLogger.writeToLog("PurchaseLaptopOnIOS", "constructor called", " exception occured");
	  } finally {
		String[] err = ex.getMessage().split("\n");
		String status = "Exception " + err[0].replaceAll("'", "") + " Occurred";
		extentTest.log(LogStatus.FAIL, "failed to open website " + status);
		extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(ExtentTestManager.captureScreen(driver, propertyFileReader.getValue("IMAGE_PATH") + "dataread")));
		driver.quit();
	  }
	}
  }

  /**
   * Method is used open web site in IOS device
   *
   * @param arg1 - represents URL path
   * @throws Throwable - represents exception
   */
  @Given("^I am on website in IOS device \"([^\"]*)\"$")
  public void i_am_on_website_in_IOS_device(String arg1) throws Throwable {
	CTLogger.writeToLog("i_am_on_website_in_IOS_device");
	launchUrlPO.launchUrl(url);
  }

  /**
   * Method is used to select laptop from electronic category in IOS device
   *
   * @throws Throwable - represents exception
   */
  @When("^I select Laptop from Electronic Category in IOS device$")
  public void i_select_Laptop_from_Electronic_Category_in_IOS_device() throws Throwable {
	CTLogger.writeToLog("i_select_Laptop_from_Electronic_Category_in_IOS_device");
	vo = objectMap.get("selectMainCatogery");
	click.click(driver, vo.getObjectPath(), vo.getSelector(), extentTest, vo.getControlName());

	vo = objectMap.get("electronics");
	click.click(driver, vo.getObjectPath(), vo.getSelector(), extentTest, vo.getControlName());
  }

  /**
   * Method is used to add laptop to cart and checkout in IOS device
   *
   * @throws Throwable - represents exception
   */
  @When("^Add Laptop to cart and Checkout in IOS device$")
  public void add_Laptop_to_cart_and_Checkout_in_IOS_device() throws Throwable {
	CTLogger.writeToLog("add_Laptop_to_cart_and_Checkout_in_IOS_device");

	vo = objectMap.get("addToCartBtn");
	click.click(driver, vo.getObjectPath(), vo.getSelector(), extentTest, vo.getControlName());

	wait.waitTime("3");

	vo = objectMap.get("addedToCartMessage");
	String status = verifyText.verifyText(driver, vo.getObjectPath(), vo.getSelector(), "You added Ace Laptop to your shopping cart.", extentTest, vo.getControlName());

	if (status.equals("true")) {
	  extentTest.log(LogStatus.PASS, "add_Laptop_to_cart_and_Checkout_in_IOS_device() - " + "text matched");
	} else {
	  extentTest.log(LogStatus.PASS, "add_Laptop_to_cart_and_Checkout_in_IOS_device() - " + "text mismatch");
	}

	vo = objectMap.get("cart");
	click.click(driver, vo.getObjectPath(), vo.getSelector(), extentTest, vo.getControlName());
	wait.waitTime("1");

	vo = objectMap.get("checkoutBtn");
	click.click(driver, vo.getObjectPath(), vo.getSelector(), extentTest, vo.getControlName());
	wait.waitTime("3");

  }

  /**
   * Method is used to provide billing details and shipping address for laptop checkout in IOS device
   *
   * @throws Throwable - represents exception
   */
  @When("^Provide billing details and shipping address for Laptop checkout in IOS device$")
  public void provide_billing_details_and_shipping_address_for_Laptop_checkout_in_IOS_device() throws Throwable {
	CTLogger.writeToLog("provide_billing_details_and_shipping_address_for_Laptop_checkout_in_IOS_device");
	BillingDetails billingDetails = new BillingDetails();
	billingDetails.enterBillingDetails(driver, extentTest, objectMap, voList);
	wait.waitTime("10");
  }

  /**
   * Method is used verify confirmation page in IOS device
   *
   * @throws Throwable - represents exception
   */
  @Then("^I should be on the purchase confirmation page in IOS device$")
  public void i_should_be_on_the_purchase_confirmation_page_in_IOS_device() throws Throwable {
	try {
	  vo = objectMap.get("confirmText");
	  String status = verifyText.verifyText(driver, vo.getObjectPath(), vo.getSelector(), "We'll email you an order confirmation with details and tracking info.", extentTest, vo.getControlName());

	  if (status.equals("true")) {
		extentTest.log(LogStatus.PASS, "i_should_be_on_the_purchase_confirmation_page_in_IOS_device() - " + "text matched");
	  } else {
		extentTest.log(LogStatus.PASS, "i_should_be_on_the_purchase_confirmation_page_in_IOS_device() - " + "text mismatch");
	  }
	} finally {
	  driver.quit();
	}
  }

}
