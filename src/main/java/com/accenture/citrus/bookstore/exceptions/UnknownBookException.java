package com.accenture.citrus.bookstore.exceptions;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandlingException;

/**
 * Class is used to provide unknown book exception
 *
 * @author vijay.venkatappa
 *
 */
public class UnknownBookException extends MessageHandlingException {

  private static final long serialVersionUID = 1L;

  /**
   * @param failedMessage - represents failed message
   * @param isbn - represents isbn value
   */
  public UnknownBookException(Message<?> failedMessage, String isbn) {
	super(failedMessage, "Book(isbn:'" + isbn + "') not available in registry");
  }
}
