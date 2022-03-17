package com.mayur.testcases;

import org.testng.annotations.Test;

import com.mayur.base.BasePage;
import com.mayur.pageobject.IndexPage;
import com.mayur.pageobject.SearchProductResultPage;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class ProductSearchTest extends BasePage {

	@BeforeMethod
	public void beforeMethod() {
		launchBrowser();
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

	@Test
	public void productSearch() throws Exception {
		IndexPage index=new IndexPage();
		SearchProductResultPage searchProductResultPage = index.searchProduct("shirts");
		Thread.sleep(3000);
	    boolean result = searchProductResultPage.validateSearchResult();
	    Assert.assertTrue(result);
	}

}
