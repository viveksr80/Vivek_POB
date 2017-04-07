package com.accenture.aaft.vo;

/**
 * Class is used to store test script data
 *
 * @author vijay.venkatappa
 *
 */
public class ExcelTestScriptVO {
  String testStepNo;
  String testStepDetails;
  String mainWindow;
  String screen;
  String keyword;
  String controlName;
  String param1;
  String param2;
  String param3;
  String condition;
  String skip;

  /**
   * Method is used to get test step no
   *
   * @return test step no
   */
  public String getTestStepNo() {
	return testStepNo;
  }

  /**
   * Method is used to set test step no
   *
   * @param testStepNo - represents test step no
   */
  public void setTestStepNo(String testStepNo) {
	this.testStepNo = testStepNo;
  }

  /**
   * Method is used to get test step details
   *
   * @return test step details
   */
  public String getTestStepDetails() {
	return testStepDetails;
  }

  /**
   * Method is used to set test step details
   *
   * @param testStepDetails - represents test step details
   */
  public void setTestStepDetails(String testStepDetails) {
	this.testStepDetails = testStepDetails;
  }

  /**
   * Method is used to get main window
   *
   * @return main window
   */
  public String getMainWindow() {
	return mainWindow;
  }

  /**
   * Method is used to set main window
   *
   * @param mainWindow - represents main window
   */
  public void setMainWindow(String mainWindow) {
	this.mainWindow = mainWindow;
  }

  /**
   * Method is used to get screen name
   *
   * @return screen name
   */
  public String getScreen() {
	return screen;
  }

  /**
   * Method is used to set screen name
   *
   * @param screen - represents screen name
   */
  public void setScreen(String screen) {
	this.screen = screen;
  }

  /**
   * Method is used to get keyword name
   *
   * @return keyword name
   */
  public String getKeyword() {
	return keyword;
  }

  /**
   * Method is used to set keyword name
   *
   * @param keyword - represents keyword name
   */
  public void setKeyword(String keyword) {
	this.keyword = keyword;
  }

  /**
   * Method is used to get control name
   *
   * @return control name
   */
  public String getControlName() {
	return controlName;
  }

  /**
   * Method is used to set control name
   *
   * @param controlName - represents control name
   */
  public void setControlName(String controlName) {
	this.controlName = controlName;
  }

  /**
   * Method is used to get placeholder value
   *
   * @return placeholder value
   */
  public String getParam1() {
	return param1;
  }

  /**
   * Method is used to set placeholder value
   *
   * @param param1 - represents placeholder value
   */
  public void setParam1(String param1) {
	this.param1 = param1;
  }

  /**
   * Method is used to get placeholder value
   *
   * @return placeholder value
   */
  public String getParam2() {
	return param2;
  }

  /**
   * Method is used to set placeholder
   *
   * @param param2 - represents placeholder value
   */
  public void setParam2(String param2) {
	this.param2 = param2;
  }

  /**
   * Method is used to get placeholder value
   *
   * @return placeholder value
   */
  public String getParam3() {
	return param3;
  }

  /**
   * Method is used to set placeholder value
   *
   * @param param3 - represents placeholder
   */
  public void setParam3(String param3) {
	this.param3 = param3;
  }

  /**
   * Method is used to get condition value
   *
   * @return condition value
   */
  public String getCondition() {
	return condition;
  }

  /**
   * Method is used to
   *
   * @param condition - represents condition value
   */
  public void setCondition(String condition) {
	this.condition = condition;
  }

  /**
   * Method is used to get skip info
   *
   * @return skip info
   */
  public String getSkip() {
	return skip;
  }

  /**
   * Method is used to set skip info
   *
   * @param skip - represents skip info
   */
  public void setSkip(String skip) {
	this.skip = skip;
  }

}
