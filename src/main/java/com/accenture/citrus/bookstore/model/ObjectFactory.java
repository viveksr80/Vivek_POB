package com.accenture.citrus.bookstore.model;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * Class is used to store XML objects
 * 
 * This object contains factory methods for each Java content interface and Java element interface generated in the
 * com.accenture.citrus.bookstore.model package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the Java representation for XML content.
 * The Java representation of XML content can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory methods for each of these are provided in
 * this class.
 * 
 * @author vijay.venkatappa
 * 
 */

@XmlRegistry
public class ObjectFactory {

  /**
   * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package:
   * com.accenture.citrus.bookstore.model
   * 
   */
  public ObjectFactory() {
  }

  /**
   * Method is used to create an instance of {@link ListBooksResponseMessage }
   *
   * @return ListBooksResponseMessage
   */
  public ListBooksResponseMessage createListBooksResponseMessage() {
	return new ListBooksResponseMessage();
  }

  /**
   * Method is used to create an instance of {@link AddBookRequestMessage }
   *
   * @return AddBookRequestMessage
   */
  public AddBookRequestMessage createAddBookRequestMessage() {
	return new AddBookRequestMessage();
  }

  /**
   * Method is used to create an instance of {@link Book }
   *
   * @return Book
   */
  public Book createBook() {
	return new Book();
  }

  /**
   * Method is used to create an instance of {@link AddBookResponseMessage }
   *
   * @return AddBookResponseMessage
   */
  public AddBookResponseMessage createAddBookResponseMessage() {
	return new AddBookResponseMessage();
  }

  /**
   * Method is used to create an instance of {@link GetBookDetailsRequestMessage }
   *
   * @return GetBookDetailsRequestMessage
   */
  public GetBookDetailsRequestMessage createGetBookDetailsRequestMessage() {
	return new GetBookDetailsRequestMessage();
  }

  /**
   * Method is used to create an instance of {@link GetBookDetailsResponseMessage }
   *
   * @return GetBookDetailsResponseMessage
   */
  public GetBookDetailsResponseMessage createGetBookDetailsResponseMessage() {
	return new GetBookDetailsResponseMessage();
  }

  /**
   * Method is used to create an instance of {@link GetBookAbstractRequestMessage }
   *
   * @return GetBookAbstractRequestMessage
   */
  public GetBookAbstractRequestMessage createGetBookAbstractRequestMessage() {
	return new GetBookAbstractRequestMessage();
  }

  /**
   * Method is used to Create an instance of {@link ListBooksRequestMessage }
   *
   * @return GetBookAbstractResponseMessage
   */
  public GetBookAbstractResponseMessage createGetBookAbstractResponseMessage() {
	return new GetBookAbstractResponseMessage();
  }

  /**
   * Method is used to create an instance of {@link ListBooksRequestMessage }
   *
   * @return ListBooksRequestMessage
   */
  public ListBooksRequestMessage createListBooksRequestMessage() {
	return new ListBooksRequestMessage();
  }

  /**
   * Method is used to create an instance of {@link ListBooksResponseMessage.Books }
   *
   * @return ListBooksResponseMessage.Books
   */
  public ListBooksResponseMessage.Books createListBooksResponseMessageBooks() {
	return new ListBooksResponseMessage.Books();
  }

}
