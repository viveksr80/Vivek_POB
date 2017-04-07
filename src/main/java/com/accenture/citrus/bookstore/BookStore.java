package com.accenture.citrus.bookstore;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.xml.datatype.DatatypeConfigurationException;

import org.slf4j.LoggerFactory;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import com.accenture.citrus.bookstore.exceptions.DuplicateIsbnException;
import com.accenture.citrus.bookstore.exceptions.UnknownBookException;
import com.accenture.citrus.bookstore.model.AddBookRequestMessage;
import com.accenture.citrus.bookstore.model.AddBookResponseMessage;
import com.accenture.citrus.bookstore.model.Book;
import com.accenture.citrus.bookstore.model.GetBookAbstractRequestMessage;
import com.accenture.citrus.bookstore.model.GetBookAbstractResponseMessage;
import com.accenture.citrus.bookstore.model.GetBookDetailsRequestMessage;
import com.accenture.citrus.bookstore.model.GetBookDetailsResponseMessage;
import com.accenture.citrus.bookstore.model.ListBooksResponseMessage;
import com.accenture.citrus.bookstore.model.ListBooksResponseMessage.Books;

/**
 * Class is used to store book details
 *
 * @author vijay.venkatappa
 *
 */
public class BookStore {
  private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BookStore.class);

  static String scriptName = "BookStore";

  /** In memory book registry */
  private static Map<String, Book> bookStore = new HashMap<String, Book>();

  /** Atomic identifyer generator */
  private static AtomicLong ids = new AtomicLong();

  /**
   * Constructor
   * 
   */
  public BookStore() {

  }

  /**
   * Method is used add a book to the registry.
   * 
   * @param request - represents request
   * @return Message<AddBookResponseMessage>
   * @throws DatatypeConfigurationException - represents exception
   */
  public Message<AddBookResponseMessage> addBook(Message<AddBookRequestMessage> request) {
	AddBookResponseMessage response = new AddBookResponseMessage();

	logger.debug("[BookStore] addBook - " + request.getPayload());

	Book book = request.getPayload().getBook();

	if (!bookStore.containsKey(book.getIsbn())) {
	  book.setId(ids.incrementAndGet());
	  book.setRegistrationDate(Calendar.getInstance());
	  bookStore.put(book.getIsbn(), book);

	  response.setSuccess(true);

	} else {
	  throw new DuplicateIsbnException(request);
	}

	return MessageBuilder.withPayload(response).build();
  }

  /**
   * Method is used to get the book details for a book with given isbn.
   * 
   * @param request - represents request
   * @return Message<GetBookDetailsResponseMessage>
   */
  public Message<GetBookDetailsResponseMessage> getBookDetails(Message<GetBookDetailsRequestMessage> request) {
	GetBookDetailsResponseMessage response = new GetBookDetailsResponseMessage();

	Book book = bookStore.get(request.getPayload().getIsbn());

	if (book == null) {

	  throw new UnknownBookException(request, request.getPayload().getIsbn());
	} else {
	  response.setBook(book);

	}

	return MessageBuilder.withPayload(response).build();
  }

  /**
   * Method is used to get the book cover for a book with given isbn.
   * 
   * @param request - represents request
   * @return Message<GetBookAbstractResponseMessage>
   */
  public Message<GetBookAbstractResponseMessage> getBookAbstract(Message<GetBookAbstractRequestMessage> request) {
	GetBookAbstractResponseMessage response = new GetBookAbstractResponseMessage();

	Book book = bookStore.get(request.getPayload().getIsbn());

	if (book == null) {
	  throw new UnknownBookException(request, request.getPayload().getIsbn());
	} else {
	  response.setBook(book);
	}

	return MessageBuilder.withPayload(response).build();
  }

  /**
   * Method is used to list all books in this registry.
   * 
   * @return Message<ListBooksResponseMessage>
   */
  public Message<ListBooksResponseMessage> listBooks() {
	ListBooksResponseMessage response = new ListBooksResponseMessage();
	Books books = new Books();
	books.getBooks().addAll(bookStore.values());

	response.setBooks(books);

	return MessageBuilder.withPayload(response).build();
  }
}
