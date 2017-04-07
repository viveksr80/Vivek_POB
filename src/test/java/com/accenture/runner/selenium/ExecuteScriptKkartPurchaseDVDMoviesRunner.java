package com.accenture.runner.selenium;


import org.junit.Test;
import com.accenture.runner.utility.ExecuteScriptRunner;


/**
* Class is used for selenium test
* 
* @author      Lalitha Yengaldas
* @version     1.0
*/


public class ExecuteScriptKkartPurchaseDVDMoviesRunner extends ExecuteScriptRunner{
	public ExecuteScriptKkartPurchaseDVDMoviesRunner() {
		super("konakart purchaseDVDMovies", "com.accenture.runner.selenium.ExecuteScriptKkartPurchaseDVDMoviesRunner", "local");
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
