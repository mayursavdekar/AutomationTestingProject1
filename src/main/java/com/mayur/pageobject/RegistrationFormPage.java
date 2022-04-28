package com.mayur.pageobject;

import java.util.ArrayList;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mayur.base.BasePage;

public class RegistrationFormPage extends BasePage {
    @FindBy(xpath = "//label[contains(text(),'Title')]")
    WebElement titleTextForGender;
	@FindBy(xpath = "//input[@id='id_gender1']") 
	WebElement genderSelectMale;
	@FindBy(xpath = "//input[@id='id_gender2']") 
	WebElement genderSelectFemale;
	@FindBy(xpath = "//input[@id='customer_firstname']")
	WebElement firstNameTextbox;
	@FindBy(xpath = "//input[@id='customer_lastname']")
	WebElement lastNameTextbox;
	@FindBy(xpath = "//input[@id='passwd']")
	WebElement passwordTextbox;
	@FindBy(xpath = "//select[@id='days']")
	WebElement birthDay;
	@FindBy(xpath = "//select[@id='months']")
	WebElement birthMonth;
	@FindBy(xpath = "//select[@id='years']")
	WebElement birthYear;
	@FindBy(xpath = "//input[@id='newsletter']")
	WebElement checkboxNewsletter;
	@FindBy(xpath = "//input[@id='optin']")
	WebElement checkBoxReceiveSpecialOffer;
	@FindBy(xpath = "//input[@id='firstname']")
	WebElement addressFirstname;
	@FindBy(xpath = "//input[@id='lastname']")
	WebElement addressLastname;
	@FindBy(xpath = "//input[@id='company']")
	WebElement Company;
	@FindBy(xpath = "//input[@id='address1']")
	WebElement address1;
	@FindBy(xpath = "//input[@id='address2']")
	WebElement address2;
	@FindBy(xpath = "//input[@id='city']")
	WebElement addressCity;
	@FindBy(xpath = "//select[@id='id_state']")
	WebElement addressState;
	@FindBy(xpath = "//input[@id='postcode']")
	WebElement addressZipcode;
	@FindBy(xpath = "//select[@id='id_country']")
	WebElement addressCountry;
	@FindBy(xpath = "//textarea[@id='other']")
	WebElement addressAdditionalInfo;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement homePhoneNumber;
	@FindBy(xpath = "//input[@id='phone_mobile']")
	WebElement mobilePhoneNumber;
	@FindBy(xpath = "//input[@id='alias']")
	WebElement addressAlias;
	@FindBy(xpath = "//button[@id='submitAccount']")
	WebElement registerBtn;

	public RegistrationFormPage() {
		PageFactory.initElements(driver,this);
	}
	public void selectGender(String gender) {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(titleTextForGender));
		if(gender.equalsIgnoreCase("male")) {
			genderSelectMale.click();
		}
		else if (gender.equalsIgnoreCase("female")) {
			genderSelectFemale.click();
		}
		else {
			System.out.println("invalid gender");
		}
	}
	public void enterFirstname(String firstname) {
		firstNameTextbox.sendKeys(firstname);
	}
	public void enterLastname(String lastname) {
		lastNameTextbox.sendKeys(lastname);
	}
	public void enterPassword(String password) {
		passwordTextbox.sendKeys(password);
	}

	public void selectBirthDay(String day){
		String[] var = day.split("\\.");
		selectByValue(birthDay, var[0]);
	}
	public void selectBirthMonth(String month){
		String []var=month.split("\\.");
		selectByValue(birthMonth, var[0]);
	}
	public void selectBirthYear(String year){
		String[] var=year.split("\\.");
		selectByValue(birthYear, var[0]);
	}
	public void checkBoxForNewsletter(String data) {
		if (data.equalsIgnoreCase("yes")) {
			checkboxNewsletter.click();	
		}		
	}
	public void checkBoxForReceiveSpecialOffer(String data){
		if (data.equalsIgnoreCase("yes")) {
			checkBoxReceiveSpecialOffer.click();
		}
	}
	public void enterCompany(String name) {
		Company.sendKeys(name);
	}
	public void enterAddress1(String address) {
		address1.sendKeys(address);
	}
	public void enterAddress2(String address) {
		address2.sendKeys(address);
	}
	public void enterAddressCity(String city) {
		addressCity.sendKeys(city);
	}
	public void selectStateByName(String state) {
		selectByVisibleText(addressState, state);
	}
	public void enterZipzode(String zipcode) {
		String[] var=zipcode.split("\\.");
		addressZipcode.sendKeys(var[0]);
	}
	public void selectCountry(String country) {
		selectByVisibleText(addressCountry, country);
	}
	public void enterAddressAdditionalInfo(String info) {
		addressAdditionalInfo.sendKeys(info);
	}
	public void homePhoneNumber(String number) {
		homePhoneNumber.sendKeys(number);
	}
	public void mobilePhoneNumber(String number) {
		String[] var = number.split("\\.");
		mobilePhoneNumber.sendKeys(var[0]);
	}
	public void enterAliasAddress(String address){
		addressAlias.sendKeys(address);
	}
	public HomePage clickRegisterBtn() {
		registerBtn.click();
		return new HomePage();
	}
}
