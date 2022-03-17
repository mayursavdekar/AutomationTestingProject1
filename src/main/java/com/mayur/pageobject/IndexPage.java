package com.mayur.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

import com.mayur.base.BasePage;

public class IndexPage extends BasePage {
	@FindBy(linkText = "Sign in")
	WebElement signInLink;
	@FindBy(xpath = "//input[@name='search_query']")
	WebElement productSearchBox;
	@FindBy(xpath = "//button[@name='submit_search']")
	WebElement productSearchbtn;
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	public LoginAndRegistrationPage clickSignIn(){
      signInLink.click();
      return new LoginAndRegistrationPage();
	}
	public SearchProductResultPage searchProduct(String data) {
		productSearchBox.sendKeys(data);
		productSearchbtn.click();
		return new SearchProductResultPage();
	}
	
}
