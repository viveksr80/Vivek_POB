package com.accenture.runner.selenium;


import org.junit.Test;
import com.accenture.runner.utility.ExecuteScriptRunner;


/**
* Class is used for selenium test
* 
* @author      Lalitha Yengaldas
* @version     1.0
*/


public class ExecuteScriptKkartSelectIpadManufacturerRunner extends ExecuteScriptRunner{
	public ExecuteScriptKkartSelectIpadManufacturerRunner() {
		super("konakart selectTabletsManufacturer", "com.accenture.runner.selenium.ExecuteScriptKkartSelectIpadManufacturerRunner", "local");
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
