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
import com.accenture.aaft.selenium.component.konakart.EditAddressComponentKonakart;
import com.accenture.aaft.selenium.component.konakart.LoginComponentKonakart;
import com.accenture.aaft.selenium.driver.SeleniumDriver;
import com.accenture.aaft.selenium.library.Click;
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
 * Class is used as future Definitions for running tests using Cucumber
 *
 * @author vijay.venkatappa
 *
 */
public class KKPurchaseGames {
  private WebDriver driver;
  String url = "http://localhost:8780/konakart/LogIn.action";
  static ExtentTest extentTest;
  PropertyFileReader propertyFileReader;
  LinkedHashMap<String, List<ExcelTestDataVO>> testDataMap = null;
  String scriptName = "Online Store";
  String scenario = scriptName + "_konakart purchasegames";
  String objectMapFile = "konakart-objectmap.xls";
  String productName = "games";
  Click click = new Click();
  WaitTime wait = new WaitTime();
  MouseOverAndClick mouseOverAndClick = new MouseOverAndClick();
  LinkedHashMap<String, ObjectMapVO> objectMap;
  List<ExcelTestDataVO> voList;

  ObjectMapVO objectMapVO = null;
  String executionType = "local";
  /**
   * Constructor
   */
	public KKPurchaseGames() {

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
			propertyFileReader = new PropertyFileReader();
			extentTest = ExtentTestManager.getTest();
			extentTest.log(LogStatus.INFO, "Starting test konakart purchaseGames");
			CTLogger.writeToLog("KKPurchasegames extentTest - " + extentTest);

			ObjectMapReader objectMapReader = new ObjectMapReader();
			objectMap = objectMapReader.readObjectMap(objectMapFile);

			ExcelTestDataReader excelTestDataReader = new ExcelTestDataReader();
			testDataMap = excelTestDataReader.readTestData("konakart purchaseGames");
			Set<String> set = testDataMap.keySet();
			Iterator<String> it = set.iterator();
			String key = it.next();
			voList = (List<ExcelTestDataVO>) testDataMap.get(key);

		} catch (Exception ex) {
			try {
				ex.printStackTrace();
				CTLogger.writeToLog("KKPurchasegames", "constructor called", " exception occured");

			} finally {

				String[] err = ex.getMessage().split("\n");
				String status = "Exception " + err[0].replaceAll("'", "") + " Occurred";
				extentTest.log(LogStatus.FAIL, "failed to load dependency classes " + status);
				extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(ExtentTestManager.captureScreen(driver,
						propertyFileReader.getValue("IMAGE_PATH") + "dataread")));
				driver.close();
				driver.quit();
			}

		}
	}

  /**
   * Method is used to login to konkart games store
   *
   * @param arg1 - represents dummy argument
   * @throws Throwable - represents exception
   */
  @Given("^I Login to Konkart games store \"([^\"]*)\"$")
  public void I_Login_to_Konkart_games_store(String arg1) throws Throwable {

	CTLogger.writeToLog("I_Login_to_Konkart_games_store");
	LaunchUrl launchUrl = new LaunchUrl();
	launchUrl.launchUrl(driver, url, extentTest);
	LoginComponentKonakart loginComponentKonakart = new LoginComponentKonakart();
	loginComponentKonakart.executeLoginComponent(driver, extentTest, objectMap, voList);

  }

  /**
   * Method is used to select games
   *
   * @throws Throwable - represents exception
   */
  @When("^I select games$")
  public void I_select_games() throws Throwable {

	CTLogger.writeToLog("I_select_games");

	objectMapVO = objectMap.get("clickOnGames");
	click.click(driver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), extentTest, objectMapVO.getControlName());

	objectMapVO = objectMap.get("clickOnAction");
	click.click(driver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), extentTest, objectMapVO.getControlName());

	objectMapVO = objectMap.get("clickOnCallOfDuty");
	click.click(driver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), extentTest, objectMapVO.getControlName());
  }

  /**
   * Method is used to add games to cart and checkout
   *
   * @throws Throwable - represents exception
   */
  @And("^Add games to cart and checkout$")
  public void Add_games_to_cart_and_checkout() throws Throwable {

	CTLogger.writeToLog("Add_games_to_cart_and_checkout");

	objectMapVO = objectMap.get("clickOnAddtoCart");
	click.click(driver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), extentTest, objectMapVO.getControlName());

	objectMapVO = objectMap.get("clickcheckout");
	click.click(driver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), extentTest, objectMapVO.getControlName());

  }

  /**
   * Method is used to edit billing details for games checkout
   *
   * @throws Throwable - represents exception
   */
  @And("^Edit billing details for games checkout$")
  public void Edit_billing_details_for_games_checkout() throws Throwable {

	CTLogger.writeToLog("Edit_billing_details_for_games_checkout");
	EditAddressComponentKonakart editAddressComponentKonakart = new EditAddressComponentKonakart();
	editAddressComponentKonakart.executeEditAddressComponent(driver, extentTest, objectMap, voList);

  }

  /**
   * Method is used to purchase games and confirm
   *
   * @throws Throwable - represents exception
   */
  @Then("^I should be on the purchase games confirmation page$")
  public void I_should_be_on_the_purchase_games_confirmation_page() throws Throwable {
	try {
	  CTLogger.writeToLog("I_should_be_on_the_purchase_games_confirmation_page");
	  objectMapVO = objectMap.get("clickConfirmOrder");
	  click.click(driver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), extentTest, objectMapVO.getControlName());

	  objectMapVO = objectMap.get("clickOnLogOff");
	  click.click(driver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), extentTest, objectMapVO.getControlName());

	} finally {
	  driver.close();
	  driver.quit();
	}
  }
}
