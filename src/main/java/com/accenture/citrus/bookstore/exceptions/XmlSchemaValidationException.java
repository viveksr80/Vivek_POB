package com.accenture.citrus.bookstore.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandlingException;

/**
 * Class is used to provide XML schema validation exception
 *
 * @author vijay.venkatappa
 *
 */
public class XmlSchemaValidationException extends MessageHandlingException {

  private static final long serialVersionUID = 1L;

  private static Logger log = LoggerFactory.getLogger(XmlSchemaValidationException.class);

  /**
   * @param failedMessage - represents failed message
   * @param cause - represents Throwable object
   */
  public XmlSchemaValidationException(Message<?> failedMessage, Throwable cause) {
	super(failedMessage);

	log.error("Schema validation error", cause);
  }
}
