package com.accenture.aaft.selenium.component.t24;

import java.util.LinkedHashMap;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.accenture.aaft.logger.CTLogger;
import com.accenture.aaft.propertyreader.PropertyFileReader;
import com.accenture.aaft.report.ExtentTestManager;
import com.accenture.aaft.selenium.library.Click;
import com.accenture.aaft.selenium.library.Input;

import com.accenture.aaft.vo.ObjectMapVO;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Class is used to amend person in store domeqa application
 *
 * @author vijay.venkatappa
 *
 */
public class AmendPersonRecord {

  /**
   * Method is used to amend person
   *
   * @param driver - represents WebDriver
   * @param extentTest - represents ExtentTest
   * @param objecthashmap - represents LinkedHashMap<String, ObjectMapVO>
   * @return status
   */
  public String executeAmendPerson(WebDriver driver, ExtentTest extentTest, LinkedHashMap<String, ObjectMapVO> objecthashmap) {

	CTLogger.writeToLog("AmendPersonRecord", "executeAmendPerson()", " method called");
	String firstWinHandle = null;
	ObjectMapVO objectMapVO = null;
	String status = "false";
	PropertyFileReader propertyFileReader = new PropertyFileReader();
	try {
	  Thread.sleep(20);
	  Click click = new Click();
	  objectMapVO = objecthashmap.get("Amend Person Record");
	  click.click(driver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), extentTest, objectMapVO.getControlName());

	  Thread.sleep(20);

	  Set<String> handles = driver.getWindowHandles();// To handle multiple windows
	  firstWinHandle = driver.getWindowHandle(); // To get your main window

	  handles.remove(firstWinHandle);
	  String winHandle = handles.iterator().next(); // To find popup window
	  String secondWinHandle = null;
	  if (winHandle != firstWinHandle) {
		secondWinHandle = winHandle;
	  }
	  driver.switchTo().window(secondWinHandle); // To switch to popup window

	  Thread.sleep(20);

	  Input input = new Input();
	  objectMapVO = objecthashmap.get("Country");
	  input.enterText(driver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), "INDIA", extentTest, objectMapVO.getControlName());
	  // driver.findElement(By.id("value:9:1:1")).sendKeys("INDIA");

	  objectMapVO = objecthashmap.get("Find");
	  click.click(driver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), extentTest, objectMapVO.getControlName());

	  driver.close();

	  // switch back to main window
	  driver.switchTo().window(firstWinHandle);
	  WebElement frame = driver.findElement(By.xpath("//html/frameset/frame[2]"));
	  driver.switchTo().frame(frame);
	  Thread.sleep(30);
	  status = "true";

	  if (status.equals("true")) {
		extentTest.log(LogStatus.PASS, " AmendPersonRecord COMPONENT executed successfullly");
	  } else {
		extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(ExtentTestManager.captureScreen(driver, propertyFileReader.getValue("IMAGE_PATH") + "AmendPersonRecord COMPONENT")));
	  }

	} catch (Exception e) {
	  try {
		CTLogger.writeToLog("AmendPersonRecord", "executeAmendPerson()", " exeption thrown");
		e.printStackTrace();
	  } finally {
		extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(ExtentTestManager.captureScreen(driver, propertyFileReader.getValue("IMAGE_PATH") + "AmendPersonRecord COMPONENT")));
		driver.quit();
	  }
	}
	return status;
  }
}
