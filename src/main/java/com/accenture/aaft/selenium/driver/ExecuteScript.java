package com.accenture.aaft.selenium.driver;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.accenture.aaft.excel.utility.ExcelTestDataReader;
import com.accenture.aaft.excel.utility.ExcelTestScriptReader;
import com.accenture.aaft.excel.utility.ObjectMapReader;
import com.accenture.aaft.propertyreader.PropertyFileReader;
import com.accenture.aaft.report.ExtentTestManager;
import com.accenture.aaft.selenium.library.CloseBrowser;
import com.accenture.aaft.selenium.library.utility.ComponentExecutor;
import com.accenture.aaft.vo.ExcelTestDataVO;
import com.accenture.aaft.vo.ExcelTestScriptVO;
import com.accenture.aaft.vo.ObjectMapVO;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Class is used to execute the excel based script
 *
 * @author vijay.venkatappa
 *
 */
@SuppressWarnings({ "unused" })
public class ExecuteScript {
	
  ExtentTest extentTest;
  PropertyFileReader propertyFileReader = new PropertyFileReader();
 
  int countComp = 0;
  int countKeyComp = 0;


	/**
	 * Method is used to execute the excel based script
	 *
	 * @param scriptName
	 *            - represents script name
	 * @param browser
	 *            - represents browser name
	 */
	public String executeScript(String scriptName, String os, String version, String browser, String executionType) {
		WebDriver webDriver = null;
		String ssesionId = "";
		if (executionType.equalsIgnoreCase("local")) {
			webDriver = SeleniumDriver.getWebDriver(os, version, browser);
			
		} else {
			webDriver = SeleniumDriver.getRemoteWebDriver(executionType, os, version, browser, scriptName);
			ssesionId = (((RemoteWebDriver) webDriver).getSessionId()).toString();
			
		}
		execute(webDriver, scriptName);
		return ssesionId;
	}
	
