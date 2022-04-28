package com.mayur.testcases;

import org.testng.annotations.Test;

import com.mayur.base.BasePage;
import com.mayur.base.ExcelAPI;
import com.mayur.pageobject.HomePage;
import com.mayur.pageobject.IndexPage;
import com.mayur.pageobject.LoginAndRegistrationPage;
import com.mayur.pageobject.RegistrationFormPage;
import com.mayur.utility.DataProviderClass;

import org.testng.annotations.BeforeMethod;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class RegistrationWithDataProvider extends BasePage{

	@BeforeMethod
	public void beforeMethod() {
		launchBrowser();
	}
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	@Test(dataProvider = "registrationData", dataProviderClass = DataProviderClass.class)
	public void regDP(HashMap mapData) throws Exception {
		IndexPage index = new IndexPage();
		LoginAndRegistrationPage loginAndRegistrationPage = index.clickSignIn();
		RegistrationFormPage registration = loginAndRegistrationPage
				.registration("ramesh" + getRandomNumber() + "@gmail.com");
		registration.selectGender(mapData.get("gender").toString());
		registration.enterFirstname(mapData.get("firstname").toString());
		registration.enterLastname(mapData.get("lastname").toString());
		registration.enterPassword(mapData.get("password").toString());
		registration.selectBirthDay(mapData.get("birthDay").toString());
		registration.selectBirthMonth(mapData.get("birthMonth").toString());
		registration.selectBirthYear(mapData.get("birthYear").toString());
		registration.checkBoxForNewsletter(mapData.get("newsletter_checkbox").toString());
		registration.checkBoxForReceiveSpecialOffer(mapData.get("receive_special_offer_checkbox").toString());
		Thread.sleep(3000);
	}
}
