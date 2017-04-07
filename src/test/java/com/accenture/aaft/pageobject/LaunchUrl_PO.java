package com.accenture.aaft.pageobject;

import com.accenture.aaft.logger.CTLogger;
import com.accenture.aaft.report.ExtentTestManager;

import com.relevantcodes.extentreports.LogStatus;

/**
 * Class is used to launch the URL
 *
 * @author vijay.venkatappa
 *
 */
public class LaunchUrl_PO extends Base_PO {

  /**
   * Method is used to launch the URL
   *
   * @param url - represents URL name
   */
  public void launchUrl(String url) {
	try {
	  launchUrl.launchUrl(driver, url, extentTest);
	  wait.waitTime("10");

	} catch (Exception ex) {
	  try {
		ex.printStackTrace();
		CTLogger.writeToLog("LaunchUrl_PO", "launchUrl()", " exception occured");

	  } finally {

		String[] err = ex.getMessage().split("\n");
		String status = "Exception " + err[0].replaceAll("'", "") + " Occurred";
		extentTest.log(LogStatus.FAIL, "launchUrl " + status);
		extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(ExtentTestManager.captureScreen(driver, propertyFileReader.getValue("IMAGE_PATH") + "imac")));
		driver.close();
		driver.quit();
	  }
	}
  }

}
