package com.accenture.runner.platform;

import java.util.LinkedList;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.accenture.aaft.logger.CTLogger;
import com.accenture.aaft.propertyreader.PropertyFileReader;
import com.accenture.aaft.propertyreader.SeleniumConfigXmlReader;
import com.accenture.aaft.report.ExtentManager;
import com.accenture.aaft.report.ExtentTestManager;
import com.accenture.aaft.selenium.driver.ExecuteScript;
import com.accenture.aaft.selenium.library.utility.RestCall;
import com.relevantcodes.extentreports.ExtentReports;
import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.junit.SauceOnDemandTestWatcher;

/**
 * Class is used for selenium test
 *
 * @author vijay.venkatappa
 *
 */

public class ExecuteScriptKkartPurchaseElectronicsSauceLabRunner implements SauceOnDemandSessionIdProvider{
	
	PropertyFileReader propertyFileReader = new PropertyFileReader();

	String userName = propertyFileReader.getValue("SAUCELABS_USERNAME");
	String accessKey = propertyFileReader.getValue("SAUCELABS_ACCESSKEY");
	
    /**
     * Constructs a {@link SauceOnDemandAuthentication} instance using the supplied user name/access key.  To use the authentication
     * supplied by environment variables or from an external file, use the no-arg {@link SauceOnDemandAuthentication} constructor.
     */
    public SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication(userName, accessKey);
    
    /**
     * JUnit Rule which will mark the Sauce Job as passed/failed when the test succeeds or fails.
     */
    @Rule
    public SauceOnDemandTestWatcher resultReportingTestWatcher = new SauceOnDemandTestWatcher(this, authentication);
 
    /**
     * Represents the browser to be used as part of the test run.
     */
    private static String browser;
    /**
     * Represents the operating system to be used as part of the test run.
     */
    private static String os;
    /**
     * Represents the version of the browser to be used as part of the test run.
     */
    private static String version;
	/**
	 * 
	 * The {@link WebDriver} instance which is used to perform browser
	 * interactions with.
	 * 
	 */
	
	private String sessionId;

	/**
	 * Represents the executionType like local/saucelabs
	 */
	public String executionType = "saucelabs";

	/**
	 * Represents the ExtentReports
	 */
	 public ExtentReports extent;
	/**
	 * Represents the scriptName
	 */
	  public String scriptName = "konakart purchaseElectronicsSauceLab";
	  
	  
	  /**
	     * Constructs a new {@link RemoteWebDriver} instance which is configured to use the capabilities defined by the {@link #browser},
	     * {@link #version} and {@link #os} instance variables, and which is configured to run against ondemand.saucelabs.com, using
	     * the username and access key populated by the {@link #authentication} instance.
	     *
	     * @throws Exception if an error occurs during the creation of the {@link RemoteWebDriver} instance.
	     */
	    @Before
	    public void setUp() throws Exception {

	    	SeleniumConfigXmlReader seleniunConfigXmlReader = new SeleniumConfigXmlReader();	
			LinkedList<String[]> listArray= seleniunConfigXmlReader.getBrowserList(executionType);
			
			Random random = new Random();
			String browserConfig[] = listArray.get(random.nextInt(listArray.size()));
			os = browserConfig[0];
			version = browserConfig[1];
			browser = browserConfig[2];
			System.out.println("OS - "+browserConfig[0] + "--version - "+browserConfig[1] + "..browser - "+browserConfig[2]); 
			
	    	ExtentManager.getExtentManager();
	    	
	    	ExtentTestManager.startTest("Platform Test - SauceLab <b>"
	    			+os+"-"+browser+"-"+version+"</b> : " + scriptName, "Online Store - Konakart PurchaseElectronicsSauceLab", "com.accenture.runner.platform.ExecuteScriptKkartPurchaseElectronicsSauceLabRunner");

	}

	/**
	 * Method is used to execute script
	 *
	 */
	@Test
	public void test() {
		CTLogger.writeToLog(scriptName+" : execution started");
		ExecuteScript executeScript = new ExecuteScript();
		String sessionId = executeScript.executeScript(scriptName, os, version, browser, executionType );
		this.sessionId = sessionId;
	}

	/**
	 * Closes the {@link WebDriver} session.
	 *
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {

		ExtentManager.getReporter().endTest(ExtentTestManager.getTest());
		ExtentManager.getReporter().flush();
		
		CTLogger.writeToLog(scriptName+" :  execution completed");
		
		String status = ExtentTestManager.getThreadStatus();
		if (status == null || status.trim().equals("")) {
			status = "p";
		}
		RestCall rc = new RestCall();
		rc.simpleGet(ExtentTestManager.getTestCaseNumber(), status);
	}

	/**
	 *
	 * @return the value of the Sauce Job id.
	 */
	@Override
	public String getSessionId() {
		return sessionId;
	}

}
