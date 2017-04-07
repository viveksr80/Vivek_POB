package com.accenture.aaft.selenium.component.storedomeqa;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.accenture.aaft.logger.CTLogger;
import com.accenture.aaft.propertyreader.PropertyFileReader;
import com.accenture.aaft.report.ExtentTestManager;
import com.accenture.aaft.selenium.library.Click;
import com.accenture.aaft.selenium.library.Input;
import com.accenture.aaft.selenium.library.SelectFromList;
import com.accenture.aaft.selenium.library.WaitTime;
import com.accenture.aaft.vo.ExcelTestDataVO;
import com.accenture.aaft.vo.ObjectMapVO;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Class is used to add billing details in store domeqa application
 *
 * @author vijay.venkatappa
 *
 */
public class BillingDetails {

  /**
   * Method is used to add billing details
   *
   * @param webDriver - represents WebDriver
   * @param extentTest - represents ExtentTest
   * @param objecthashmap - represents LinkedHashMap<String, ObjectMapVO>
   * @param voList - represents List<ExcelTestDataVO>
   * @return status
   */
  public String executeBillingDetails(WebDriver webDriver, ExtentTest extentTest, LinkedHashMap<String, ObjectMapVO> objecthashmap, List<ExcelTestDataVO> voList) {

	PropertyFileReader propertyFileReader = new PropertyFileReader();
	CTLogger.writeToLog("BillingDetails", "executeBillingDetails()", " method called");
	ObjectMapVO objectMapVO = null;
	String status = "false";
	String email = "";
	String firstname = "";
	String lastname = "";
	String address = "";
	String city = "";
	String state = "";
	String postalcode = "";
	String phone = "";
	String selection = "";
	String country = "";

	for (ExcelTestDataVO vo : voList) {

	  if (vo.getName().equals("email")) {
		email = vo.getValue();
	  }
	  if (vo.getName().equals("firstname")) {
		firstname = vo.getValue();
	  }
	  if (vo.getName().equals("lastname")) {
		lastname = vo.getValue();
	  }
	  if (vo.getName().equals("address")) {
		address = vo.getValue();
	  }
	  if (vo.getName().equals("city")) {
		city = vo.getValue();
	  }
	  if (vo.getName().equals("state")) {
		state = vo.getValue();
	  }
	  if (vo.getName().equals("postalcode")) {
		postalcode = vo.getValue();
	  }
	  if (vo.getName().equals("phone")) {
		phone = vo.getValue();
	  }
	  if (vo.getName().equals("selection")) {
		selection = vo.getValue();
	  }
	  if (vo.getName().equals("country")) {
		country = vo.getValue();
	  }
	}

	try {

	  WaitTime wait = new WaitTime();
	  wait.waitTime("8");

	  Input input = new Input();
	  objectMapVO = objecthashmap.get("Email");
	  input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), email, extentTest, objectMapVO.getControlName());

