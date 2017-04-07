package com.accenture.aaft.vo;

/**
 * Class is used to store object map values
 *
 * @author vijay.venkatappa
 *
 */
public class ObjectMapVO {

  String controlName;
  String objectPath;
  String selector;

  /**
   * Method is used to control name
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
   * Method is used to object path
   *
   * @return object path
   */
  public String getObjectPath() {
	return objectPath;
  }

  /**
   * Method is used to object path
   *
   * @param objectPath - represents object path
   */
  public void setObjectPath(String objectPath) {
	this.objectPath = objectPath;
  }

  /**
   * Method is used to get selector type
   *
   * @return selector type
   */
  public String getSelector() {
	return selector;
  }

  /**
   * Method is used to set selector type
   *
   * @param selector - represents selector type
   */
  public void setSelector(String selector) {
	this.selector = selector;
  }

}
