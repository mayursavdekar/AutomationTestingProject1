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
public class SummeryPage extends BasePage {
	  @FindBy(xpath = "//a[@class='logout']")
	  WebElement signOutText;
  @FindBy(xpath = "//span[text()='Proceed to checkout']")
  WebElement proceedToCheckoutBtn;
	public SummeryPage() {
		PageFactory.initElements(driver, this);
	}
  public boolean validateSignOutText() {
	if (signOutText.isDisplayed()) {
		return true;
	}   
	else {
		return false;
	}
  }

 public Object checkout() {
	 if (signOutText.isDisplayed()) {
		 proceedToCheckoutBtn.click();
		return new Address();
	}
	 else {
		proceedToCheckoutBtn.click();
		return new LoginAndRegistrationPage();
	}
 }
  
}
