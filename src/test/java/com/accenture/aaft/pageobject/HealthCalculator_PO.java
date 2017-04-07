package com.accenture.aaft.pageobject;

import java.util.LinkedHashMap;
import java.util.List;

import com.accenture.aaft.logger.CTLogger;
import com.accenture.aaft.report.ExtentTestManager;
import com.accenture.aaft.selenium.library.Click;
import com.accenture.aaft.selenium.library.VerifyText;
import com.accenture.aaft.selenium.library.WaitTime;
import com.accenture.aaft.vo.ExcelTestDataVO;
import com.accenture.aaft.vo.ObjectMapVO;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Class is used to open health calculator application
 *
 * @author vijay.venkatappa
 *
 */
@SuppressWarnings({ "unused" })
public class HealthCalculator_PO extends Base_PO {

  /**
   * Method is used to open health calculator application
   *
   * @param objecthashmap - represents LinkedHashMap<String, ObjectMapVO>
   * @param mainMenuName - represents menu name
   */
  public void openHealtCalculatorApp(LinkedHashMap<String, ObjectMapVO> objecthashmap, String mainMenuName) {
	try {

	  Click click = new Click();
	  WaitTime wait = new WaitTime();
	  ObjectMapVO objectVo = objecthashmap.get(mainMenuName);
	  click.click(driver, objectVo.getObjectPath(), objectVo.getSelector(), extentTest, objectVo.getControlName());
	  extentTest.log(LogStatus.PASS, "openHealtCalculatorApp - clicked on " + mainMenuName);
	} catch (Exception ex) {
	  try {
		ex.printStackTrace();
		CTLogger.writeToLog("HealthCalculator_PO", "openHealtCalculatorApp", " exception occured");
	  } finally {
		String[] err = ex.getMessage().split("\n");
		String status = "Exception " + err[0].replaceAll("'", "") + " Occurred";
		extentTest.log(LogStatus.FAIL, "openBMI " + status);
		extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(ExtentTestManager.captureScreen(driver, propertyFileReader.getValue("IMAGE_PATH") + "openBMI")));
		driver.quit();
	  }
	}
  }

  /**
   * Method is used to execute health calculation
   *
   * @param objectMap - represents LinkedHashMap<String, ObjectMapVO>
   * @param voList - represents List<ExcelTestDataVO>
   * @param menuName - represents menu name
   */
  public void executeHealtCalculatorApp(LinkedHashMap<String, ObjectMapVO> objectMap, List<ExcelTestDataVO> voList, String menuName) {
	try {
	  executeApp.execulteCalculation(driver, extentTest, objectMap, voList, menuName);
	  extentTest.log(LogStatus.PASS, "executeHealtCalculatorApp - Provide the necessary details to calulate the " + menuName + " and then clicked on Calculate");
	} catch (Exception ex) {
	  try {
		ex.printStackTrace();
		CTLogger.writeToLog("HealthCalculator_PO", "executeHealtCalculatorApp", " exception occured");
	  } finally {
		String[] err = ex.getMessage().split("\n");
		String status = "Exception " + err[0].replaceAll("'", "") + " Occurred";
		extentTest.log(LogStatus.FAIL, "openBMI " + status);
		extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(ExtentTestManager.captureScreen(driver, propertyFileReader.getValue("IMAGE_PATH") + "openBMI")));
		driver.quit();
	  }
	}
  }

  /**
   * Method is used to verify health calculation
   *
   * @param objectMap - represents LinkedHashMap<String, ObjectMapVO>
   * @param menuName - represents menu name
   */
  public void verifyHealtCalculatorApp(LinkedHashMap<String, ObjectMapVO> objectMap, String menuName) {
	try {
	  VerifyText verifyText = new VerifyText();
	  ObjectMapVO vo = objectMap.get(menuName + "ConfirmText");

	  String text = null;
	  if (menuName.equals("BMI")) {
		text = "Your Body Mass Index is";
	  } else if (menuName.equals("Calories")) {
		text = "Your estimated daily caloric need is";
	  } else if (menuName.equals("HeartRate")) {
		text = "Your maximun heart rate is";
	  } else if (menuName.equals("BloodVolume")) {
		text = "Your total blood volume is";
	  }

	  String status = verifyText.verifyText(driver, vo.getObjectPath(), vo.getSelector(), text, extentTest, vo.getControlName());
	  if (status.equals("true")) {
		extentTest.log(LogStatus.PASS, "Display " + menuName + " page - " + "text matched");
	  } else {
		extentTest.log(LogStatus.FAIL, "Display " + menuName + " page - " + "text mismatch");
	  }
	} catch (Exception ex) {
	  try {
		ex.printStackTrace();
		CTLogger.writeToLog("HealthCalculator_PO", "verifyHealtCalculatorApp", " exception occured");
	  } finally {
		String[] err = ex.getMessage().split("\n");
		String status = "Exception " + err[0].replaceAll("'", "") + " Occurred";
		extentTest.log(LogStatus.FAIL, "openBMI " + status);
		extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(ExtentTestManager.captureScreen(driver, propertyFileReader.getValue("IMAGE_PATH") + "openBMI")));
		driver.quit();
	  }
	}
  }

}
