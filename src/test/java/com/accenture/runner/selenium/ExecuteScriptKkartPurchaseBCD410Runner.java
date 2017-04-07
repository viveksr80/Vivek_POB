package com.accenture.runner.selenium;


import org.junit.Test;
import com.accenture.runner.utility.ExecuteScriptRunner;


/**
* Class is used for selenium test
* 
* @author      Lalitha Yengaldas
* @version     1.0
*/


public class ExecuteScriptKkartPurchaseBCD410Runner extends ExecuteScriptRunner{
	public ExecuteScriptKkartPurchaseBCD410Runner() {
		super("konakart purchaseBCD410", "com.accenture.runner.selenium.ExecuteScriptKkartPurchaseBCD410Runner", "local");
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
