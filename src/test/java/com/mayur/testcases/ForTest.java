package com.mayur.testcases;

import java.io.FileInputStream;
import java.util.HashMap;

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
@Listeners(com.mayur.utility.Listerner.class)
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
	public void f() throws Exception {
	   FileInputStream fi=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\SeleniumProject\\testdata\\loginData.xlsx");
	   XSSFWorkbook wb=new XSSFWorkbook(fi);
	   XSSFSheet sheet=wb.getSheet("Sheet1"); 
	   System.out.println("last row no :- "+sheet.getLastRowNum()); 
	   XSSFRow row= sheet.getRow(0);
	   System.out.println("no of cells :- "+row.getLastCellNum());
	   HashMap map=new HashMap ();
	}

}
