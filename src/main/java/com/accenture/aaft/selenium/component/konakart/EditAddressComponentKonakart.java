package com.accenture.aaft.selenium.component.konakart;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.accenture.aaft.logger.CTLogger;
import com.accenture.aaft.selenium.library.Click;
import com.accenture.aaft.selenium.library.Input;
import com.accenture.aaft.selenium.library.WaitTime;
import com.accenture.aaft.vo.ExcelTestDataVO;
import com.accenture.aaft.vo.ObjectMapVO;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * Class is used to edit address details in konakart application
 *
 * @author vijay.venkatappa
 *
 */
public class EditAddressComponentKonakart {

  /**
   * Method is used to edit address details
   *
   * @param webDriver - represents WebDriver
   * @param extentTest - represents ExtentTest
   * @param objecthashmap - represents LinkedHashMap<String, ObjectMapVO>
   * @param voList - represents List<ExcelTestDataVO>
   * @return status
   */
  public String executeEditAddressComponent(WebDriver webDriver, ExtentTest extentTest, LinkedHashMap<String, ObjectMapVO> objecthashmap, List<ExcelTestDataVO> voList) {

	CTLogger.writeToLog("LoginComponentKonakart", "loginComponent()", " method called");
	ObjectMapVO objectMapVO = null;
	String status = "false";
	;
	String firstName = "";
	String lastName = "";
	String companyName = "";
	String streetAddress = "";
	String subrub = "";
	String postCode = "";
	String city = "";
	String otherTelephone = "";

	for (ExcelTestDataVO vo : voList) {
	  if (vo.getName().equals("firstName")) {
		firstName = vo.getValue();
	  }
	  if (vo.getName().equals("lastName")) {
		lastName = vo.getValue();
	  }
	  if (vo.getName().equals("companyName")) {
		companyName = vo.getValue();
	  }
	  if (vo.getName().equals("streetAddress")) {
		streetAddress = vo.getValue();
	  }

	  if (vo.getName().equals("subrub")) {
		subrub = vo.getValue();
	  }
	  if (vo.getName().equals("postCode")) {
		postCode = vo.getValue();
	  }

	  if (vo.getName().equals("city")) {
		city = vo.getValue();
	  }
	  if (vo.getName().equals("otherTelephone")) {
		otherTelephone = vo.getValue();
	  }

	}
	try {
	  Click click = new Click();
	  objectMapVO = objecthashmap.get("clickOnEditAdress");
	  click.click(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), extentTest, objectMapVO.getControlName());

	  Input input = new Input();
	  objectMapVO = objecthashmap.get("enterFirstName");
	  input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), firstName, extentTest, objectMapVO.getControlName());

	  objectMapVO = objecthashmap.get("enterLastName");
	  input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), lastName, extentTest, objectMapVO.getControlName());

	  objectMapVO = objecthashmap.get("enterCompanyName");
	  input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), companyName, extentTest, objectMapVO.getControlName());

	  objectMapVO = objecthashmap.get("enterStreetAddress");
	  input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), streetAddress, extentTest, objectMapVO.getControlName());

	  objectMapVO = objecthashmap.get("enterSubrub");
	  input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), subrub, extentTest, objectMapVO.getControlName());

	  objectMapVO = objecthashmap.get("enterPostCode");
	  input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), postCode, extentTest, objectMapVO.getControlName());

	  objectMapVO = objecthashmap.get("enterCity");
	  input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), city, extentTest, objectMapVO.getControlName());

	  objectMapVO = objecthashmap.get("enterOtherTelephone");
	  input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), otherTelephone, extentTest, objectMapVO.getControlName());

	  click = new Click();
	  objectMapVO = objecthashmap.get("clickBack");
	  click.click(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), extentTest, objectMapVO.getControlName());

	  WaitTime waitTime = new WaitTime();
	  waitTime.waitTime("4", extentTest, "wait");

	  status = "true";

	} catch (Exception e) {
	  e.printStackTrace();
	  status = "false";
	}
	return status;

  }

}
