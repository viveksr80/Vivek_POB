package com.accenture.aaft.selenium.component.t24;

import java.util.LinkedHashMap;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.accenture.aaft.logger.CTLogger;
import com.accenture.aaft.propertyreader.PropertyFileReader;
import com.accenture.aaft.report.ExtentTestManager;
import com.accenture.aaft.selenium.library.Click;
import com.accenture.aaft.selenium.library.Input;
import com.accenture.aaft.vo.ObjectMapVO;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Class is used to enter person record in store domeqa application
 *
 * @author vijay.venkatappa
 *
 */
public class InputProspect {

  /**
   * Method is used to enter person record
   *
   * @param driver - represents WebDriver
   * @param extentTest - represents ExtentTest
   * @param objecthashmap - represents LinkedHashMap<String, ObjectMapVO>
   * @return status
   */
  public String executeInputProspect(WebDriver driver, ExtentTest extentTest, LinkedHashMap<String, ObjectMapVO> objecthashmap) {

	CTLogger.writeToLog("Input", "executeInputProspect()", " method called");
	String firstWinHandle = null;
	ObjectMapVO objectMapVO = null;
	String status = "false";
	PropertyFileReader propertyFileReader = new PropertyFileReader();
	try {
	  Click click = new Click();
	  objectMapVO = objecthashmap.get("Input Person");
	  click.click(driver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), extentTest, objectMapVO.getControlName());

	  Thread.sleep(10);
	  Set<String> handles = driver.getWindowHandles();// To handle multiple windows
	  firstWinHandle = driver.getWindowHandle(); // To get your main window
	  handles.remove(firstWinHandle);
	  String winHandle = handles.iterator().next(); // To find popup window
	  String secondWinHandle = null;

	  Thread.sleep(10);

	  if (winHandle != firstWinHandle) {
		secondWinHandle = winHandle;
	  }
	  driver.switchTo().window(secondWinHandle); // To switch to popup window

	  Thread.sleep(10);
	  Input input = new Input();
	  objectMapVO = objecthashmap.get("GB NameInput");
	  input.enterText(driver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), "kumar", extentTest, objectMapVO.getControlName());

	  objectMapVO = objecthashmap.get("Go Image");
	  click.click(driver, objectMapVO.getObjectPath(), objectMapVO.getSelector(), extentTest, objectMapVO.getControlName());
	  WebDriverWait wait = new WebDriverWait(driver, 20);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Txn Complete')]")));

	  driver.close();
	  driver.switchTo().window(firstWinHandle);

	  WebElement frame = driver.findElement(By.xpath("//html/frameset/frame[2]"));
	  driver.switchTo().frame(frame);
	  Thread.sleep(10);
	  status = "true";
	  if (status.equals("true")) {
		extentTest.log(LogStatus.PASS, " InputProspect COMPONENT executed successfullly");
	  } else {
		extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(ExtentTestManager.captureScreen(driver, propertyFileReader.getValue("IMAGE_PATH") + "InputProspect COMPONENT")));
	  }

	} catch (Exception e) {
	  try {
		CTLogger.writeToLog("InputProspect", "executeInputProspect()", " exeption thrown");
		e.printStackTrace();
	  } finally {
		extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(ExtentTestManager.captureScreen(driver, propertyFileReader.getValue("IMAGE_PATH") + "InputProspect COMPONENT")));
		driver.quit();
	  }

	}

	return status;
  }

}
