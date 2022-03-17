package com.mayur.testcases;

import org.testng.annotations.Test;

import com.mayur.base.BasePage;
import com.mayur.pageobject.HomePage;
import com.mayur.pageobject.IndexPage;
import com.mayur.pageobject.LoginAndRegistrationPage;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class HomePageTest extends BasePage{
	IndexPage indexPage;
	LoginAndRegistrationPage loginAndRegistrationPage;
	HomePage homePage;
	@BeforeMethod
	public void beforeMethod() {
		launchBrowser();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	@Test
	public void homeValidations() throws Exception {
		indexPage=new IndexPage();
		
		loginAndRegistrationPage = indexPage.clickSignIn();
		homePage = loginAndRegistrationPage.loginBeforeProductBuy(getData("username"), getData("password"));
		boolean a1,a2,a3;
	    a1=homePage.validateOrderHistoryAndDetails();
		a2=homePage.validateMyWishlists();
		a3=homePage.validateSignOut();
		Assert.assertTrue(a1&&a2&&a3);
		Thread.sleep(2000);
	}
}
