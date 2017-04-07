package com.accenture.runner.selenium;


import org.junit.Test;
import com.accenture.runner.utility.ExecuteScriptRunner;


/**
* Class is used for selenium test
* 
* @author      Lalitha Yengaldas
* @version     1.0
*/


public class ExecuteScriptKkartPurchaseHomeAndGardenRunner extends ExecuteScriptRunner{
	public ExecuteScriptKkartPurchaseHomeAndGardenRunner() {
		super("konakart purchaseHomeAndGarden", "com.accenture.runner.selenium.ExecuteScriptKkartPurchaseHomeAndGardenRunner", "local");
	}
	/**
	 * Method is used to execute script
	 *
	 */
	@Test
	public void test() {
		executeTest();
	}
}
