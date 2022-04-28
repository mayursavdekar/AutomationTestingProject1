package com.mayur.testcases;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mayur.base.BasePage;
import com.mayur.base.ExcelAPI;
public class ForTest extends BasePage {
	@BeforeMethod
	public void start(){
		launchBrowser();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void reg() throws Exception {
	  System.out.println("test success....");
	
	}

}
