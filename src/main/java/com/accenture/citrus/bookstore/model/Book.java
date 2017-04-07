package com.accenture.citrus.bookstore.model;

import java.util.Calendar;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Class is used to XML Binding(JAXB) and get book details
 * 
 * <p>
 * Java class for Book complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Book"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="author" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="isbn" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="year" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="registration-date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
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
@XmlType(name = "Book", propOrder = { "id", "title", "author", "isbn", "year", "registrationDate" })
public class Book {

  protected Long id;
  @XmlElement(required = true)
  protected String title;
  @XmlElement(required = true)
  protected String author;
  @XmlElement(required = true)
  protected String isbn;
  protected int year;
  @XmlElement(name = "registration-date", type = String.class)
  @XmlJavaTypeAdapter(Adapter1.class)
  @XmlSchemaType(name = "dateTime")
  protected Calendar registrationDate;

  /**
   * Method is used to get the value of the id property.
   * 
   * @return possible object is {@link Long }
   * 
   */
  public Long getId() {
	return id;
  }

  /**
   * Method is used to set the value of the id property.
   * 
   * @param value - represents the value of the id property allowed object is {@link Long }
   * 
   */
  public void setId(Long value) {
	this.id = value;
  }

  /**
   * Method is used to get the value of the title property.
   * 
   * @return the value of the title property possible object is {@link String }
   * 
   */
  public String getTitle() {
	return title;
  }

  /**
   * Method is used to set the value of the title property.
   * 
   * @param value - represents the value of the title property allowed object is {@link String }
   * 
   */
  public void setTitle(String value) {
	this.title = value;
  }

  /**
   * Method is used to get the value of the author property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getAuthor() {
	return author;
  }

  /**
   * Method is used to set the value of the author property.
   * 
   * @param value - represents the value of the author property allowed object is {@link String }
   * 
   */
  public void setAuthor(String value) {
	this.author = value;
  }

  /**
   * Method is used to get the value of the isbn property.
   * 
   * @return isbn possible object is {@link String }
   * 
   */
  public String getIsbn() {
	return isbn;
  }

  /**
   * Method is used to set the value of the isbn property
   *
   * @param value - represents the value of the isbn property allowed object is {@link String }
   */
  public void setIsbn(String value) {
	this.isbn = value;
  }

  /**
   * Method is used to get the value of the year property
   *
   * @return year
   */
  public int getYear() {
	return year;
  }

  /**
   * Method is used to set the value of the year property
   *
   * @param value - represents the value of the year property
   */
  public void setYear(int value) {
	this.year = value;
  }

  /**
   * Method is used to get the value of the registrationDate property
   *
   * @return the registrationDate property possible object is {@link String }
   * 
   */
  public Calendar getRegistrationDate() {
	return registrationDate;
  }

  /**
   * Method is used to set the value of the registrationDate property
   *
   * @param value - represents the value of the registrationDate property allowed object is {@link String }
   */
  public void setRegistrationDate(Calendar value) {
	this.registrationDate = value;
  }

}
