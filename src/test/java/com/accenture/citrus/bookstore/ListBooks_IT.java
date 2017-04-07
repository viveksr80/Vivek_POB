package com.accenture.citrus.bookstore;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.oxm.Marshaller;

import org.testng.annotations.Test;

import com.accenture.aaft.report.ExtentManager;
import com.accenture.aaft.report.ExtentTestManager;
import com.accenture.citrus.bookstore.model.Book;
import com.accenture.citrus.bookstore.model.ListBooksRequestMessage;
import com.accenture.citrus.bookstore.model.ListBooksResponseMessage;
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
public class ListBooks_IT extends TestNGCitrusTestDesigner {

	static ExtentReports extent;
	static String scriptName = "ListBooks_IT";
	static ExtentTest extentTest;

	@Autowired
	@Qualifier("bookStoreClient")
	private WebServiceClient bookStoreClient;

	@Autowired
	private Marshaller marshaller;

	@CitrusTest(name = "ListAllBooks_IT")
	public void listAllBooksTest() {

		ListBooksRequestMessage listBooksRequestMessage = new ListBooksRequestMessage();
		extent = ExtentManager.getExtentManager();

		System.out.println("calling listbook details");
		send(bookStoreClient).payload(listBooksRequestMessage, marshaller).header("citrus_soap_action", "listBooks");
		receive(bookStoreClient).validationCallback(new XmlMarshallingValidationCallback<ListBooksResponseMessage>() {
			@Override
			public void validate(ListBooksResponseMessage response, Map<String, Object> headers, TestContext context) {

				System.out.println("book size  - " + response.getBooks().getBooks().size());

				ListBooksResponseMessage.Books booksResponse = response.getBooks();
				List<Book> books = booksResponse.getBooks();

				if (null != books) {
					int sz = 0;
					for (Book book : books) {
						if (sz == 10) {
							break;
						}
						System.out.println("getIsbn - " + book.getIsbn() + "..getTitle - " + book.getTitle()
								+ "..getAuthor - " + book.getAuthor());
						scriptName = "Book details for ISBN -  " + book.getIsbn();
						ExtentTestManager.startTest("API Test : " + scriptName, "Book details ", "api_test");
						extentTest = ExtentTestManager.getTest();
						extentTest.log(LogStatus.FAIL, "Books List");

						extentTest.log(LogStatus.INFO, "HTML", "ISBN - <b>" + book.getIsbn() + "</b> : Title - <b>"
								+ book.getTitle() + "</b> : Author - <b>" + book.getAuthor() + "</b>");
						ExtentManager.getReporter().endTest(ExtentTestManager.getTest());
						ExtentManager.getReporter().flush();
						
						/*String status = ExtentTestManager.getThreadStatus();
						if (status == null || status.trim().equals("")) {
							status = "p";
						}*/
						RestCall rc = new RestCall();
						rc.simpleGet(ExtentTestManager.getTestCaseNumber(), "f");
						sz++;
					}
				}
			}
		});
		System.out.println("receiving listbook details");


	}

}
