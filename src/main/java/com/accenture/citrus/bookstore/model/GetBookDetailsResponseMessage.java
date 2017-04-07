package com.accenture.citrus.bookstore.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Class is used to XML Binding(JAXB) and get book details response message
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
 *         &lt;element name="book" type="{http://www.consol.com/schemas/bookstore}Book"/&gt;
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
@XmlType(name = "", propOrder = { "book" })
@XmlRootElement(name = "GetBookDetailsResponseMessage")
public class GetBookDetailsResponseMessage {

  @XmlElement(required = true)
  protected Book book;

  /**
   * Method is used to get the value of the book property.
   * 
   * @return the value of the book property possible object is {@link Book }
   * 
   */
  public Book getBook() {
	return book;
  }

  /**
   * Method is used to set the value of the book property.
   * 
   * @param value - represents the value of the book property allowed object is {@link Book }
   * 
   */
  public void setBook(Book value) {
	this.book = value;
  }

}
