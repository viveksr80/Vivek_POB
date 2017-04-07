package com.accenture.aaft.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class is used to store product category web element at compile time
 *
 * @author vijay.venkatappa
 *
 */
public class ProductCategory_PF {

  @FindBy(xpath = "//*[@id='menu-item-33']/a")
  public WebElement productCategory;

  @FindBy(xpath = "//a[contains(@href,'iphones')]")
  public WebElement clickOnIphone;

  @FindBy(xpath = "//a[contains(@href,'imacs')]")
  public WebElement clickOnImacs;

  @FindBy(xpath = "//a[contains(@href,'ipads')]")
  public WebElement clickOnIpads;

  @FindBy(xpath = "//input[@value='Add To Cart']")
  public WebElement addToCart;

}
