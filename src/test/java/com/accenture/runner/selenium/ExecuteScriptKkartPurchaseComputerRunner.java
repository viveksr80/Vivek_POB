package com.accenture.runner.selenium;


import org.junit.Test;
import com.accenture.runner.utility.ExecuteScriptRunner;


/**
* Class is used for selenium test
* 
* @author      Lalitha Yengaldas
* @version     1.0
*/


public class ExecuteScriptKkartPurchaseComputerRunner extends ExecuteScriptRunner{
	public ExecuteScriptKkartPurchaseComputerRunner() {
		super("konakart purchaseClockInHomeAndGarden", "com.accenture.runner.selenium.ExecuteScriptKkartPurchaseComputerRunner", "local");
	}
	/**
	 * Method is used to execute script
	 *
	 */
	@Test
	public void test() {
		executeTestWithoutBrowser();
	}
}
