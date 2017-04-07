package com.accenture.citrus.bookstore.validation;

import java.io.IOException;

import javax.xml.XMLConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.integration.xml.DefaultXmlPayloadConverter;
import org.springframework.integration.xml.XmlPayloadConverter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.xml.validation.XmlValidationException;
import org.springframework.xml.validation.XmlValidator;
import org.springframework.xml.validation.XmlValidatorFactory;
import org.xml.sax.SAXParseException;

import com.accenture.citrus.bookstore.exceptions.XmlSchemaValidationException;

/**
 * Class is used as XML schema validating channel intercepter
 * 
 * Channel intercepter validating incoming messages with a given XSD Schema resource. In case of validation errors the
 * intercepter raises a {@link XmlValidationException}. The exception can be handled by an exception resolver for
 * transforming into proper SOAP faults for example.
 * 
 * @author vijay.venkatappa
 */
public class XmlSchemaValidatingChannelInterceptor extends ChannelInterceptorAdapter {
  /** XML validator */
  private XmlValidator xmlValidator;

  /** Payload converter */
  private XmlPayloadConverter converter = new DefaultXmlPayloadConverter();

  /**
   * Logger
   */
  private static Logger log = LoggerFactory.getLogger(XmlSchemaValidatingChannelInterceptor.class);

  static String scriptName = "XmlSchemaValidatingChannelInterceptor";

  /**
   * Constructor
   * 
   * @param schemaResource - represents schema resource
   * @throws IOException - represents exception
   */
  public XmlSchemaValidatingChannelInterceptor(Resource schemaResource) throws IOException {
	this(schemaResource, "xml-schema");
	// extentTest = ExtentTestManager.getTest();
  }

  /**
   * Constructor.
   * 
   * @param schemaResource - represents schema resource
   * @param schemaLanguage - represents schema language
   * @throws IOException - represents exception
   */
  public XmlSchemaValidatingChannelInterceptor(Resource schemaResource, String schemaLanguage) throws IOException {
	// extentTest = ExtentTestManager.getTest();
	if (schemaLanguage.equals("xml-schema")) {
	  this.xmlValidator = XmlValidatorFactory.createValidator(schemaResource, XMLConstants.W3C_XML_SCHEMA_NS_URI);
	} else {
	  this.xmlValidator = XmlValidatorFactory.createValidator(schemaResource, XMLConstants.RELAXNG_NS_URI);
	}
  }

  @Override
  public Message<?> preSend(Message<?> message, MessageChannel channel) {

	validateSchema(message, channel);
	log.debug("XSD schema validation successful");

	return super.preSend(message, channel);
  }

  /**
   * Method is used validate the payload of the message
   * 
   * @param message - represents message
   * @param channel - represents channel
   */
  public void validateSchema(Message<?> message, MessageChannel channel) {
	try {
	  SAXParseException[] exceptions = xmlValidator.validate(converter.convertToSource(message.getPayload()));
	  if (exceptions.length > 0) {
		StringBuilder msg = new StringBuilder("Invalid XML message on channel ");
		if (channel != null) {
		  msg.append(channel.toString());
		} else {
		  msg.append("<unknown>");
		}
		msg.append(":\n");
		for (SAXParseException e : exceptions) {
		  msg.append("\t").append(e.getMessage());
		  msg.append(" (line=").append(e.getLineNumber());
		  msg.append(", col=").append(e.getColumnNumber()).append(")\n");
		}
		log.warn("XSD schema validation failed: ", msg.toString());
		throw new XmlSchemaValidationException(message, exceptions[0]);
	  }
	} catch (IOException ioE) {
	  throw new MessagingException("Exception applying schema validation", ioE);
	}
  }
}
