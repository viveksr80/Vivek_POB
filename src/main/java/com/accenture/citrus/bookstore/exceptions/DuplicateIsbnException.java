package com.accenture.citrus.bookstore.exceptions;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandlingException;

import com.accenture.citrus.bookstore.model.AddBookRequestMessage;

/**
 * Class is used to provide duplicate isbn exception
 *
 * @author vijay.venkatappa
 *
 */
public class DuplicateIsbnException extends MessageHandlingException {

  private static final long serialVersionUID = 1L;

  /**
   * @param failedMessage - represents failed message
   */
  public DuplicateIsbnException(Message<AddBookRequestMessage> failedMessage) {
	super(failedMessage, "Duplicate ISBN '" + failedMessage.getPayload().getBook().getIsbn() + "'! Book already exists in registry!");
  }
}
