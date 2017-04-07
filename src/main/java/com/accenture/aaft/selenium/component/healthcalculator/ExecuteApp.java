package com.accenture.aaft.selenium.component.healthcalculator;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.accenture.aaft.logger.CTLogger;
import com.accenture.aaft.propertyreader.PropertyFileReader;
import com.accenture.aaft.report.ExtentTestManager;
import com.accenture.aaft.selenium.library.Click;
import com.accenture.aaft.selenium.library.Input;
import com.accenture.aaft.selenium.library.WaitTime;
import com.accenture.aaft.vo.ExcelTestDataVO;
import com.accenture.aaft.vo.ObjectMapVO;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Class is used to execute web calculation application
 *
 * @author vijay.venkatappa
 *
 */
public class ExecuteApp {

  /**
   * Method is used to execute web calculation application
   *
   * @param webDriver - represents WebDriver
   * @param extentTest - represents ExtentTest
   * @param objecthashmap - represents LinkedHashMap<String, ObjectMapVO>
   * @param voList - represents List<ExcelTestDataVO
   * @param menuName - represents menu name
   * @return status
   */
  public String execulteCalculation(WebDriver webDriver, ExtentTest extentTest, LinkedHashMap<String, ObjectMapVO> objecthashmap, List<ExcelTestDataVO> voList, String menuName) {

	PropertyFileReader propertyFileReader = new PropertyFileReader();
	CTLogger.writeToLog("ExecuteApp", "execulteOpenApp()", " method called");

	String status = "true";
	ObjectMapVO objectMapVO = null;

	try {
	  Input input = new Input();
	  WaitTime wait = new WaitTime();
	  wait.waitTime("2");

	  int voListLength = voList.size();
	  int i = 1;
	  while (i < voListLength) {
		ExcelTestDataVO vo = voList.get(i);
		if (!vo.getName().equalsIgnoreCase("wait") && !vo.getName().equalsIgnoreCase("confirmText")) {
		  objectMapVO = objecthashmap.get(vo.getName());
		  input.enterText(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), vo.getValue(), extentTest, objectMapVO.getControlName());
		}
		i++;
	  }

	  Click click = new Click();
	  objectMapVO = objecthashmap.get(menuName + "Calc");
	  click.click(webDriver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), extentTest, objectMapVO.getControlName());

	  status = "true";
	} catch (Exception e) {
	  status = "false";
	  try {
		CTLogger.writeToLog("ExecuteApp", "execulteOpenApp()", " exeption thrown");
		e.printStackTrace();
	  } finally {
		extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(ExtentTestManager.captureScreen(webDriver, propertyFileReader.getValue("IMAGE_PATH") + "InputProspect COMPONENT")));
		webDriver.quit();
	  }
	}

	return status;

  }

}
