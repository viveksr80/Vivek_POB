package com.accenture.runner.selenium;


import org.junit.Test;
import com.accenture.runner.utility.ExecuteScriptRunner;


/**
* Class is used for selenium test
* 
* @author      Lalitha Yengaldas
* @version     1.0
*/


public class ExecuteScriptIPadRunner extends ExecuteScriptRunner{
	public ExecuteScriptIPadRunner() {
		super("Purchase IPad", "com.accenture.runner.selenium.ExecuteScriptIPadRunner", "local");
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
