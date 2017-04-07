package com.accenture.citrus.bookstore.model;

import java.util.Calendar;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Class is used for for XML Binding(JAXB)
 *
 * @author vijay.venkatappa
 *
 */
public class Adapter1 extends XmlAdapter<String, Calendar> {

  @Override
  public Calendar unmarshal(String value) {
	return (javax.xml.bind.DatatypeConverter.parseDateTime(value));
  }

  @Override
  public String marshal(Calendar value) {
	if (value == null) {
	  return null;
	}
	return (javax.xml.bind.DatatypeConverter.printDateTime(value));
  }

}
