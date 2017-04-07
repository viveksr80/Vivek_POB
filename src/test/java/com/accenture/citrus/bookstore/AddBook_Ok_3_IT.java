package com.accenture.citrus.bookstore;

import java.util.Calendar;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.oxm.Marshaller;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.accenture.aaft.report.ExtentManager;
import com.accenture.aaft.report.ExtentTestManager;
import com.accenture.citrus.bookstore.model.AddBookRequestMessage;
import com.accenture.citrus.bookstore.model.AddBookResponseMessage;
import com.accenture.citrus.bookstore.model.Book;
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
public class AddBook_Ok_3_IT extends TestNGCitrusTestDesigner {

	static ExtentReports extent;
	static String scriptName = "AddBook_Ok_3_IT";
	static ExtentTest extentTest;
	
    @Autowired
    @Qualifier("bookStoreClient")
    private WebServiceClient bookStoreClient;
    
    @Autowired
    private Marshaller marshaller;

// @Test(invocationCount=10,threadPoolSize=25)
    @CitrusTest(name = "addBookNewTest")
    public void addBookTest() {
//    	System.out.println("in addBookNewTest ++++++++ ");
        final String isbn = "981-9467132237";
        //get message here
        extentTest = ExtentTestManager.getTest();
		extentTest
				.log(LogStatus.INFO, "Sending addBook SOAP message" );
		
//		send(bookStoreClient)
//        .payload(new ClassPathResource("com/accenture/citrus/bookstore/TestRequest.xml"));
		
		//create message
		Message<AddBookRequestMessage> message = MessageBuilder.withPayload(createAddBookRequestMessage(isbn)).build();
		
		extentTest.log(LogStatus.INFO,  "HTML","Book Title - <b>" + message.getPayload().getBook().getTitle()+"</b>");
		extentTest.log(LogStatus.INFO,  "HTML","Book Author - <b>" + message.getPayload().getBook().getAuthor()+"</b>");
		extentTest.log(LogStatus.INFO,  "HTML","Book ISBN - <b>" + message.getPayload().getBook().getIsbn()+"</b>");
		extentTest.log(LogStatus.INFO,  "HTML","Book Year - <b>" + message.getPayload().getBook().getYear()+"</b>");
		extentTest.log(LogStatus.INFO,  "HTML","Book Registration Date - <b>" + message.getPayload().getBook().getRegistrationDate().getTime()+"</b>");
		try {
		//send addBook request
        send(bookStoreClient)
           .payload(createAddBookRequestMessage(isbn), marshaller)
            .header("citrus_soap_action", "addBook");
		 
        extentTest
		.log(LogStatus.INFO, "Sent addBook SOAP Message" );
		} catch (Exception exception) {
			extentTest
			.log(LogStatus.FAIL, "Duplicate ISBN "+isbn+" Book already exists in registry!");
		}
//		System.out.println(">>>>");
        //validate receive addBook request
        receive(bookStoreClient)
            .validationCallback(new XmlMarshallingValidationCallback<AddBookResponseMessage>() {
            	@Override
                public void validate(AddBookResponseMessage response, Map<String, Object> headers, TestContext context) {
                	System.out.println("success - "+response.isSuccess());
            		if (response.isSuccess()) {
                		  extentTest
                    		.log(LogStatus.INFO, "Received addBook SOAP Message");
                	} else {
                		  extentTest
                    		.log(LogStatus.INFO, "Not received addBook SOAP Message");
                	}
                    org.springframework.util.Assert.isTrue(response.isSuccess());
            		
                }
            });
//        System.out.println("<<<<<");
        ExtentManager.getReporter().endTest(ExtentTestManager.getTest());        
        ExtentManager.getReporter().flush();
    }
    
    /**
     * @param isbn
     * @return
     */
    private AddBookRequestMessage createAddBookRequestMessage(String isbn) {
        AddBookRequestMessage requestMessage = new AddBookRequestMessage();
        Book book = new Book();
        book.setAuthor("Mike Loukides, Sonatype");
        book.setTitle("Maven: The Definitive Guide");
        book.setIsbn(isbn);
        book.setYear(2008);
        book.setRegistrationDate(Calendar.getInstance());
        requestMessage.setBook(book);
        return requestMessage;
    }
    
    @BeforeClass
	public static void runOnceBeforeClass() {
    	System.out.println("@BeforeClass - AddBook_Ok_3_IT");
//		AAFTLogger.writeToLog("@BeforeClass - AddBook_Ok_2_IT extent - " + extent);
		extent = ExtentManager.getExtentManager();
		ExtentTestManager.startTest("API Test : " + scriptName, "TestNGCitrusTestDesigner", "api_test");
	}

	@AfterClass
	public static void runOnceAfterClass() {
//		AAFTLogger.writeToLog("@@AfterClass - AddBook_Ok_2_IT");
		ExtentManager.getReporter().endTest(ExtentTestManager.getTest());
		ExtentManager.getReporter().flush();
		
		String status = ExtentTestManager.getThreadStatus();
		if (status == null || status.trim().equals("")) {
			status = "p";
		}
		RestCall rc = new RestCall();
		rc.simpleGet(ExtentTestManager.getTestCaseNumber(), status);
		
//		System.out.println("@AfterClass - AddBook_Ok_2_IT extent - " + extent);
	}
}

