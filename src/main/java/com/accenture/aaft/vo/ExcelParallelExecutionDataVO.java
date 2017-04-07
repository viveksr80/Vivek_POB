package com.accenture.aaft.vo;

/**
 * Class is used to store parallel execution script details
 *
 * @author vijay.venkatappa
 *
 */
public class ExcelParallelExecutionDataVO {

  String slNo;
  String scriptName;
  String hostAndPortNo;
  String browser;
  String batchNo;

  /**
   * Method is used to get serial no
   *
   * @return - represents serial no
   */
  public String getSlNo() {
	return slNo;
  }

  /**
   * Method is used to set serial no
   *
   * @param slNo - represents serial no
   */
  public void setSlNo(String slNo) {
	this.slNo = slNo;
  }

  /**
   * Method is used to get script name
   *
   * @return script name
   */
  public String getScriptName() {
	return scriptName;
  }

  /**
   * Method is used to set script name
   *
   * @param scriptName - represents script name
   */
  public void setScriptName(String scriptName) {
	this.scriptName = scriptName;
  }

  /**
   * Method is used to get host and port no
   *
   * @return host and port no
   */
  public String getHostAndPortNo() {
	return hostAndPortNo;
  }

  /**
   * Method is used to set host and port no
   *
   * @param hostAndPortNo - represents host and port no
   */
  public void setHostAndPortNo(String hostAndPortNo) {
	this.hostAndPortNo = hostAndPortNo;
  }

  /**
   * Method is used to get browser
   *
   * @return browser
   */
  public String getBrowser() {
	return browser;
  }

  /**
   * Method is used to set browser
   *
   * @param browser - represents browser
   */
  public void setBrowser(String browser) {
	this.browser = browser;
  }

  /**
   * Method is used to get batch no
   *
   * @return batch no
   */
  public String getBatchNo() {
	return batchNo;
  }

  /**
   * Method is used to set batch no
   *
   * @param batchNo - represents batch no
   */
  public void setBatchNo(String batchNo) {
	this.batchNo = batchNo;
  }

}
