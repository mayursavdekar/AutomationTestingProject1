package com.mayur.testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.mayur.base.BasePage;
import com.mayur.base.ExcelAPI;
import com.mayur.pageobject.HomePage;
import com.mayur.pageobject.IndexPage;
import com.mayur.pageobject.LoginAndRegistrationPage;
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
	
	@Test(dataProvider = "loginData")
	public void login(String username,String password,int i) throws Exception {
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
  @DataProvider(name="loginData")
	public Object [][] loginData() throws Exception {

		excel=new ExcelAPI("C:\\Users\\Admin\\eclipse-workspace\\SeleniumProject\\testdata\\loginData.xlsx");
		int rows = excel.getNumberOfRows("Sheet1");
		System.out.println(rows);
		int colomn = excel.getNumberOfColomns("Sheet1");
		System.out.println(colomn);
		Object [][] str=new Object[rows-1][colomn];
       int ro=0;
		for(int i=1;i<rows;i++) {
			ro=i;
			for(int j=0;j<=colomn;j++) {
				if(j==0) {
					String username = excel.getCellData("Sheet1", i, "username");
					System.out.println(username);
					str[i-1][j]=username;
					str[i-1][2]=i;
				}
				else if(j==1) {
					String password = excel.getCellData("Sheet1", i, "password");
					System.out.println(password);
					str[i-1][j]=password;
					str[i-1][2]=i;
				}		
			}
		}	
		for(int i=0;i<str.length;i++) {
			for(int j=0;j<str[i].length;j++) {
				System.out.printf(""+str[i][j] +".........");
			}
			System.out.println("");
		}
		return str;
	}
}