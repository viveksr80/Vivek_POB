package com.accenture.aaft.pageobject;

import org.openqa.selenium.WebDriver;

import com.accenture.aaft.propertyreader.PropertyFileReader;
import com.accenture.aaft.selenium.component.healthcalculator.ExecuteApp;
import com.accenture.aaft.selenium.component.storedomeqa.BillingDetails;
import com.accenture.aaft.selenium.library.Click;
import com.accenture.aaft.selenium.library.Input;
import com.accenture.aaft.selenium.library.LaunchUrl;
import com.accenture.aaft.selenium.library.MouseOverAndClick;
import com.accenture.aaft.selenium.library.SelectFromList;
import com.accenture.aaft.selenium.library.WaitTime;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * Class is used as base class to get ExtentTest and WebDriver
 *
 * @author vijay.venkatappa
 *
 */
public class Base_PO {

  MouseOverAndClick	 mouseOverAndClick	= new MouseOverAndClick();
  WaitTime			 wait				= new WaitTime();
  Click				 click				= new Click();
  Input				 input				= new Input();
  SelectFromList	 select				= new SelectFromList();
  PropertyFileReader propertyFileReader	= new PropertyFileReader();
  BillingDetails	 billingDetails		= new BillingDetails();
  LaunchUrl			 launchUrl			= new LaunchUrl();
  ExecuteApp		 executeApp			= new ExecuteApp();

  ExtentTest extentTest;
  WebDriver	 driver;

  /**
   * Method is used to get ExtentTest
   *
   * @return ExtentTest
   */
  public ExtentTest getExtentTest() {
	return extentTest;
  }

  /**
   * Method is used to set ExtentTest
   *
   * @param extentTest - represents ExtentTest
   */
  public void setExtentTest(ExtentTest extentTest) {
	this.extentTest = extentTest;
  }

  /**
   * Method is used to get WebDriver
   *
   * @return WebDriver
   */
  public WebDriver getDriver() {
	return driver;
  }

  /**
   * Method is used to set WebDriver
   *
   * @param driver - represents WebDriver
   */
  public void setDriver(WebDriver driver) {
	this.driver = driver;
  }

}
