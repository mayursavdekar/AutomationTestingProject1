package com.mayur.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mayur.base.BasePage;

public class LoginAndRegistrationPage extends BasePage {
	@FindBy(xpath = "//input[@name='email_create']")
	WebElement registrationEmailTextbox;
	@FindBy(xpath = "//button[@name='SubmitCreate']")
	WebElement registrationSubmitbtn;
	@FindBy(xpath = "//input[@id='email']")
	WebElement signInEmailTextbox;
	@FindBy(xpath = "//input[@id='passwd']")
	WebElement signInPasswordTextbox;
	@FindBy(xpath = "//button[@name='SubmitLogin']")
	WebElement signInbtn;
	public LoginAndRegistrationPage() {
		PageFactory.initElements(driver, this);
	}
	public HomePage loginBeforeProductBuy(String username,String password) throws Exception{
		signInEmailTextbox.sendKeys(username);
		signInPasswordTextbox.sendKeys(password);
		signInbtn.click();
		return new HomePage();
	}
	public RegistrationFormPage registration(String email) throws Exception {
		registrationEmailTextbox.sendKeys(email);
		registrationSubmitbtn.click();
		return new RegistrationFormPage();
	}
	public Address loginBetweenProductBuy(String username,String password) throws Exception{
		signInEmailTextbox.sendKeys(username);
		signInPasswordTextbox.sendKeys(password);
		signInbtn.click();
		Thread.sleep(3000);
		return new Address();
	}
}
