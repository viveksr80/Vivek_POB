package com.accenture.aaft.selenium.driver;

import org.openqa.selenium.WebDriver;

import com.accenture.aaft.selenium.library.Click;
import com.accenture.aaft.selenium.library.ClickCP;
import com.accenture.aaft.selenium.library.ClickLink;
import com.accenture.aaft.selenium.library.Input;
import com.accenture.aaft.selenium.library.InputCP;
import com.accenture.aaft.selenium.library.LaunchUrl;
import com.accenture.aaft.selenium.library.MouseOverAndClick;
import com.accenture.aaft.selenium.library.SelectByIndex;
import com.accenture.aaft.selenium.library.SelectFrame;
import com.accenture.aaft.selenium.library.SelectFromList;
import com.accenture.aaft.selenium.library.SelectWindow;
import com.accenture.aaft.selenium.library.VerifyText;
import com.accenture.aaft.selenium.library.WaitTime;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * Class is used to execute keyword based action
 *
 * @author vijay.venkatappa
 *
 */
public class KeywordExecutor {

  WebDriver webDriver;

  /**
   * Method is used to execute keyword based action
   *
   * @param webDriver - represents WebDriver
   * @param keyword - represents keyword name
   * @param controlName - represents control name
   * @param param1 - represents placeholder name
   * @param param2 - represents placeholder name
   * @param param3 - represents placeholder name
   * @param condition - represents condition value
   * @param testStepNo - represents test step number
   * @param testStepDetails - represents test step details
   * @param screen - represents screen name
   * @param mainWindow - represents main window name
   * @param inputValue - represents input value
   * @param extentTest - represents ExtentTest
   * @param objectName - represents object name
   * @param selector - represents selector type
   * @return status
   */
  public String executeKeyword(WebDriver webDriver, String keyword, String controlName, String param1, String param2, String param3, String condition, String testStepNo, String testStepDetails,
      String screen, String mainWindow, String inputValue, ExtentTest extentTest, String objectName, String selector) {

	String result = "false";

	if (keyword.equalsIgnoreCase("LAUNCH")) {

	  LaunchUrl launchUrl = new LaunchUrl();
	  result = launchUrl.launchUrl(webDriver, inputValue, extentTest);

	  System.out.println(result + " LAUNCH");
	}

	else if (keyword.equalsIgnoreCase("LAUNCHAPP")) {
	  result = "true";
	  System.out.println(result + " LAUNCHAPP");
	}

	else if (keyword.equalsIgnoreCase("INPUT")) {

	  Input input = new Input();
	  result = input.enterText(webDriver, objectName, selector, inputValue, extentTest, controlName);

	  System.out.println(result + " INPUT");
	}
	else if (keyword.equalsIgnoreCase("INPUTCP")) {

		  InputCP input = new InputCP();
		  result = input.enterText(webDriver, objectName, selector, inputValue, extentTest, controlName);

		  System.out.println(result + " INPUTCP");
	}
	else if (keyword.equalsIgnoreCase("CLICK")) {

	  Click click = new Click();
	  result = click.click(webDriver, objectName, selector, extentTest, controlName);
	  System.out.println(result + " CLICK");
	}
	else if (keyword.equalsIgnoreCase("CLICKCP")) {

		  ClickCP click = new ClickCP();
		  result = click.click(webDriver, objectName, selector, extentTest, controlName);
		  System.out.println(result + " CLICKCP");
	}
	else if (keyword.equalsIgnoreCase("WAIT")) {

	  WaitTime waitTime = new WaitTime();
	  result = waitTime.waitTime(inputValue, extentTest, controlName);
	  System.out.println(result + " WAIT");
	}

	else if (keyword.equalsIgnoreCase("CLICKLINK")) {

	  ClickLink clickLink = new ClickLink();
	  result = clickLink.clickLink(webDriver, objectName, selector, extentTest, controlName);
	  System.out.println(result + " CLICKLINK");
	}

	else if (keyword.equalsIgnoreCase("SELECTFRAME")) {

	  SelectFrame selectFrame = new SelectFrame();
	  result = selectFrame.selectFrame(webDriver, objectName, selector, extentTest, controlName);
	  System.out.println(result + " SELECTFRAME");
	} else if (keyword.equalsIgnoreCase("SELECTWINDOW")) {

	  SelectWindow selectWindow = new SelectWindow();
	  result = selectWindow.selectWindow(webDriver, inputValue, extentTest, controlName);
	  System.out.println(result + " SELECTWINDOW");
	} else if (keyword.equalsIgnoreCase("MOUSEOVER")) {

	  MouseOverAndClick mouseOver = new MouseOverAndClick();
	  result = mouseOver.mouseOverAndSelect(webDriver, objectName, selector, inputValue, extentTest, controlName);
	  System.out.println(result + " MOUSEOVER");
	} else if (keyword.equalsIgnoreCase("VERIFYTEXT")) {
		
	  VerifyText verifyText = new VerifyText();
	  result = verifyText.verifyText(webDriver, objectName, selector, inputValue, extentTest, controlName);
	  System.out.println(result + " VERIFYTEXT");
	} else if (keyword.equalsIgnoreCase("SELECTFROMLIST")) {
		
	  SelectFromList selectFromList = new SelectFromList();
	  result = selectFromList.selectFromList(webDriver, objectName, selector, inputValue, "selection", extentTest, controlName);
	  System.out.println(result + " SELECTFROMLIST");
	} else if (keyword.equalsIgnoreCase("SELECTBYINDEX")) {
	
	  SelectByIndex selectByIndex = new SelectByIndex();
	  result = selectByIndex.selectByIndex(webDriver, objectName, selector, inputValue, extentTest, controlName);
	  System.out.println(result + " SELECTBYINDEX");
	}
	return result;
  }

}
