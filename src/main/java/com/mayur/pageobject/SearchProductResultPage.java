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
public class SearchProductResultPage extends BasePage {

	@FindBy(xpath = "//span[@class='heading-counter']")
	WebElement searchResultText;
	@FindBy(xpath = "(//h5/a[@class='product-name'])[position()=2]")
	WebElement searchedItem;
	
	public SearchProductResultPage() {
		PageFactory.initElements(driver,this);
	}
	
	public boolean validateSearchResult(){
		String var = searchResultText.getText();
		System.out.println(var);
		String[] var1 = var.split(" ");
		System.out.println(var1[0]);
		int result = Integer.valueOf(var1[0]);
		System.out.println(result);
		if (result>0) {
			return true;
		}
		else {
			return false;
		}
	}
	public ProductFullViewPage clickOnAvailableProduct(){
		searchedItem.click();
		return new ProductFullViewPage();
	}
	
}
