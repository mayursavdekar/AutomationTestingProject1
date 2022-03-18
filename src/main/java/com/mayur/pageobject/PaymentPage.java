/**
 * 
 */
package com.mayur.pageobject;

import java.text.DecimalFormat;

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
	@FindBy(xpath = "//a[@class='bankwire']")
	WebElement payByBankWire;
	@FindBy(xpath = "//span[text()='I confirm my order']")
	WebElement confirmOrderBtn;
	@FindBy (xpath = "//strong[text()='Your order on My Store is complete.']")
	WebElement validateOrdersuccessfulllyPlaced;
    @FindBy(xpath = "//span[@id='product_price_1_1_653969']")
    WebElement discountedePricePerPiece;
    @FindBy(xpath = "//tr[@id='product_1_1_0_653969']/td[5]/span")
    WebElement orderedQuantity;
    @FindBy(xpath = "//td[@id='total_shipping']")
    WebElement totalShippingCharge;
    @FindBy(xpath = "//span[@id='total_price']")
    WebElement totalPrice;
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
	public void clickPayByBankWire() {
		payByBankWire.click();
	}
	public void clickConfirmOrder() {
		confirmOrderBtn.click();
	}
	public boolean validateOrderSuccessfullyPlaced(){
		if(validateOrdersuccessfulllyPlaced.isDisplayed())
			return true;
		else
			return false;
	}
	public boolean validatePaymentCalculations() {
		DecimalFormat df=new DecimalFormat("#.00");
	  String a1 = discountedePricePerPiece.getText();
	   String new_a1 = a1.replace("$", "");
	   System.out.println("discounted price str :- "+new_a1);
	     double num1 = Double.valueOf(new_a1);
	   System.out.println("Discounted price num:- "+num1);
	   
	   String a2 = orderedQuantity.getText();
	   System.out.println("quantity  str :- "+a2);
	    double num2 = Double.valueOf(a2);
	   System.out.println("quantity num :- "+num2);
	   
	    String a3 = totalShippingCharge.getText();
	    String new_a3 = a1.replace("$", "");
	    System.out.println("shipppingCharge str :- "+new_a3);
	     double num3 = Double.valueOf(new_a3);
	     System.out.println("shipping charge num :- "+num3);
	     
	    String a4=totalPrice.getText();
	    String new_a4 = a1.replace("$", "");
	    System.out.println("total price str :- "+new_a4);
	    double num4 = Double.valueOf(new_a4);
	    System.out.println("total price num :- "+num4);
	  
	     double calculatedTotal =num1*num2+num3;
	    System.out.println("calculated total :- "+calculatedTotal);
	    if (calculatedTotal==num4) {
			return true;
		}
	    else {
	    	return false;
	    }
	}
}