	/**
	 * Method is used to execute the excel based script
	 *
	 * @param scriptName
	 *            - represents script name
	 * @param browser
	 *            - represents browser name
	 */
	public String executeScript(String scriptName, String os, String version, String browser, String executionType, String device, String deviceOrientation, String appiumVersion, String app) {
		WebDriver webDriver = null;
		String ssesionId = "";

		webDriver = SeleniumDriver.getRemoteWebDriver(executionType, os, version, browser, device, deviceOrientation, appiumVersion, app, scriptName);
		ssesionId = (((RemoteWebDriver) webDriver).getSessionId()).toString();			
		
		execute(webDriver, scriptName);
		return ssesionId;
	}
 

 
  /**
   * Method is used to call ExecuteScriptForIncreaseReportCount class to increase the report count
   *
   * @param scriptName - represents script name
   */
  public void executeTestWithoutBrowser(String scriptName) {
	  ExecuteScriptForIncreaseReportCount executeScriptForIncreaseReportCount = new ExecuteScriptForIncreaseReportCount();
	  executeScriptForIncreaseReportCount.execute(scriptName);
  }
  /**
   * Method is used to execute steps/actions
   *
   * @param webDriver - represents WebDriver
   * @param scriptName - represents script name
   */
  private void execute(WebDriver webDriver, String scriptName) {
	ExtentTest testReporter;
	ExtentReports reporter;
	ExcelTestDataReader dataReader = new ExcelTestDataReader();
	LinkedHashMap<String, List<ExcelTestDataVO>> map = dataReader.readTestData(scriptName);

	Set<String> set = map.keySet();
	Iterator<String> it = set.iterator();
	int count = 0;
	String objectMapFile = "";

	while (it.hasNext()) {

	  LinkedHashMap<String, ObjectMapVO> objecthashmap = null;
	  String key = it.next();

	  extentTest = ExtentTestManager.getTest();

	  List<ExcelTestDataVO> voList = (List<ExcelTestDataVO>) map.get(key);

	  KeywordExecutor keywordExecutor = new KeywordExecutor();

	  ExcelTestScriptReader testScriptReader = new ExcelTestScriptReader();

	  List<ExcelTestScriptVO> listScriptVOs = testScriptReader.readWorkbook(scriptName);

	  for (ExcelTestScriptVO testVO : listScriptVOs) {
		try {
		 
		  if (null == webDriver) {
			break;
		  }

		} catch (TimeoutException timeoutException) {
		  System.out.println("WEB DRIVER TimeoutException -- " + webDriver);
		  if (webDriver != null) {
			webDriver.close();
		  }
		}

		String keyword = testVO.getKeyword().trim();
		String controlName = testVO.getControlName().trim();

		if (controlName.contains(".xls")) {
		  if (objectMapFile.equals("")) {
			ObjectMapReader objectMapReader = new ObjectMapReader();
			objecthashmap = objectMapReader.readObjectMap(controlName);
		  }
		}

		String param1 = testVO.getParam1().trim();
		String param2 = testVO.getParam2().trim();
		String param3 = testVO.getParam3().trim();
		String condition = testVO.getCondition().trim();

		String testStepNo = testVO.getTestStepNo();
		String testTtepDetails = testVO.getTestStepDetails();
		String screen = testVO.getScreen();
		String mainWindow = testVO.getMainWindow();
		String inputValue = "";
		for (ExcelTestDataVO vo : voList) {

		  if (vo.getName().equals(param1)) {
			inputValue = vo.getValue();
		  }
		  if (vo.getName().equals(param2)) {
			inputValue = inputValue + "," + vo.getValue();
		  }
		  if (vo.getName().equals(param3)) {
			inputValue = inputValue + "," + vo.getValue();
		  }
		}
		String objectName = "";
		String selector = "";
		if (keyword.equalsIgnoreCase("LAUNCH")) {

		} else if (keyword.equalsIgnoreCase("WAIT")) {

		} else if (keyword.equalsIgnoreCase("SELECTWINDOW")) {

		} else if (keyword.equalsIgnoreCase("LAUNCHAPP")) {
		  continue;
		} else {
		  if (!keyword.equalsIgnoreCase("COMPONENT")) {

			ObjectMapVO objectMapVO = objecthashmap.get(controlName);
			objectName = objectMapVO.getObjectPath();
			selector = objectMapVO.getSelector();
		  }

		}

		if (keyword.equalsIgnoreCase("COMPONENT")) {

		  ComponentExecutor componentExecutor = new ComponentExecutor();
		  componentExecutor.componentExecute(webDriver, inputValue, extentTest, objecthashmap, voList);
		} else {
		  keywordExecutor.executeKeyword(webDriver, keyword, controlName, param1, param2, param3, condition, testStepNo, testTtepDetails, screen, mainWindow, inputValue, extentTest, objectName,
		      selector);
		}
	  }
	  count++;

	  String webDriverString = webDriver.toString();

	  if (webDriverString != null && webDriverString.toLowerCase().indexOf("androiddriver") < 0 && webDriverString.toLowerCase().indexOf("iosdriver") < 0
	      && webDriverString.toLowerCase().indexOf("remotewebdriver") < 0 && webDriverString.toLowerCase().indexOf("ios") < 0 && webDriverString.toLowerCase().indexOf("iphone") < 0
	      && webDriverString.toLowerCase().indexOf("ipad") < 0 && webDriverString.toLowerCase().indexOf("android") < 0) {
		CloseBrowser closeBrowser = new CloseBrowser();
		String result = closeBrowser.closeBrowser(webDriver);
		if (result.equals("true")) {
		  extentTest.log(LogStatus.INFO, "Browser closed");
		} else {
		  extentTest.log(LogStatus.FAIL, "Browser not closed");
		}
	  }
	}

	webDriver.quit();
	extentTest.log(LogStatus.INFO, "Driver Quitted");
	
	try {
		String browserName = propertyFileReader.getValue("BROWSER_NAME");
		if(browserName.equalsIgnoreCase("chrome")){
			Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");
		}
		else if(browserName.equalsIgnoreCase("ie") || browserName.equalsIgnoreCase("internet")){
			Runtime.getRuntime().exec("taskkill /F /IM iedriverserver.exe");
		}
		
	} catch (IOException e) {
		e.printStackTrace();
	}
  }


  /**
   * Main method
   *
   * @param args - string arguments
   */
  public static void main(String[] args) {


  }

}
