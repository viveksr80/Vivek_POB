package com.accenture.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Calendar;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.XmlMappingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.accenture.citrus.bookstore.BookStore;
import com.accenture.citrus.bookstore.model.AddBookRequestMessage;
import com.accenture.citrus.bookstore.model.AddBookResponseMessage;
import com.accenture.citrus.bookstore.model.Book;
import com.accenture.citrus.bookstore.model.GetBookDetailsRequestMessage;
import com.accenture.citrus.bookstore.model.GetBookDetailsResponseMessage;
import com.accenture.citrus.bookstore.model.ListBooksRequestMessage;
import com.accenture.citrus.bookstore.model.ListBooksResponseMessage;
//import com.consol.citrus.CitrusConstants;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.dsl.testng.TestNGCitrusTestDesigner;
import com.consol.citrus.endpoint.Endpoint;
import com.consol.citrus.message.Message;
import com.consol.citrus.message.MessageType;
import com.consol.citrus.validation.builder.MessageContentBuilder;
import com.consol.citrus.validation.builder.PayloadTemplateMessageBuilder;
import com.consol.citrus.ws.client.WebServiceClient;

/**
 * Class is used as base controller
 *
 * @author vijay.venkatappa
 *
 */
@Controller
@SuppressWarnings({ "unused" })
public class BaseController extends TestNGCitrusTestDesigner {

  @Autowired
  @Qualifier("bookStoreClient")
  public WebServiceClient bookStoreClient;

  @Autowired
  public Endpoint bookStoreEndpoint;

  @Autowired
  public MessageChannel inboundChannel;

  @Autowired
  public SubscribableChannel outboundChannel;

  private static int counter = 0;
  private static final String VIEW_INDEX = "index";
  private static final String VIEW_WELCOME = "welcome";
  private static final String RESULT = "returnResult";
  private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

  String messageType = MessageType.XML.toString(); // CitrusConstants.DEFAULT_MESSAGE_TYPE;

  @Autowired
  private Marshaller marshaller;

  TestContext context = new TestContext();
  BookStore bookStore = new BookStore();

  /**
   * Method is used to call welcome page
   *
   * @param model - represents ModelMap
   * @return index page
   */
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String welcome(ModelMap model) {

	model.addAttribute("message", "Welcome");
	model.addAttribute("counter", ++counter);
	logger.debug("[welcome] counter : {}", counter);

	// Spring uses InternalResourceViewResolver and return back index.jsp
	return VIEW_INDEX;

  }

  /**
   * Method is used to call home page
   *
   * @param model - represents ModelMap
   * @return welcome page
   */
  @RequestMapping(value = "/home", method = RequestMethod.GET)
  public String home(ModelMap model) {

	model.addAttribute("message", "Welcome");
	model.addAttribute("counter", ++counter);
	logger.debug("[home] counter : {}", counter);
	// Spring uses InternalResourceViewResolver and return back index.jsp
	return VIEW_WELCOME;

  }

  // @RequestMapping(value = "/addBook", method = RequestMethod.POST, consumes = "application/xml")
  // @ResponseBody
  // public ResponseEntity<String> addBook(@RequestBody String requestBody) {
  /**
   * Method is used to add the book details
   *
   * @param requestBody - represents request body values
   * @param model - represents ModelMap
   * @return result
   */
  @RequestMapping(value = { "/addBook" }, method = RequestMethod.POST, consumes = "application/xml")
  public String addBook(@RequestBody String requestBody, ModelMap model) {
	logger.debug("[addBook] addBook counter : {}", counter);
	// extentTest = ExtentTestManager.getTest();
	// // AAFTLogger.writeToLog("extentTest - "+extentTest);
	String isbn = "978-citrus:randomNumber(10)";
	String bookInfo = "";

	AddBookResponseMessage response = new AddBookResponseMessage();

	logger.debug("Handled application/xml request. Request body was: " + requestBody);
	try {
	  logger.debug("Before sending application/xml request. ");

	  if (null == bookStoreEndpoint) {
		System.out.println("endpoint is null");
	  } else {
		MessageContentBuilder messageBuilder = new PayloadTemplateMessageBuilder();
		Message message = messageBuilder.buildMessageContent(context, messageType);
		message.setHeader("citrus_soap_action", "addBook");
		message.setPayload(requestBody);
		bookStoreEndpoint.createProducer().send(message, context);
		logger.debug("After sending application/xml request.");

	  }

	  Message responseMessage = bookStoreEndpoint.createConsumer().receive(context, 50000);

	  // Get book for isbn
	  Book book = getBook("b5e3addf-0915-c282-cd2a-2d7690f2cb76");
	  bookInfo += "<products><product>	<productId>P-22345</productId><price>2545</price>	<book>";

	  if (null != book) {
		bookInfo += "<isbn>" + book.getIsbn() + "</isbn><title>" + book.getTitle() + "</title><discount>" + book.getAuthor() + "</discount>";
	  }
	  bookInfo += "</book></product></products>";

	  // Get all Books list
	  logger.debug("Before sending listbooks request. ");
	  getAllBooks();

	  model.addAttribute("book", bookInfo);
	} catch (Exception exception) {
	  exception.printStackTrace();
	}

	// return new ResponseEntity<String>(
	// "Handled application/xml request. Request body was: "
	// + requestBody, new HttpHeaders(), HttpStatus.OK);
	return RESULT;
  }

