/**
 * 
 */
package com.mayur.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mayur.base.BasePage;

/**
 * @author Mayur
 *
 */
public class PaymentPage extends BasePage {
@FindBy(xpath = "//h1[@class='page-heading']")
WebElement paymentPageText;
public PaymentPage() {
	PageFactory.initElements(driver, this);
}
public boolean validatePaymentPage(){
	 if (paymentPageText.isDisplayed()) {
	return true;	
	}
	 else {
		 return false;
	 }
}
}
