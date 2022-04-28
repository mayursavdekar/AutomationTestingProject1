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
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class addToCartTest extends BasePage{
	ProductFullViewPage productFullViewPage;
	Logger log;
	@BeforeMethod
	public void beforeMethod() {
		launchBrowser();
		log=Logger.getLogger("addToCartTest");
	}
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
	@Test
	public void addToCart() throws Exception {
		IndexPage index=new IndexPage();
	    LoginAndRegistrationPage loginAndRegistrationPage = index.clickSignIn();
	    log.info("sign in clicked...");
	    HomePage homePage=loginAndRegistrationPage.loginBeforeProductBuy(getData("username"), getData("password"));	
	    log.info("username and password entered and clicked login....");
	    SearchProductResultPage searchProductResultPage = homePage.searchProduct("shoes");
	   log.info("data is entered in search product textbox....");
	    boolean result=searchProductResultPage.validateSearchResult();
	    log.info("data retrive for validation");
	    if (result) {
	    	productFullViewPage=searchProductResultPage.clickOnAvailableProduct();
	    	log.info("clicked on searched produc....t");
	    	productFullViewPage.enterQuantity("2");
	    	log.info("quantity entered...");
	    	productFullViewPage.selectSize("medium");
	    	log.info("size is selected...");
	    	productFullViewPage.clickAddToCart();
	    	log.info("add to cart clicked...");
	    	Thread.sleep(3000);
	    	boolean validation=productFullViewPage.validateAddedToCartSuccessfully();
	    	Assert.assertTrue(validation);
		}
	    else {
	    	     driver.navigate().back();
	    }
		}
}
