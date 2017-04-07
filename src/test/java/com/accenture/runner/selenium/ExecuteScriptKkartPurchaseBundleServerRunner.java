package com.accenture.runner.selenium;


import org.junit.Test;
import com.accenture.runner.utility.ExecuteScriptRunner;


/**
* Class is used for selenium test
* 
* @author      Lalitha Yengaldas
* @version     1.0
*/


public class ExecuteScriptKkartPurchaseBundleServerRunner extends ExecuteScriptRunner{
	public ExecuteScriptKkartPurchaseBundleServerRunner() {
		super("konakart purchaseBundleServer", "com.accenture.runner.selenium.ExecuteScriptKkartPurchaseBundleServerRunner", "local");
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
