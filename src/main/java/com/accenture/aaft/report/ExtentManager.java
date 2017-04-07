package com.accenture.aaft.report;

import com.relevantcodes.extentreports.ExtentReports;
import java.io.File;

/**
 * Class is used to generate the Extent reports
 *
 * @author vijay.venkatappa
 *
 */
@SuppressWarnings({ "static-access" })
public class ExtentManager {

  private static ExtentReports extent;
  private static ExtentManager extentManager;


  public final static String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") +"report"+ System.getProperty("file.separator")+"AAFT Execution Report_" + DateUtil.now("d MMM yyyy H.mm.ss.SSS") + ".html"; 
  
  /**
   * Method is used to get report
   *
   * @return ExtentReports
   */
  public synchronized static ExtentReports getReporter() {

	if (extentManager.extent == null) {
	  extent = new ExtentReports(filePath, false);
	  extent.loadConfig(new File(System.getProperty("user.dir")+ System.getProperty("file.separator") + "extent-config.xml"));
	}

	return extent;
  }

  /**
   * Method is used to ExtentManager
   *
   * @return ExtentReports
   */
  public static ExtentReports getExtentManager() {
	if (null == extentManager) {
	  extentManager = new ExtentManager();
	  extent = extentManager.getReporter();
	}
	return extent;
  }
}
