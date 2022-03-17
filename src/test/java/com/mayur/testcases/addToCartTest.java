package com.mayur.testcases;

import org.testng.annotations.Test;

import com.mayur.base.BasePage;
import com.mayur.pageobject.HomePage;
import com.mayur.pageobject.IndexPage;
import com.mayur.pageobject.LoginAndRegistrationPage;
import com.mayur.pageobject.ProductFullViewPage;
import com.mayur.pageobject.SearchProductResultPage;
import com.mayur.utility.Listerner;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
@Listeners(com.mayur.utility.Listerner.class)
public class addToCartTest extends BasePage{
	ProductFullViewPage productFullViewPage;
	@BeforeMethod
	public void beforeMethod() {
		launchBrowser();
	}
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
	@Test
	public void addToCart() throws Exception {
		IndexPage index=new IndexPage();
	    LoginAndRegistrationPage loginAndRegistrationPage = index.clickSignIn();
	    HomePage homePage=loginAndRegistrationPage.loginBeforeProductBuy(getData("username"), getData("password"));	
	    SearchProductResultPage searchProductResultPage = homePage.searchProduct("shoes");
	    boolean result=searchProductResultPage.validateSearchResult();
	    if (result) {
	    	productFullViewPage=searchProductResultPage.clickOnAvailableProduct();
	    	productFullViewPage.enterQuantity("2");
	    	productFullViewPage.selectSize("medium");
	    	productFullViewPage.clickAddToCart();
	    	Thread.sleep(3000);
	    	boolean validation=productFullViewPage.validateAddedToCartSuccessfully();
	    	Assert.assertTrue(validation);
		}
	    else {
	    	     driver.navigate().back();
	    }
		}
}
