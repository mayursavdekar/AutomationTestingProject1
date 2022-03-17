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
public class ShippingPage extends BasePage{
	@FindBy(id = "cgv")
	WebElement termsAndConditionCheckbox;
	@FindBy(xpath = "//button[@name=\"processCarrier\"]")
	WebElement proceedToCheckoutBtn;
	public ShippingPage() {
		PageFactory.initElements(driver, this);
	}
	public void clickTermsAndConditionCheckbox() {
		if (!termsAndConditionCheckbox.isSelected()) {
			termsAndConditionCheckbox.click();
		}

	}
	public PaymentPage clickProceedToCheckOut(){
		proceedToCheckoutBtn.click();
		return new PaymentPage();
	}
}
