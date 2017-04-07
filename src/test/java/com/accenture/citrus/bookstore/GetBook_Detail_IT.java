/*
 * Copyright 2006-2012 the original author or authors.
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

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.oxm.Marshaller;
//import org.testng.Assert;
import org.testng.annotations.Test;

import com.accenture.aaft.report.ExtentManager;
import com.accenture.aaft.report.ExtentTestManager;
import com.accenture.citrus.bookstore.model.Book;
import com.accenture.citrus.bookstore.model.GetBookDetailsRequestMessage;
import com.accenture.citrus.bookstore.model.GetBookDetailsResponseMessage;
import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.dsl.testng.TestNGCitrusTestDesigner;
import com.consol.citrus.validation.xml.XmlMarshallingValidationCallback;
import com.consol.citrus.ws.client.WebServiceClient;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import com.accenture.aaft.selenium.library.utility.RestCall;

@Test
public class GetBook_Detail_IT extends TestNGCitrusTestDesigner {

	static ExtentReports extent;
	static String scriptName = "GetBook";
	static ExtentTest extentTest;
	
    @Autowired
    @Qualifier("bookStoreClient")
    private WebServiceClient bookStoreClient;
    
    @Autowired
    private Marshaller marshaller;

    AtomicInteger invocationCount = new AtomicInteger(0);

    TestContext context = new TestContext();
    
    @Test(invocationCount=1,threadPoolSize=1)
    @CitrusTest(name = "getBookDetails")
    public void getBookDetailsTest() {
    	final String isbn = "981-9467132237";
    	System.out.println("in getBookDetailsTest");
        //get message here
//        extentTest = ExtentTestManager.getTest();
        extent = ExtentManager.getExtentManager();
        if (null == extent) {
        	extent = ExtentManager.getReporter();
        }
		
		ExtentTestManager.startTest("API Test : " + scriptName + "-" +isbn, "Get Book ", "api_test");
        extentTest = ExtentTestManager.getTest();

//        System.out.println("in extentTest - "+extentTest);
		extentTest
				.log(LogStatus.INFO, "Sending getBook SOAP message for ISBN -"+isbn);
		
//		send(bookStoreClient)
//        .payload(new ClassPathResource("com/accenture/citrus/bookstore/TestRequest.xml"));
		
		//send getBook request
		//create message
		System.out.println("isbn - "+isbn);
		System.out.println("bookStoreClient - "+bookStoreClient);
		
		//send getBook request
		try {
			
			send(bookStoreClient)
	           .payload(createGetBookDetailsRequestMessage(isbn), marshaller)
	            .header("citrus_soap_action", "getBookDetails");
			extentTest
			.log(LogStatus.INFO, "Sent getBook SOAP Message for ISBN -"+isbn );
			
      //validate receive getBook request
         receive(bookStoreClient)
              .validationCallback(new XmlMarshallingValidationCallback<GetBookDetailsResponseMessage>() {
              	@Override
                  public void validate(GetBookDetailsResponseMessage response, Map<String, Object> headers, TestContext context) {
              		System.out.println("in validate");
              		Book book = response.getBook();
              		System.out.println("Book - "+book);
              		extentTest
              		.log(LogStatus.INFO, "Received Book details");
              		
              		 extentTest.log(LogStatus.INFO,  "HTML","Book Title - <b>" + book.getTitle()+"</b>");
              			extentTest.log(LogStatus.INFO,  "HTML","Book Author - <b>" + book.getAuthor()+"</b>");
              			extentTest.log(LogStatus.INFO,  "HTML","Book ISBN - <b>" + book.getIsbn()+"</b>");
//              			extentTest.log(LogStatus.INFO,  "HTML","Book Year - <b>" + book.getYear()+"</b>");
              			extentTest.log(LogStatus.INFO,  "HTML","Book Registration Date - <b>" +book.getRegistrationDate().getTime()+"</b>");
                  }
              });
        
		} catch (Exception ex) {
//			ex.getStackTrace().
			String err[]=ex.getMessage().split("\n"); 
			System.err.println(err[0]);
			extentTest
      		.log(LogStatus.INFO, "Got ConcurrentModification exception");
			extent.endTest(extentTest);
		}
        System.out.println("after getBookDetails sent");
        
		 System.out.println("AFTER GETTING BOOK");
        extent.endTest(extentTest);
		
		String status = ExtentTestManager.getThreadStatus();
		if (status == null || status.trim().equals("")) {
			status = "p";
		}
		RestCall rc = new RestCall();
		rc.simpleGet(ExtentTestManager.getTestCaseNumber(), status);
    }
    private GetBookDetailsRequestMessage createGetBookDetailsRequestMessage(String isbn) {
    	GetBookDetailsRequestMessage requestMessage = new GetBookDetailsRequestMessage();
        requestMessage.setIsbn(isbn);
        return requestMessage;
    }
}
