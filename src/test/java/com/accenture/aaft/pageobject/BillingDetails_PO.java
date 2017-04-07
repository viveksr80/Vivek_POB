package com.accenture.aaft.pageobject;

import java.util.LinkedHashMap;
import java.util.List;

import com.accenture.aaft.logger.CTLogger;
import com.accenture.aaft.report.ExtentTestManager;

import com.accenture.aaft.vo.ExcelTestDataVO;
import com.accenture.aaft.vo.ObjectMapVO;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Class is used to add billing details of store domeqa application
 *
 * @author vijay.venkatappa
 *
 */
public class BillingDetails_PO extends Base_PO {

  /**
   * Method is used to add billing details
   *
   * @param obectMap - represents LinkedHashMap<String, ObjectMapVO>
   * @param voList - represents List<ExcelTestDataVO>
   */
  public void billingDetails(LinkedHashMap<String, ObjectMapVO> obectMap, List<ExcelTestDataVO> voList) {
	try {
	  billingDetails.executeBillingDetails(driver, extentTest, obectMap, voList);
	  extentTest.log(LogStatus.PASS, "Provide_billing_details_and_shipping_address_for_iMac_checkout - Clicked on Purchase");

	} catch (Exception ex) {
	  try {
		ex.printStackTrace();
		CTLogger.writeToLog("BillingDetails_PO", "billingDetails", " exception occured");

	  } finally {

		String[] err = ex.getMessage().split("\n");
		String status = "Exception " + err[0].replaceAll("'", "") + " Occurred";
		extentTest.log(LogStatus.FAIL, "billingDetails " + status);
		extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(ExtentTestManager.captureScreen(driver, propertyFileReader.getValue("IMAGE_PATH") + "imac")));
		driver.close();
		driver.quit();
	  }
	}
  }

}
