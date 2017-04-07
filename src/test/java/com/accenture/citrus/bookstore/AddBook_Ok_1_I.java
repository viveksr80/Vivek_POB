/*
 * Copyright 2006-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.accenture.citrus.bookstore;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.accenture.aaft.report.ExtentManager;
import com.accenture.aaft.report.ExtentTestManager;
import com.consol.citrus.annotations.CitrusXmlTest;
import com.consol.citrus.testng.AbstractTestNGCitrusTest;
//import com.consol.citrus.annotations.CitrusXmlTest;
//import com.consol.citrus.testng.AbstractTestNGCitrusTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import com.accenture.aaft.selenium.library.utility.RestCall;

@Test
public class AddBook_Ok_1_I extends AbstractTestNGCitrusTest {
    
	static ExtentReports extent;
	static String scriptName = "AddBook_Ok_1_IT";
	static ExtentTest extentTest;
	
//   @Test(invocationCount=1000,threadPoolSize=25)
	@CitrusXmlTest(name = "AddBook_Ok_1_IT")
    public void addBook_OK_1_Test() {
    }
    

/*@Test(invocationCount=1000,threadPoolSize=25)
public void simpleSOAP_OK_1_Test(ITestContext testContext){
	
	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>");
	//executeTest(testContext);
} 
    */
    
    @BeforeClass
	public static void runOnceBeforeClass() {
    	System.out.println("@BeforeClass - AddBook_Ok_1_IT extent - " + extent);
		extent = ExtentManager.getExtentManager();
		ExtentTestManager.startTest("API Test : " + scriptName, "Add a Book AbstractTestNGCitrusTest", "api_test");
		
	}

	@AfterClass
	public static void runOnceAfterClass() {
		ExtentManager.getReporter().endTest(ExtentTestManager.getTest());
		ExtentManager.getReporter().flush();
		
		String status = ExtentTestManager.getThreadStatus();
		if (status == null || status.trim().equals("")) {
			status = "p";
		}
		RestCall rc = new RestCall();
		rc.simpleGet(ExtentTestManager.getTestCaseNumber(), status);
	}
	



	
    
}

