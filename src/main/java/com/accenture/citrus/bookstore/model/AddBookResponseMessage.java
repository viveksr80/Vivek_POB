package com.accenture.citrus.bookstore.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Class is used to XML Binding(JAXB) and add book response message
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
 *         &lt;element name="success" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
@XmlType(name = "", propOrder = { "success" })
@XmlRootElement(name = "AddBookResponseMessage")
public class AddBookResponseMessage {

  protected boolean success;

  /**
   * Method is used to get the value of the success property
   *
   * @return success
   */
  public boolean isSuccess() {
	return success;
  }

  /**
   * Method is used to set the value of the success property
   *
   * @param value - represents value of the success property
   */
  public void setSuccess(boolean value) {
	this.success = value;
  }

}
