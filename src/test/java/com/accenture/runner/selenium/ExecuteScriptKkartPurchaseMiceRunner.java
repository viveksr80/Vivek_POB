package com.accenture.runner.selenium;


import org.junit.Test;
import com.accenture.runner.utility.ExecuteScriptRunner;


/**
* Class is used for selenium test
* 
* @author      Lalitha Yengaldas
* @version     1.0
*/


public class ExecuteScriptKkartPurchaseMiceRunner extends ExecuteScriptRunner{
	public ExecuteScriptKkartPurchaseMiceRunner() {
		super("konakart purchaseMice", "com.accenture.runner.selenium.ExecuteScriptKkartPurchaseMiceRunner", "local");
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
