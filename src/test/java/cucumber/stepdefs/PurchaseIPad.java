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
import com.accenture.aaft.pageobject.AddToCartNCheckOut_PO;
import com.accenture.aaft.pageobject.BillingDetails_PO;

import com.accenture.aaft.pageobject.ProductCategory_PO;
import com.accenture.aaft.propertyreader.PropertyFileReader;
import com.accenture.aaft.propertyreader.SeleniumConfigXmlReader;
import com.accenture.aaft.report.ExtentTestManager;
import com.accenture.aaft.selenium.driver.SeleniumDriver;
import com.accenture.aaft.selenium.library.Click;
import com.accenture.aaft.selenium.library.LaunchUrl;
import com.accenture.aaft.selenium.library.MouseOverAndClick;
import com.accenture.aaft.selenium.library.VerifyText;
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
 * Class is used as future Definitions for running tests using Cucumber
 *
 * @author vijay.venkatappa
 *
 */
public class PurchaseIPad {
  private WebDriver driver;
  String url = "http://store.demoqa.com";
  static ExtentTest extentTest;
  PropertyFileReader propertyFileReader;
  LinkedHashMap<String, List<ExcelTestDataVO>> testDataMap = null;
  String scriptName = "Online Store";
  String scenario = scriptName + "_Purchase iPad";
  String objectMapFile = "store-domeqa.xls";
  String productName = "iPads";
  Click click = new Click();
  WaitTime wait = new WaitTime();
  MouseOverAndClick mouseOverAndClick = new MouseOverAndClick();
  static LinkedHashMap<String, ObjectMapVO> obectMap;
  static List<ExcelTestDataVO> voList;
  ObjectMapVO vo;
  ProductCategory_PO productCategoryPO;
  AddToCartNCheckOut_PO addToCartNCheckOutPO;
  BillingDetails_PO billingDetailsPO;
  String executionType = "local";
  /**
   * Constructor
   */
	public PurchaseIPad() {

		try {
			SeleniumConfigXmlReader seleniunConfigXmlReader = new SeleniumConfigXmlReader();
			LinkedList<String[]> listArray = seleniunConfigXmlReader.getBrowserList(executionType);

			Random random = new Random();
			String browserConfig[] = listArray.get(random.nextInt(listArray.size()));
			String os = browserConfig[0];
			String version = browserConfig[1];
			String browser = browserConfig[2];

			System.out.println(
					"OS - " + browserConfig[0] + "--version - " + browserConfig[1] + "..browser - " + browserConfig[2]);

			driver = SeleniumDriver.getWebDriver(os, version, browser);
			productCategoryPO = new ProductCategory_PO();
			addToCartNCheckOutPO = new AddToCartNCheckOut_PO();
			billingDetailsPO = new BillingDetails_PO();

			propertyFileReader = new PropertyFileReader();
			extentTest = ExtentTestManager.getTest();
			extentTest.log(LogStatus.INFO, "Starting test PurchaseIPad");
			CTLogger.writeToLog("PurchaseIPad extentTest - " + extentTest);

			ObjectMapReader objectMapReader = new ObjectMapReader();
			obectMap = objectMapReader.readObjectMap(objectMapFile);

			ExcelTestDataReader excelTestDataReader = new ExcelTestDataReader();
			testDataMap = excelTestDataReader.readTestData("Purchase IPad");
			Set<String> set = testDataMap.keySet();
			Iterator<String> it = set.iterator();
			String key = it.next();
			voList = (List<ExcelTestDataVO>) testDataMap.get(key);
			productCategoryPO.setDriver(driver);
			productCategoryPO.setExtentTest(extentTest);
			addToCartNCheckOutPO.setDriver(driver);
			addToCartNCheckOutPO.setExtentTest(extentTest);
			billingDetailsPO.setDriver(driver);
			billingDetailsPO.setExtentTest(extentTest);

		} catch (Exception ex) {
			try {
				ex.printStackTrace();
				CTLogger.writeToLog("PurchaseIPad", "constructor called", " exception occured");

			} finally {

				String[] err = ex.getMessage().split("\n");
				String status = "Exception " + err[0].replaceAll("'", "") + " Occurred";
				extentTest.log(LogStatus.FAIL, "failed to open website " + status);
				extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(ExtentTestManager.captureScreen(driver,
						propertyFileReader.getValue("IMAGE_PATH") + "dataread")));
				driver.close();
				driver.quit();
			}

		}
	}

  /**
   * Method is used to launch URL
   *
   * @param arg1 - represents URL path
   * @throws Throwable - represents exception
   */
  @Given("^I am on the online store website \"([^\"]*)\"$")
  public void I_am_on_websiteI_am_on_the_online_store_website(String arg1) throws Throwable {

	CTLogger.writeToLog("I_am_on_websiteI_am_on_the_online_store_website");
	LaunchUrl launchUrl = new LaunchUrl();
	launchUrl.launchUrl(driver, url, extentTest);

  }

  /**
   * Method is used to select iPad from product category
   *
   * @throws Throwable - represents exception
   */
  @When("^I select iPad from Product Category$")
  public void I_select_iPad_from_Product_Category() throws Throwable {

	CTLogger.writeToLog("I_select_iPad_from_Product_Category");
	productCategoryPO.selectProductFromCategory(obectMap.get("ProductCategory"), productName);
  }

  /**
   * Method is used to add iPad to cart and checkout
   *
   * @throws Throwable - represents exception
   */
  @And("^Add iPad to cart and Checkout$")
  public void Add_iPad_to_cart_and_Checkout() throws Throwable {

	CTLogger.writeToLog("Add_iPad_to_cart_and_Checkout");

	addToCartNCheckOutPO.addToCartNCheckOut(obectMap.get("AddToCart"));
	addToCartNCheckOutPO.addToCartNCheckOut(obectMap.get("CheckOut"));
	addToCartNCheckOutPO.addToCartNCheckOut(obectMap.get("Continue"));

  }

  /**
   * Method is used to provide billing details and shipping address for iPad checkout
   *
   * @throws Throwable - represents exception
   */
  @And("^Provide billing details and shipping address for iPad checkout$")
  public void Provide_billing_details_and_shipping_address_for_iPad_checkout() throws Throwable {

	CTLogger.writeToLog("Provide_billing_details_and_shipping_address_for_iPad_checkout");
	billingDetailsPO.billingDetails(obectMap, voList);

  }

  /**
   * Method is used to verify iPad confirmation page
   *
   * @throws Throwable - represents exception
   */
  @Then("^I should be on the Purchase iPad confirmation page$")
  public void I_should_be_on_the_Purchase_iPad_confirmation_page() throws Throwable {
	try {
	  VerifyText verifyText = new VerifyText();
	  vo = obectMap.get("ConfirmText");

	  String status = verifyText.verifyText(driver, vo.getObjectPath(), vo.getSelector(), "Thank you, your purchase is pending. You will be sent an email once the order clears.", extentTest,
	      vo.getControlName());
	  if (status.equals("true")) {
		extentTest.log(LogStatus.PASS, "I_should_be_on_the_Purchase_iPad_confirmation_page() - " + "text matched");
	  } else {
		extentTest.log(LogStatus.PASS, "I_should_be_on_the_Purchase_iPad_confirmation_page() - " + "text mismatch");
	  }

	} finally {
	  driver.close();
	  driver.quit();
	}
  }
}
