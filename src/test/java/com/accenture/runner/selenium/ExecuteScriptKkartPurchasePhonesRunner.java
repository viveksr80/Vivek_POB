package com.accenture.runner.selenium;


import org.junit.Test;
import com.accenture.runner.utility.ExecuteScriptRunner;


/**
* Class is used for selenium test
* 
* @author      Lalitha Yengaldas
* @version     1.0
*/


public class ExecuteScriptKkartPurchasePhonesRunner extends ExecuteScriptRunner{
	public ExecuteScriptKkartPurchasePhonesRunner() {
		super("konakart purchasephones", "com.accenture.runner.selenium.ExecuteScriptKkartPurchasePhonesRunner", "local");
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
