package com.accenture.citrus.bookstore.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Class is used to XML Binding(JAXB) and list book response message
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
 *         &lt;element name="books"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence maxOccurs="unbounded"&gt;
 *                   &lt;element name="book" type="{http://www.consol.com/schemas/bookstore}Book"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
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
@XmlType(name = "", propOrder = { "books" })
@XmlRootElement(name = "ListBooksResponseMessage")
public class ListBooksResponseMessage {

  @XmlElement(required = true)
  protected ListBooksResponseMessage.Books books;

  /**
   * Method is used to get the value of the books property.
   * 
   * @return books possible object is {@link ListBooksResponseMessage.Books }
   * 
   */
  public ListBooksResponseMessage.Books getBooks() {
	return books;
  }

  /**
   * Method is used to set the value of the books property.
   * 
   * @param value allowed object is {@link ListBooksResponseMessage.Books }
   * 
   */
  public void setBooks(ListBooksResponseMessage.Books value) {
	this.books = value;
  }

  /**
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
   *       &lt;sequence maxOccurs="unbounded"&gt;
   *         &lt;element name="book" type="{http://www.consol.com/schemas/bookstore}Book"/&gt;
   *       &lt;/sequence&gt;
   *     &lt;/restriction&gt;
   *   &lt;/complexContent&gt;
   * &lt;/complexType&gt;
   * </pre>
   * 
   * 
   */
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(name = "", propOrder = { "books" })
  public static class Books {

	@XmlElement(name = "book", required = true)
	protected List<Book> books;

	/**
	 * Method is used to get the value of the books property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
	 * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
	 * the books property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getBooks().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Book }
	 * 
	 * @return books
	 * 
	 */
	public List<Book> getBooks() {
	  if (books == null) {
		books = new ArrayList<Book>();
	  }
	  return this.books;
	}

  }

}
