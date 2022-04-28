package com.mayur.testcases;

import org.testng.annotations.Test;

import com.mayur.base.BasePage;
import com.mayur.pageobject.HomePage;
import com.mayur.pageobject.IndexPage;
import com.mayur.pageobject.LoginAndRegistrationPage;
import com.mayur.utility.Listerner;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
@Listeners(Listerner.class)
public class HomePageTest extends BasePage{
	IndexPage indexPage;
	LoginAndRegistrationPage loginAndRegistrationPage;
	HomePage homePage;
	Logger log;
	@BeforeMethod
	public void beforeMethod() {
		launchBrowser();
		log=Logger.getLogger(HomePageTest.class.getName());
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	@Test
	public void homeValidations() throws Exception {
		
		indexPage=new IndexPage();
		loginAndRegistrationPage = indexPage.clickSignIn();
		log.info("sign in clicked....");
		homePage = loginAndRegistrationPage.loginBeforeProductBuy(getData("username"), getData("password"));
		log.info("username and password entered...");
		boolean a1,a2,a3;
	    a1=homePage.validateOrderHistoryAndDetails();
		a2=homePage.validateMyWishlists();
		a3=homePage.validateSignOut();
		Assert.assertTrue(a1&&a2&&a3);
		Thread.sleep(2000);
		log.info("validations completed...");
	}
}
