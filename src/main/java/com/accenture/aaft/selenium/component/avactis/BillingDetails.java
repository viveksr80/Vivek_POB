package com.accenture.aaft.selenium.component.avactis;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.accenture.aaft.logger.CTLogger;
import com.accenture.aaft.selenium.library.Click;
import com.accenture.aaft.selenium.library.Input;
import com.accenture.aaft.selenium.library.SelectFromList;
import com.accenture.aaft.selenium.library.WaitTime;
import com.accenture.aaft.vo.ExcelTestDataVO;
import com.accenture.aaft.vo.ObjectMapVO;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * Class is used to add billing details in konakart application
 *
 * @author vijay.venkatappa
 *
 */
public class BillingDetails {

  /**
   * Method is used to enter billing details
   *
   * @param webDriver - represents WebDriver
   * @param extentTest - represents ExtentTest
   * @param objecthashmap - represents LinkedHashMap<String, ObjectMapVO>
   * @param voList - represents List<ExcelTestDataVO>
   * @return status
   */
  public String enterBillingDetails(WebDriver webDriver, ExtentTest extentTest, LinkedHashMap<String, ObjectMapVO> objecthashmap, List<ExcelTestDataVO> voList) {

	CTLogger.writeToLog("BillingDetails", "enterBillingDetails()", " method called");
	ObjectMapVO objectMapVO = null;

	String status = "false";
	String email = "";
	String firstName = "";
	String lastName = "";
	String companyName = "";
	String country = "";
	String address1 = "";
	String address2 = "";
	String city = "";
	String pincode = "";
	String phoneNo = "";

	for (ExcelTestDataVO vo : voList) {
	  if (vo.getName().equals("billing-email")) {
		email = vo.getValue();
	  }
	  if (vo.getName().equals("billing-fname")) {
		firstName = vo.getValue();
	  }
	  if (vo.getName().equals("billing-lname")) {
		lastName = vo.getValue();
	  }
	  if (vo.getName().equals("billing-companyName")) {
		companyName = vo.getValue();
	  }
	  if (vo.getName().equals("billing-country")) {
		country = vo.getValue();
	  }
	  if (vo.getName().equals("billing-address-1")) {
		address1 = vo.getValue();
	  }
	  if (vo.getName().equals("billing-address-2")) {
		address2 = vo.getValue();
	  }
	  if (vo.getName().equals("billing-city")) {
		city = vo.getValue();
	  }
	  if (vo.getName().equals("billing-pincode")) {
		pincode = vo.getValue();
	  }
	  if (vo.getName().equals("billing-phoneNo")) {
		phoneNo = vo.getValue();
	  }
	}
	try {

	  Input input = new Input();
	  WaitTime waitTime = new WaitTime();
	  Click click = new Click();

	  objectMapVO = objecthashmap.get("billing-email");
	  input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), email, extentTest, objectMapVO.getControlName());

	  objectMapVO = objecthashmap.get("billing-fname");
	  input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), firstName, extentTest, objectMapVO.getControlName());

	  objectMapVO = objecthashmap.get("billing-lname");
	  input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), lastName, extentTest, objectMapVO.getControlName());

	  objectMapVO = objecthashmap.get("billing-companyName");
	  input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), companyName, extentTest, objectMapVO.getControlName());

	  objectMapVO = objecthashmap.get("billing-country");
	  SelectFromList select = new SelectFromList();
	  select.selectFromList(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), country, "value", extentTest, objectMapVO.getControlName());

	  objectMapVO = objecthashmap.get("billing-address-1");
	  input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), address1, extentTest, objectMapVO.getControlName());

	  objectMapVO = objecthashmap.get("billing-address-2");
	  input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), address2, extentTest, objectMapVO.getControlName());

	  objectMapVO = objecthashmap.get("billing-city");
	  input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), city, extentTest, objectMapVO.getControlName());

	  objectMapVO = objecthashmap.get("billing-pincode");
	  input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), pincode, extentTest, objectMapVO.getControlName());

	  objectMapVO = objecthashmap.get("billing-phoneNo");
	  input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), phoneNo, extentTest, objectMapVO.getControlName());

	  objectMapVO = objecthashmap.get("nextBtn");
	  click.click(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), extentTest, objectMapVO.getControlName());
	  waitTime.waitTime("2");

	  objectMapVO = objecthashmap.get("paymentMode");
	  click.click(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), extentTest, objectMapVO.getControlName());
	  waitTime.waitTime("2");

	  objectMapVO = objecthashmap.get("placeOrderBtn");
	  click.click(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), extentTest, objectMapVO.getControlName());

	  status = "true";

	} catch (Exception e) {
	  e.printStackTrace();
	  status = "false";
	}
	return status;

  }

}
