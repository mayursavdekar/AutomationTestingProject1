package com.mayur.testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.mayur.base.BasePage;
import com.mayur.base.ExcelAPI;
import com.mayur.pageobject.HomePage;
import com.mayur.pageobject.IndexPage;
import com.mayur.pageobject.LoginAndRegistrationPage;
import com.mayur.utility.DataProviderForLogin;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTestWithDataProvider extends BasePage{
	ExcelAPI  excel;
	IndexPage indexPage;

	@BeforeMethod
	public void beforeMethod() {
		launchBrowser();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	
	@Test(dataProvider = "loginData",dataProviderClass = DataProviderForLogin.class)
	public void login(String username,String password,int i) throws Exception {
		excel=new ExcelAPI("C:\\Users\\Admin\\eclipse-workspace\\SeleniumProject\\testdata\\loginData.xlsx");
		indexPage = new IndexPage();
		LoginAndRegistrationPage loginAndRegistrationPage = indexPage.clickSignIn();
		Thread.sleep(2000);
		HomePage homePage = loginAndRegistrationPage.loginBeforeProductBuy(username, password);
		Thread.sleep(2000);
		if (driver.getCurrentUrl().equalsIgnoreCase("http://automationpractice.com/index.php?controller=my-account")) {
			homePage.clickSignOut();
			excel.setCellData("Sheet1",i,"result","PASS");
			Assert.assertTrue(true);
		}
		else {
			excel.setCellData("Sheet1",i,"result","FAIL");
			Assert.assertTrue(false);
		}
		
	}

}