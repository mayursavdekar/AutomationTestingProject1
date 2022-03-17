/**
 * 
 */
package com.mayur.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mayur.base.BasePage;

/**
 * @author Admin
 *
 */
public class Address extends BasePage{
	public Address() {
		PageFactory.initElements(driver, this);
	}
	
	  @FindBy(xpath = "//span[text()='Proceed to checkout']")
	  WebElement proceedToCheckoutBtn;
	  
	  public ShippingPage clickProceedToCheckOut(){
		  proceedToCheckoutBtn.click();
		  return new ShippingPage();
	  }
}
