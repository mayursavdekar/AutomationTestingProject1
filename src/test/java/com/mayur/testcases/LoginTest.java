package com.mayur.testcases;

import org.testng.annotations.Test;

import com.mayur.base.BasePage;
import com.mayur.base.ExcelAPI;
import com.mayur.pageobject.HomePage;
import com.mayur.pageobject.IndexPage;
import com.mayur.pageobject.LoginAndRegistrationPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.AfterMethod;

public class LoginTest extends BasePage {
	IndexPage indexPage;
	ExcelAPI excel;
	LoginAndRegistrationPage loginAndRegistrationPage;
	@BeforeMethod
	public void beforeMethod() {
		launchBrowser();
	}
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
	@Test
	public void login() throws Exception {
		indexPage = new IndexPage();
		excel = new ExcelAPI("C:\\Users\\Admin\\eclipse-workspace\\SeleniumProject\\testdata\\loginData.xlsx");
		for (int i = 1; i <= excel.getNumberOfRows("Sheet1"); i++) {
			String username = excel.getCellData("Sheet1", i, "username");
			String password = excel.getCellData("Sheet1", i, "password");
			loginAndRegistrationPage = indexPage.clickSignIn();
			HomePage homePage = loginAndRegistrationPage.loginBeforeProductBuy(username, password);
			Thread.sleep(2000);
			String actualURL = driver.getCurrentUrl();
			String actualTitle=driver.getTitle();
			String expectedURL = "http://automationpractice.com/index.php?controller=my-account";
			String expectedTitle="My account - My Store";
			if (actualTitle.equalsIgnoreCase(expectedTitle)&&actualURL.equalsIgnoreCase(expectedURL)) {
				if (homePage.validateSignOut()) {
					homePage.clickSignOut();
					excel.setCellData("Sheet1", i, "result", "PASS");
				}
				else {
					excel.setCellData("Sheet1", i, "result", "FAIL");
					driver.navigate().to(url);
				}
			}
			else {
				excel.setCellData("Sheet1", i, "result", "FAIL");
				driver.navigate().to(url);
			}
		}
	}
}


