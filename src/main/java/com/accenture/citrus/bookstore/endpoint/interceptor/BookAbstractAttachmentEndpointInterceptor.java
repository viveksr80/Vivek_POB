package com.accenture.citrus.bookstore.endpoint.interceptor;

import org.springframework.core.io.*;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.interceptor.EndpointInterceptorAdapter;
import org.springframework.ws.soap.SoapMessage;

import java.io.IOException;
import java.io.InputStream;

/**
 * Class is used to adds an image attachment to the SOAP response message.
 *
 * @author vijay.venkatappa
 *
 */
public class BookAbstractAttachmentEndpointInterceptor extends EndpointInterceptorAdapter {

  private Object bookAbstractInboundGateway;

  private final Resource bookAbstractResource = new ClassPathResource("com/consol/citrus/samples/bookstore/book-abstract.txt");

  @Override
  public boolean handleResponse(MessageContext messageContext, Object endpoint) throws Exception {
	SoapMessage response = (SoapMessage) messageContext.getResponse();

	if (endpoint.equals(bookAbstractInboundGateway)) {
	  response.addAttachment("book-abstract", new InputStreamSource() {
		public InputStream getInputStream() throws IOException {
		  return bookAbstractResource.getInputStream();
		}
	  }, "text/plain");
	}

	return true;
  }

  /**
   * Method is used to set bookAbstractInboundGateway
   *
   * @param bookAbstractInboundGateway - represents bookAbstractInboundGateway to set
   */
  public void setBookAbstractInboundGateway(Object bookAbstractInboundGateway) {
	this.bookAbstractInboundGateway = bookAbstractInboundGateway;
  }
}
