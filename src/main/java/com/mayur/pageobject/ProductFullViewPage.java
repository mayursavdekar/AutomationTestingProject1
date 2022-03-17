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
public class ProductFullViewPage extends BasePage{
	@FindBy(xpath = "//input[@id='quantity_wanted']")
	WebElement inputQuantityBox;
	@FindBy(xpath = "//select[@id='group_1']")
	WebElement selectSizeDD;
	@FindBy(xpath = "//button[@name='Submit']")
	WebElement addToCartBtn;
	@FindBy(xpath = "//h2/i[@class='icon-ok']")
	WebElement productSuccessfullyAddedText;
	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	WebElement proceedToCheckoutBtn;
	public ProductFullViewPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterQuantity(String quantity) {
		inputQuantityBox.clear();
		inputQuantityBox.sendKeys(quantity);
	}
	public void selectSize(String size) {
		String finalSize=null;
		if (size.equalsIgnoreCase("small")||size.equalsIgnoreCase("s")) {
			finalSize="S";
		}
 		else if(size.equalsIgnoreCase("medium")||size.equalsIgnoreCase("m")) {
			finalSize="M";
		}
 		else if(size.equalsIgnoreCase("large")||size.equalsIgnoreCase("l")) {
			finalSize="L";
		}
		selectByVisible(selectSizeDD, finalSize);
	}
	public void clickAddToCart(){
	addToCartBtn.click();
	}
	public boolean validateAddedToCartSuccessfully() {
		if (productSuccessfullyAddedText.isDisplayed()) {
			return true;
		}
 		else {
 			return false;
 		}
	}
	public SummeryPage clickProceedToCheckout(){
			proceedToCheckoutBtn.click();
			return new SummeryPage();
		}	
}
