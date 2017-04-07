package com.accenture.aaft.selenium.component.t24;

import java.util.LinkedHashMap;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.accenture.aaft.logger.CTLogger;
import com.accenture.aaft.propertyreader.PropertyFileReader;
import com.accenture.aaft.report.ExtentTestManager;
import com.accenture.aaft.selenium.library.Click;
import com.accenture.aaft.vo.ObjectMapVO;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Class is used to delete the person record in store domeqa application
 *
 * @author vijay.venkatappa
 *
 */
public class DeletePersonRecord {

  /**
   * Method is used to delete the person record
   *
   * @param driver - represents WebDriver
   * @param extentTest - represents ExtentTest
   * @param objecthashmap - represents LinkedHashMap<String, ObjectMapVO>
   * @return status
   */
  public String executeDeletePerson(WebDriver driver, ExtentTest extentTest, LinkedHashMap<String, ObjectMapVO> objecthashmap) {

	String firstWinHandle = null;
	ObjectMapVO objectMapVO = null;
	String status = "false";
	CTLogger.writeToLog("DeletePersonRecord", "executeDeletePerson()", " method called");
	PropertyFileReader propertyFileReader = new PropertyFileReader();

	try {
	  Thread.sleep(20);

	  Click click = new Click();
	  objectMapVO = objecthashmap.get("AuthoriseOrDelete");
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

	  objectMapVO = objecthashmap.get("ClickOnDeleteImage");
	  click.click(driver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), extentTest, objectMapVO.getControlName());

	  objectMapVO = objecthashmap.get("DeleteRecord");
	  WebDriverWait wait = new WebDriverWait(driver, 20);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectMapVO.getObjectPath())));

	  driver.close();
	  // switch back to main window
	  driver.switchTo().window(firstWinHandle);
	  status = "true";

	  if (status.equals("true")) {
		extentTest.log(LogStatus.PASS, " DeletePersonRecord COMPONENT executed successfullly");
	  } else {
		extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(ExtentTestManager.captureScreen(driver, propertyFileReader.getValue("IMAGE_PATH") + "DeletePersonRecord COMPONENT")));
	  }

	} catch (Exception e) {
	  try {
		CTLogger.writeToLog("DeletePersonRecord", "executeDeletePerson()", " exeption thrown");
		e.printStackTrace();
	  } finally {
		extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(ExtentTestManager.captureScreen(driver, propertyFileReader.getValue("IMAGE_PATH") + "DeletePersonRecord COMPONENT")));
		driver.quit();
	  }
	}
	return status;
  }
}
