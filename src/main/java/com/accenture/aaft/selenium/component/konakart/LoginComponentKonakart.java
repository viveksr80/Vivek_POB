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
 * Class is used to login to the konakart application
 *
 * @author vijay.venkatappa
 *
 */
public class LoginComponentKonakart {

  /**
   * Method is used to login to the konakart application
   *
   * @param webDriver - represents WebDriver
   * @param extentTest - represents ExtentTest
   * @param objecthashmap - represents LinkedHashMap<String, ObjectMapVO>
   * @param voList - represents List<ExcelTestDataVO>
   * @return status
   */
  public String executeLoginComponent(WebDriver webDriver, ExtentTest extentTest, LinkedHashMap<String, ObjectMapVO> objecthashmap, List<ExcelTestDataVO> voList) {

	CTLogger.writeToLog("LoginComponentKonakart", "loginComponent()", " method called");
	ObjectMapVO objectMapVO = null;
	String status = "false";
	String email = "";
	String password = "";
	for (ExcelTestDataVO vo : voList) {
	  if (vo.getName().equals("email")) {
		email = vo.getValue();
	  }
	  if (vo.getName().equals("password")) {
		password = vo.getValue();
	  }
	}
	try {
	  Click click = new Click();
	  objectMapVO = objecthashmap.get("clickOnMyAccount");
	  click.click(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), extentTest, objectMapVO.getControlName());

	  Input input = new Input();
	  objectMapVO = objecthashmap.get("enterEmailAddress");
	  input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), email, extentTest, objectMapVO.getControlName());

	  objectMapVO = objecthashmap.get("enterPassword");
	  input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), password, extentTest, objectMapVO.getControlName());

	  click = new Click();
	  objectMapVO = objecthashmap.get("clickOnSignIn");
	  click.click(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), extentTest, objectMapVO.getControlName());

	  WaitTime waitTime = new WaitTime();
	  waitTime.waitTime("3", extentTest, "wait");

	  status = "true";

	} catch (Exception e) {
	  e.printStackTrace();
	  status = "false";
	}
	return status;

  }

}
