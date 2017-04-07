package com.accenture.aaft.selenium.component.konakart;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.accenture.aaft.logger.CTLogger;
import com.accenture.aaft.selenium.library.ClickCP;
import com.accenture.aaft.selenium.library.InputCP;
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
public class EditAddressComponentKonakartCP {

  /**
   * Method is used to edit address details
   *
   * @param webDriver - represents WebDriver
   * @param extentTest - represents ExtentTest
   * @param objecthashmap - represents LinkedHashMap<String, ObjectMapVO>
   * @param voList - represents List<ExcelTestDataVO>
   * @return status
   */
	@SuppressWarnings("unused")
  public String executeEditAddressComponent(WebDriver webDriver, ExtentTest extentTest, LinkedHashMap<String, ObjectMapVO> objecthashmap, List<ExcelTestDataVO> voList) {

	CTLogger.writeToLog("EditAddressComponentKonakartCP", "executeEditAddressComponent()", " method called");
	ObjectMapVO objectMapVO = null;
	String status = "";
	String cpStatus="true";
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
	  ClickCP click = new ClickCP();
	  objectMapVO = objecthashmap.get("clickOnEditAdress");
	  click.click(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), extentTest, objectMapVO.getControlName());
      
	  InputCP input = new InputCP();
	  objectMapVO = objecthashmap.get("enterFirstName");
	  status = input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), firstName, extentTest, objectMapVO.getControlName());
		
	  objectMapVO = objecthashmap.get("enterLastName");
	  status = input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), lastName, extentTest, objectMapVO.getControlName());
	 
	  objectMapVO = objecthashmap.get("enterCompanyName");
	  status =  input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), companyName, extentTest, objectMapVO.getControlName());
		  
	  objectMapVO = objecthashmap.get("enterStreetAddress");
	  status = input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), streetAddress, extentTest, objectMapVO.getControlName());
	  
	  objectMapVO = objecthashmap.get("enterSubrub");
	  status =  input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), subrub, extentTest, objectMapVO.getControlName());
	  
	  objectMapVO = objecthashmap.get("enterPostCode");
	  status = input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), postCode, extentTest, objectMapVO.getControlName());
	 
	  objectMapVO = objecthashmap.get("enterCity");
	  status = input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), city, extentTest, objectMapVO.getControlName());
	 
	  objectMapVO = objecthashmap.get("enterOtherTelephone");
	  status = input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), otherTelephone, extentTest, objectMapVO.getControlName());
	  
	  click = new ClickCP();
	  objectMapVO = objecthashmap.get("clickBack");
	  status =  click.click(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), extentTest, objectMapVO.getControlName());
	  
	  WaitTime waitTime = new WaitTime();
	  waitTime.waitTime("4", extentTest, "wait");
	 
	  status = "true";
	
	} catch (Exception e) {
	  //e.printStackTrace();
	  status = "false";
	}
	return status;

  }

}
