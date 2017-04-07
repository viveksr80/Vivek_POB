package com.accenture.aaft.selenium.library;

import org.openqa.selenium.WebDriver;

/**
 * Class is used to close child browser window
 *
 * @author vijay.venkatappa
 *
 */
public class CloseChildWindow {

  /**
   * Method is used to close child browser window
   *
   * @param driver - represents WebDriver
   * @param maniWindowTitleToActive - represents main window title
   * @return status
   */
  public String closeChildWindow(WebDriver driver, String maniWindowTitleToActive) {
	System.out.println(" child window naame -- " + driver.getTitle() + " ------------> ");
	driver.close();
	System.out.println("firstWindowHandle - " + maniWindowTitleToActive + "------------->");
	driver.switchTo().window(maniWindowTitleToActive);
	return "true";
  }
}
