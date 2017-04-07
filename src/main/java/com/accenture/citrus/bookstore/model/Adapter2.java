package com.accenture.citrus.bookstore.model;

import java.util.Calendar;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Class is used for XML Binding(JAXB)
 *
 * @author vijay.venkatappa
 *
 */
public class Adapter2 extends XmlAdapter<String, Calendar> {

  @Override
  public Calendar unmarshal(String value) {
	return (javax.xml.bind.DatatypeConverter.parseDate(value));
  }

  @Override
  public String marshal(Calendar value) {
	if (value == null) {
	  return null;
	}
	return (javax.xml.bind.DatatypeConverter.printDate(value));
  }

}
