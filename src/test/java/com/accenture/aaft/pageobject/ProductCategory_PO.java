package com.accenture.aaft.pageobject;

import com.accenture.aaft.logger.CTLogger;
import com.accenture.aaft.report.ExtentTestManager;

import com.accenture.aaft.vo.ObjectMapVO;

import com.relevantcodes.extentreports.LogStatus;

/**
 * Class is used to select product from category in store domeqa application
 *
 * @author vijay.venkatappa
 *
 */
public class ProductCategory_PO extends Base_PO {

  /**
   * Method is used to select product from category
   *
   * @param objectVO - represents ObjectMapVO
   * @param productName - represents product name
   */
  public void selectProductFromCategory(ObjectMapVO objectVO, String productName) {
	try {
	  CTLogger.writeToLog("selectProductFromCategory");

	  mouseOverAndClick.mouseOverAndSelect(driver, objectVO.getObjectPath(), objectVO.getSelector(), productName, extentTest, objectVO.getControlName());
	  extentTest.log(LogStatus.PASS, "selectProductFromCategory - Selected " + productName);
	  wait.waitTime("5");
	} catch (Exception ex) {
	  try {
		ex.printStackTrace();
		CTLogger.writeToLog("ProductCategory_PO", "selectProductFromCategory", " exception occured");

	  } finally {

		String[] err = ex.getMessage().split("\n");
		String status = "Exception " + err[0].replaceAll("'", "") + " Occurred";
		extentTest.log(LogStatus.FAIL, "selectProductFromCategory " + status);
		extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(ExtentTestManager.captureScreen(driver, propertyFileReader.getValue("IMAGE_PATH") + "imac")));
		driver.close();
		driver.quit();
	  }
	}
  }

  /**
   * Method is used to select mobile from product category
   *
   * @param objectVO - represents ObjectMapVO
   * @param productName - represents product name
   * @param selection - represents item selection
   */
  public void selectProductFromCategoryMobile(ObjectMapVO objectVO, String productName, String selection) {
	try {
	  CTLogger.writeToLog("selectProductFromCategory");

	  select.selectFromList(driver, objectVO.getObjectPath(), objectVO.getSelector(), productName, selection, extentTest, objectVO.getControlName());
	  extentTest.log(LogStatus.PASS, "selectProductFromCategory - Selected " + productName);
	  wait.waitTime("5");
	} catch (Exception ex) {
	  try {
		ex.printStackTrace();
		CTLogger.writeToLog("ProductCategory_PO", "selectProductFromCategory", " exception occured");

	  } finally {

		String[] err = ex.getMessage().split("\n");
		String status = "Exception " + err[0].replaceAll("'", "") + " Occurred";
		extentTest.log(LogStatus.FAIL, "selectProductFromCategory " + status);
		extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(ExtentTestManager.captureScreen(driver, propertyFileReader.getValue("IMAGE_PATH") + "imac")));
		driver.close();
		driver.quit();
	  }
	}
  }

}