	  objectMapVO = objecthashmap.get("Bill-Firstname");
	  input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), firstname, extentTest, objectMapVO.getControlName());

	  objectMapVO = objecthashmap.get("Bill-LastName");
	  input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), lastname, extentTest, objectMapVO.getControlName());

	  objectMapVO = objecthashmap.get("Bill-Address");
	  input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), address, extentTest, objectMapVO.getControlName());

	  objectMapVO = objecthashmap.get("Bill-City");
	  input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), city, extentTest, objectMapVO.getControlName());

	  objectMapVO = objecthashmap.get("Bill-State");
	  input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), state, extentTest, objectMapVO.getControlName());

	  // Bill-SelectCountry pending

	  // select(webDriver, ".//*[@id='wpsc_checkout_form_16']", "label", "India");
	  SelectFromList selectFromList = new SelectFromList();
	  objectMapVO = objecthashmap.get("Bill-SelectCountry");
	  selectFromList.selectFromList(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), country, selection, extentTest, objectMapVO.getControlName());

	  objectMapVO = objecthashmap.get("Bill-Postalcode");
	  input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), postalcode, extentTest, objectMapVO.getControlName());

	  // Shipping address

	  objectMapVO = objecthashmap.get("Bill-Firstname2");
	  input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), firstname, extentTest, objectMapVO.getControlName());

	  objectMapVO = objecthashmap.get("Bill-LastName2");
	  input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), lastname, extentTest, objectMapVO.getControlName());

	  objectMapVO = objecthashmap.get("Bill-Address2");
	  input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), address, extentTest, objectMapVO.getControlName());

	  objectMapVO = objecthashmap.get("Bill-City2");
	  input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), city, extentTest, objectMapVO.getControlName());

	  objectMapVO = objecthashmap.get("Bill-State2");
	  input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), state, extentTest, objectMapVO.getControlName());

	  // Bill-SelectCountry pending

	  // select(webDriver, ".//*[@id='wpsc_checkout_form_16']", "label", "India");
	  selectFromList = new SelectFromList();
	  objectMapVO = objecthashmap.get("Bill-SelectCountry2");
	  selectFromList.selectFromList(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), country, selection, extentTest, objectMapVO.getControlName());

	  objectMapVO = objecthashmap.get("Bill-Postalcode2");
	  input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), postalcode, extentTest, objectMapVO.getControlName());

	  objectMapVO = objecthashmap.get("PhoneNo");
	  input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), phone, extentTest, objectMapVO.getControlName());

	  Click click = new Click();
	  objectMapVO = objecthashmap.get("Purchase");
	  click.click(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), extentTest, objectMapVO.getControlName());

	  String webdriverString = webDriver.toString();

	  if (webdriverString != null && webdriverString.toLowerCase().contains("remotewebdriver")) {
		objectMapVO = objecthashmap.get("Purchase");
		click.click(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), extentTest, objectMapVO.getControlName());
	  }

	  // if (!selenium.verifyText(driver, ".//*[@id='post-30']/div/div[2]/p[1]", "Thank you, your purchase is pending.
	  // You will be sent an email once the order clears.")) {
	  // throw new FailException("Text Mismatch for locator: .//*[@id='post-30']/div/div[2]/p[1]");
	  // }

	  status = "true";

	} catch (Exception e) {
	  try {
		CTLogger.writeToLog("BillingDetails", "executeBillingDetails()", " exeption thrown");
		e.printStackTrace();
	  } finally {
		extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(ExtentTestManager.captureScreen(webDriver, propertyFileReader.getValue("IMAGE_PATH") + "InputProspect COMPONENT")));
		webDriver.quit();
	  }
	}
	return status;
  }

  /**
   * Method is used to move to other web element
   *
   * @param driver - represents WebDriver
   * @param identifier - represents element identifier
   * @return status
   */
  public boolean moveToElement(WebDriver driver, String identifier) {
	try {
	  List<WebElement> elmList = driver.findElements(By.xpath(identifier));
	  WebElement element = null;
	  if (elmList != null && elmList.size() > 0) {
		element = elmList.get(0);
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	  }
	  return true;
	} catch (Exception e) {
	  e.printStackTrace();
	  return false;
	}

  }

  /**
   * Method is used to select web element
   *
   * @param driver - represents WebDriver
   * @param identifier - represents web element identifier
   * @param type - represents element type
   * @param value - represents element value
   * @return status
   * @throws Exception - exception details
   */
  public boolean select(WebDriver driver, String identifier, String type, String value) throws Exception {
	try {
	  List<WebElement> elmList = driver.findElements(By.xpath(identifier));
	  WebElement element = null;

	  if (elmList != null && elmList.size() > 0) {
		element = elmList.get(0);
		Select select = new Select(element);
		switch (type) {
		  case "value":
			select.selectByValue(value);
			break;

		  case "label":
			select.selectByVisibleText(value);
			break;

		  case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;

		  case "id":
			List<WebElement> selectOptions = select.getOptions();
			for (WebElement opt : selectOptions) {
			  if (opt.getAttribute("id") != null && opt.getAttribute("id").equalsIgnoreCase(value)) {
				select.selectByVisibleText(opt.getText());
			  }
			}
			break;
		}
	  }
	} catch (Exception e) {
	  throw e;
	}

	return true;
  }

  /**
   * Method is used to find web element type
   *
   * @param driver - represents WebDriver
   * @param identifier - represents web element identifier
   * @param value - represents web element value
   * @return status
   * @throws Exception - exception details
   */
  public boolean type(WebDriver driver, String identifier, String value) throws Exception {
	try {
	  List<WebElement> elmList = driver.findElements(By.xpath(identifier));
	  WebElement element = null;
	  String text = null;
	  if (elmList != null && elmList.size() > 0) {
		element = elmList.get(0);
		text = element.getAttribute("value");

		if (text != null && text.trim().length() > 0) {
		  element.clear();
		}
		element.sendKeys(value);
	  }
	} catch (Exception e) {
	  throw e;
	}

	return true;
  }

}
