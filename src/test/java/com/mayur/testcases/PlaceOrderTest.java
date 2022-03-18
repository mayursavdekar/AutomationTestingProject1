package com.mayur.testcases;

import org.testng.annotations.Test;

import com.mayur.base.BasePage;
import com.mayur.pageobject.Address;
import com.mayur.pageobject.HomePage;
import com.mayur.pageobject.IndexPage;
import com.mayur.pageobject.LoginAndRegistrationPage;
import com.mayur.pageobject.PaymentPage;
import com.mayur.pageobject.ProductFullViewPage;
import com.mayur.pageobject.SearchProductResultPage;
import com.mayur.pageobject.ShippingPage;
import com.mayur.pageobject.SummeryPage;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class PlaceOrderTest extends BasePage{
	Address address;
	@BeforeMethod
	public void beforeMethod() {
		launchBrowser();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	@Test
	public void placeOrder() throws Exception {
		IndexPage index = new IndexPage();
		LoginAndRegistrationPage loginAndRegistrationPage = index.clickSignIn();
		HomePage homePage = loginAndRegistrationPage.loginBeforeProductBuy(getData("username"), getData("password"));
		SearchProductResultPage searchProductResultPage = homePage.searchProduct("shoes");
		ProductFullViewPage productFullViewPage = searchProductResultPage.clickOnAvailableProduct();
		productFullViewPage.enterQuantity("2");
		productFullViewPage.selectSize("medium");
		productFullViewPage.clickAddToCart();
		Thread.sleep(3000);
		SummeryPage summeryPage = productFullViewPage.clickProceedToCheckout();
		Object obj = summeryPage.checkout();
		String pageTitle = driver.getTitle();
		if (pageTitle.equalsIgnoreCase("Login - My Store")) {
			loginAndRegistrationPage = (LoginAndRegistrationPage) obj;
			address = loginAndRegistrationPage.loginBetweenProductBuy("myproject@gmail.com", "myproject@123");
		} else {
			address = (Address) obj;
		}
		ShippingPage shippping = address.clickProceedToCheckOut();
		shippping.clickTermsAndConditionCheckbox();
		PaymentPage payment = shippping.clickProceedToCheckOut();
		payment.clickPayByBankWire();
	    payment.clickConfirmOrder();  
	    Assert.assertTrue(payment.validateOrderSuccessfullyPlaced());

	}


}
