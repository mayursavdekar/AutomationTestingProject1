package com.mayur.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mayur.base.BasePage;

public class HomePage extends BasePage {

	@FindBy(xpath = "//a[@class='logout']")
	WebElement logOutLink;
	@FindBy(xpath = "//span[text()='Order history and details']")
	WebElement orderHistoryAndDetails;
	@FindBy(xpath = "//span[text()='My wishlists']")
	WebElement myWishlists;
	@FindBy(xpath = "//input[@name='search_query']")
	WebElement productSearchBox;
	@FindBy(xpath = "//button[@name='submit_search']")
	WebElement productSearchbtn;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateOrderHistoryAndDetails() {
		if (orderHistoryAndDetails.isDisplayed()) {
			return true;
		} else {
			return false;
		}

	}

	public boolean validateMyWishlists() {
		if (myWishlists.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validateSignOut() {
		if (logOutLink.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	public void clickSignOut() throws Exception {
		logOutLink.click();
	}
	public SearchProductResultPage searchProduct(String data) {
		productSearchBox.sendKeys(data);
		productSearchbtn.click();
		return new SearchProductResultPage();
	}
}
