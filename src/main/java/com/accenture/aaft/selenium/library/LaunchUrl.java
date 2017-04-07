package com.accenture.aaft.selenium.library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.accenture.aaft.logger.CTLogger;
import com.accenture.aaft.propertyreader.PropertyFileReader;
import com.accenture.aaft.report.ExtentTestManager;
import com.accenture.aaft.selenium.library.utility.WaitForPageLoad;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Class is used to launch the URL on browser
 *
 * @author vijay.venkatappa
 *
 */
public class LaunchUrl {

  /**
   * Method is used to launch the URL
   *
   * @param webDriver - represents WebDriver
   * @param inputValue - represents input value
   * @param extentTest - represents ExtentTest
   * @return status
   */
  public String launchUrl(WebDriver webDriver, String inputValue, ExtentTest extentTest) {

	String status = "false";
	PropertyFileReader propertyFileReader = new PropertyFileReader();

	try {

	  String webdriverString = webDriver.toString();
	  int waitTime = Integer.parseInt(propertyFileReader.getValue("MAX_TIME_TO_FIND_OBJECT"));
	  if(webdriverString.toLowerCase().contains("remotewebdriver")){
		  webDriver.get(inputValue);
	  }

	  else if (webdriverString.toLowerCase().contains("android") || webdriverString.toLowerCase().contains("ios") || webdriverString.toLowerCase().contains("iphone")) {
		webDriver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
		webDriver.get(inputValue);
		WaitForPageLoad waitForPageLoad = new WaitForPageLoad();
		waitForPageLoad.waitForPageLoaded(webDriver);
	  } else {
		webDriver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
		Long w = (Long) ((JavascriptExecutor) webDriver).executeScript("return window.screen.availWidth;");
		Long h = (Long) ((JavascriptExecutor) webDriver).executeScript("return window.screen.availHeight;");
		webDriver.manage().window().setSize(new Dimension(w.intValue(), h.intValue()));
		webDriver.get(inputValue);
		WaitForPageLoad waitForPageLoad = new WaitForPageLoad();
		waitForPageLoad.waitForPageLoaded(webDriver);
	  }

	  extentTest.log(LogStatus.PASS, "URL: " + inputValue + " launched");

	  status = "true";

	} catch (Exception ex) {
	  try {

		ex.printStackTrace();
		if (ex.getMessage().toString().contains("Modal dialog present")) {

		  CTLogger.writeToLog("LaunchUrl", "launchUrl() ", " not able to launch.");
		  extentTest.log(LogStatus.INFO, "URL not able to launch the URL: " + inputValue);
		  status = "URL opened but popup exists";

		}
	  } finally {

		ex.printStackTrace();
		String err[] = ex.getMessage().split("\n");
		CTLogger.writeToLog("LaunchUrl", "launchUrl()", "URL not able to launch the URL: " + inputValue);
		status = "Exception " + err[0].replaceAll("'", "") + " Occurred";
		extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(ExtentTestManager.captureScreen(webDriver, propertyFileReader.getValue("IMAGE_PATH") + "open url")));
		ExtentTestManager.setThreadStatus("f");
		webDriver.quit();

	  }

	}
	return status;

  }

}
