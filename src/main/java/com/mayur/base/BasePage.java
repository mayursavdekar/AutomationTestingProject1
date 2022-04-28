package com.mayur.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	public static WebDriver driver;
	String propertiesFilePath=System.getProperty("user.dir")+"/configurations/config.properties";
	//"./configurations/config.properties";
	public String url;
	public String log4jpath="./configurations/log4j.properties";

	//launching browser 
	public void launchBrowser() {
		String browsername = getData("browser");
		this.url= getData("url");
		if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium library\\chromedriver1.exe");
			driver = new ChromeDriver();	
		}
		if (browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium library\\geckodriver.exe");
			driver = new FirefoxDriver();
			//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		PropertyConfigurator.configure(log4jpath);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
	}

	// reading data from properties file using key
	public String getData(String key) {
		try {
			File file=new File(propertiesFilePath);
			FileInputStream fi=new FileInputStream(file);
			Properties properties=new Properties();
			properties.load(fi);
			return properties.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	//select by value reusable method
	public void selectByValue(WebElement element ,String value){
		Select select= new Select(element);
		select.selectByValue(value);
	}

	//select by visible-text reusable method
	public void selectByVisibleText(WebElement element ,String visibleText){
		Select select= new Select(element);
		select.selectByVisibleText(visibleText);
	}

	//generate random number
	public int getRandomNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(9999);
		return randomNumber;
	}
}
