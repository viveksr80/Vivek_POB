package com.accenture.aaft.pageobject;

import com.accenture.aaft.logger.CTLogger;
import com.accenture.aaft.report.ExtentTestManager;

import com.accenture.aaft.vo.ObjectMapVO;

import com.relevantcodes.extentreports.LogStatus;

/**
 * Class is used to add to cart and checkout the item from store domeqa application
 *
 * @author vijay.venkatappa
 *
 */
public class AddToCartNCheckOut_PO extends Base_PO {

  /**
   * Method is used to add to cart and checkout the item
   *
   * @param objectVO - represents ObjectMapVO
   */
  public void addToCartNCheckOut(ObjectMapVO objectVO) {
	try {
	  CTLogger.writeToLog("addToCartNCheckOut");
	  wait.waitTime("5");
	  click.click(driver, objectVO.getObjectPath(), objectVO.getSelector(), extentTest, objectVO.getControlName());
	  extentTest.log(LogStatus.PASS, "addToCartNCheckOut - Clicked on " + objectVO.getControlName());
	  wait.waitTime("5");
	} catch (Exception ex) {
	  try {
		ex.printStackTrace();
		CTLogger.writeToLog("AddToCartNCheckOut_PO", "addToCartNCheckOut", " exception occured");

	  } finally {

		String[] err = ex.getMessage().split("\n");
		String status = "Exception " + err[0].replaceAll("'", "") + " Occurred";
		extentTest.log(LogStatus.FAIL, "addToCartNCheckOut " + status);
		extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(ExtentTestManager.captureScreen(driver, propertyFileReader.getValue("IMAGE_PATH") + "imac")));
		driver.close();
		driver.quit();
	  }
	}
  }

}
