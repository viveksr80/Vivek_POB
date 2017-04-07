package com.accenture.runner.selenium;


import org.junit.Test;
import com.accenture.runner.utility.ExecuteScriptRunner;


/**
* Class is used for selenium test
* 
* @author      Lalitha Yengaldas
* @version     1.0
*/


public class ExecuteScriptKkartSelectLawnMoversManufacturerRunner extends ExecuteScriptRunner{
	public ExecuteScriptKkartSelectLawnMoversManufacturerRunner() {
		super("konakart SelectLawnMoversManufacturer", "com.accenture.runner.selenium.ExecuteScriptKkartSelectLawnMoversManufacturerRunner", "local");
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
