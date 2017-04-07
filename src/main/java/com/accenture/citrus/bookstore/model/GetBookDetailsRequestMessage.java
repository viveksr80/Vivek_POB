package com.accenture.citrus.bookstore.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Class is used to XML Binding(JAXB) and get book details request message
 * 
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="isbn" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * @author vijay.venkatappa
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "isbn" })
@XmlRootElement(name = "GetBookDetailsRequestMessage")
public class GetBookDetailsRequestMessage {

  @XmlElement(required = true)
  protected String isbn;

  /**
   * Method is used to get the value of the isbn property.
   * 
   * @return the value of the isbn property possible object is {@link String }
   * 
   */
  public String getIsbn() {
	return isbn;
  }

  /**
   * Method is used to set the value of the isbn property.
   * 
   * @param value - represents the value of the isbn property allowed object is {@link String }
   * 
   */
  public void setIsbn(String value) {
	this.isbn = value;
  }

}