  /**
   * Method is used to create add book request message
   *
   * @param isbn - represents isbn value
   * @return AddBookRequestMessage
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

  /**
   * Method is used to get book details
   *
   * @param isbn represents isbn value
   * @return Book
   */
  private Book getBook(String isbn) {
	Book book = null;
	GetBookDetailsRequestMessage getBookDetailsRequestMessage = new GetBookDetailsRequestMessage();
	getBookDetailsRequestMessage.setIsbn(isbn);
	String xml2String = convertPayloadToString(getBookDetailsRequestMessage);
	MessageContentBuilder messageBuilder = new PayloadTemplateMessageBuilder();
	Message message = messageBuilder.buildMessageContent(context, messageType);
	message.setHeader("citrus_soap_action", "getBookDetails");
	message.setPayload(xml2String);
	bookStoreEndpoint.createProducer().send(message, context);

	Message responseMessage = bookStoreEndpoint.createConsumer().receive(context, 50000);

	GetBookDetailsResponseMessage getBookDetailsResponseObject = (GetBookDetailsResponseMessage) convertPayloadToObject(responseMessage);

	if (null != getBookDetailsResponseObject) {
	  book = getBookDetailsResponseObject.getBook();
	}

	return book;
  }

  /**
   * Method is used to convert payLoad to object
   *
   * @param responseMessage - represents response message
   * @return Object
   */
  private Object convertPayloadToObject(Message responseMessage) {
	JAXBContext jaxbContext;
	GetBookDetailsResponseMessage responseMessageObject = null;
	try {
	  jaxbContext = JAXBContext.newInstance(GetBookDetailsResponseMessage.class);
	  Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	  responseMessageObject = (GetBookDetailsResponseMessage) jaxbUnmarshaller.unmarshal(new StringReader(responseMessage.getPayload().toString()));
	  return responseMessageObject;
	} catch (JAXBException exception) {
	  exception.printStackTrace();
	}
	return responseMessageObject;
  }

  /**
   * Method is used to get all book details
   *
   */
  private void getAllBooks() {
	ListBooksRequestMessage listBooksRequestMessage = new ListBooksRequestMessage();

	String xml2String = convertPayloadToString(listBooksRequestMessage);
	MessageContentBuilder messageBuilder = new PayloadTemplateMessageBuilder();
	Message message = messageBuilder.buildMessageContent(context, messageType);
	message.setHeader("citrus_soap_action", "listBooks");
	message.setPayload(xml2String);
	bookStoreEndpoint.createProducer().send(message, context);

	Message responseMessage = bookStoreEndpoint.createConsumer().receive(context, 50000);

	JAXBContext jaxbContext;
	try {
	  jaxbContext = JAXBContext.newInstance(ListBooksResponseMessage.class);
	  Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	  ListBooksResponseMessage response = (ListBooksResponseMessage) jaxbUnmarshaller.unmarshal(new StringReader(responseMessage.getPayload().toString()));

	  ListBooksResponseMessage.Books booksResponse = response.getBooks();
	  List<Book> books = booksResponse.getBooks();

	  if (null != books) {
		for (Book book : books) {
		  System.out.println("getIsbn - " + book.getIsbn() + "  getTitle - " + book.getTitle() + " getAuthor - " + book.getAuthor());

		}
	  }

	} catch (JAXBException exception) {
	  exception.printStackTrace();
	}

  }

  /**
   * Method is used to convert payLoad to string
   *
   * @param object - represents Object
   * @return string value
   */
  public String convertPayloadToString(Object object) {
	String xml2String = "";
	File xmlFile = null;
	BufferedReader bufReader = null;
	FileOutputStream fileOutputStream = null;
	try {
	  fileOutputStream = new FileOutputStream("c://Report//ListBook.xml");

	  marshaller.marshal(object, new StreamResult(fileOutputStream));
	  xmlFile = new File("c://Report//ListBook.xml");

	  Reader fileReader = new FileReader(xmlFile);
	  bufReader = new BufferedReader(fileReader);
	  StringBuilder sb = new StringBuilder();
	  String line = bufReader.readLine();
	  while (line != null) {
		sb.append(line).append("\n");
		line = bufReader.readLine();
	  }
	  xml2String = sb.toString();
	} catch (FileNotFoundException fileNotFoundException) {
	  System.out.println("File Not Found Exception ");
	  fileNotFoundException.printStackTrace();
	} catch (XmlMappingException xmlMappingException) {
	  System.out.println("Xml Mapping Exception");
	  xmlMappingException.printStackTrace();
	} catch (IOException ioException) {
	  System.out.println("IO Exception");
	  ioException.printStackTrace();
	} finally {
	  try {
		if (null != bufReader)
		  bufReader.close();
		if (null != xmlFile)
		  xmlFile.delete();
		if (null != fileOutputStream)
		  fileOutputStream.close();
	  } catch (IOException ioException) {
		ioException.printStackTrace();
	  }
	}
	return xml2String;
  }

  /**
   * Method is used to convert string to Object
   *
   * @param object - represents Object
   * @param payLoad - represents payLoad values
   * @return Object
   */
  public Object convertStringToObject(Object object, String payLoad) {
	JAXBContext jaxbContext;
	Object marshalledObject = null;
	try {
	  jaxbContext = JAXBContext.newInstance(Object.class);
	  Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	  marshalledObject = (Object) jaxbUnmarshaller.unmarshal(new StringReader(payLoad));
	} catch (JAXBException exception) {
	  exception.printStackTrace();
	}
	return marshalledObject;
  }
}