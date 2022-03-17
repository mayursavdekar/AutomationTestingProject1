package com.mayur.testcases;

import org.testng.annotations.Test;

import com.mayur.base.BasePage;
import com.mayur.base.ExcelAPI;
import com.mayur.pageobject.HomePage;
import com.mayur.pageobject.IndexPage;
import com.mayur.pageobject.LoginAndRegistrationPage;
import com.mayur.pageobject.RegistrationFormPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import java.awt.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import org.apache.poi.xssf.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class CreateAccountTest extends BasePage {
	FileInputStream fi;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow rowRegistration, row0;
	XSSFCell cell;
	String cellValue;
	ExcelAPI excel;
	HashMap<String, String> map;

	@BeforeMethod
	public void beforeMethod() {
		launchBrowser();

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	//
	//	@Ignore
	//	@Test(description = "This test implemented without using ExcelAPI")
	//	public void register() throws Exception {

	// receiving data from excel file
	// fi = new
	// FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\SeleniumProject\\testdata\\registration.xlsx");
	// wb = new XSSFWorkbook(fi);
	// sheet = wb.getSheet("Sheet1");
	// row0 = sheet.getRow(0);
	// rowRegistration = sheet.getRow(1);

	//		// sending data to RegistrationFormPage for registration vai arraylist
	//		IndexPage index = new IndexPage();
	//		LoginAndRegistrationPage loginAndRegistrationPage = index.clickSignIn();
	//		Thread.sleep(3000);
	//		RegistrationFormPage reg = loginAndRegistrationPage.registration("plmokn@gmail.com");
	//		HashMap<String, String> map = new HashMap<String, String>();
	//		for (int i = 0; i < row0.getLastCellNum(); i++) {
	//			if (rowRegistration.getCell(i).getCellType().name().equalsIgnoreCase("string")) {
	//				map.put(row0.getCell(i).getStringCellValue(), rowRegistration.getCell(i).getStringCellValue());
	//			} else if (rowRegistration.getCell(i).getCellType().name().equalsIgnoreCase("numeric")) {
	//				String stringVal = String.valueOf(rowRegistration.getCell(i).getNumericCellValue());
	//				System.out.println("***string value is = " + stringVal);
	//				String[] vals = stringVal.split("\\.");
	//				System.out.println("***final string value entered in map is :- " + vals[0]);
	//				map.put(row0.getCell(i).getStringCellValue(), vals[0]);
	//			}
	//
	//		}
	//		reg.register(map);
	//	}
	//
	//	@Ignore
	//	@Test(description = "This test implemented using ExcelAPI")
	//	public void registerNewVersion1() throws Exception {
	//
	//		// get data of excel using excelAPI and store it in map
	//		excel = new ExcelAPI("C:\\Users\\Admin\\eclipse-workspace\\SeleniumProject\\testdata\\registration.xlsx");
	//		map = new HashMap<String, String>();
	//		for (int i = 0; i < excel.getNumberOfColomns("Sheet1"); i++) {
	//			if (excel.getCellType("Sheet1", 1, i).equalsIgnoreCase("string")) {
	//				String key = excel.getCellData("Sheet1", 0, i);
	//				String value = excel.getCellData("Sheet1", 1, i);
	//				map.put(key, value);
	//			} else if (excel.getCellType("Sheet1", 1, i).equalsIgnoreCase("numeric")) {
	//				String key = excel.getCellData("Sheet1", 0, i);
	//				String value = excel.getCellData("Sheet1", 1, i);
	//				String[] newVal = value.split("\\.");
	//				map.put(key, newVal[0]);
	//			}
	//		}
	//		// go step by step to register and pass map to registerFormPage
	//		IndexPage index = new IndexPage();
	//		LoginAndRegistrationPage loginAndRegistrationPage = index.clickSignIn();
	//		RegistrationFormPage reg = loginAndRegistrationPage.registration("plmokn@gmail.com");
	//		Thread.sleep(2000);
	//		System.out.println(map.get("gender"));
	//		reg.register(map);
	//	}
	//
	//	@Test(description = "This test implemented using ExcelAPI we can test multiple registration data   ")
	//	public void registerNewVersion2() throws Exception {
	//
	//		// go step by step to register and pass map to registerFormPage
	//		for (int i = 1; i <3 ; i++) {
	//			// temp(i) is method decleared below for excel data fetching
	//			temp(i);
	//			IndexPage index = new IndexPage();
	//			LoginAndRegistrationPage loginAndRegistrationPage = index.clickSignIn();
	//			Thread.sleep(3000);
	//			RegistrationFormPage reg = loginAndRegistrationPage
	//					.registration("ramesh" + getRandomNumber() + "@gmail.com");
	//			Thread.sleep(2000);
	//			System.out.println(map.get("gender"));
	//			HomePage homePage = reg.register(map);
	//			Thread.sleep(3000);
	//			boolean check = homePage.signOut();
	//			if (check) {
	//				excel.setCellData("Sheet1", i, "result", "PASS");
	//			} else {
	//				excel.setCellData("Sheet1", i, "result", "FAIL");
	//			}
	//			driver.navigate().to(url);
	//		}
	//	}
	//
	//	// this method is for get row wise data from excel file
	//	public void temp(int rowNum) throws Exception {
	//		// get data of excel using excelAPI and store it in map
	//		excel = new ExcelAPI("C:\\Users\\Admin\\eclipse-workspace\\SeleniumProject\\testdata\\registration.xlsx");
	//		map = new HashMap<String, String>();
	//		for (int i = 0; i < excel.getNumberOfColomns("Sheet1") - 1; i++) {
	//			if (excel.getCellType("Sheet1", rowNum, i).equalsIgnoreCase("string")) {
	//				String key = excel.getCellData("Sheet1", 0, i);
	//				String value = excel.getCellData("Sheet1", rowNum, i);
	//				map.put(key, value);
	//			} else if (excel.getCellType("Sheet1", rowNum, i).equalsIgnoreCase("numeric")) {
	//				String key = excel.getCellData("Sheet1", 0, i);
	//				String value = excel.getCellData("Sheet1", rowNum, i);
	//				String[] newVal = value.split("\\.");
	//				map.put(key, newVal[0]);
	//				for (int k = 0; k < newVal.length; k++) {
	//					System.out.println(newVal[k]);
	//				}
	//			}
	//		}
	//		System.out.println("Map is :-  " + map);
	//	}
	@Test
	public void createAccountNew1() throws Exception {
		ExcelAPI excel=new ExcelAPI("C:\\Users\\Admin\\eclipse-workspace\\SeleniumProject\\testdata\\registration.xlsx");
		for(int i=1;i<=excel.getNumberOfRows("Sheet1");i++) {
			IndexPage index = new IndexPage();
			LoginAndRegistrationPage loginAndRegistrationPage = index.clickSignIn();
			RegistrationFormPage registration = loginAndRegistrationPage
					.registration("ramesh" + getRandomNumber() + "@gmail.com");
			Thread.sleep(2000);

			registration.selectGender(excel.getCellData("Sheet1", i ,"gender" ));
			registration.enterFirstname(excel.getCellData("Sheet1", i,"firstname"));
			registration.enterLastname(excel.getCellData("Sheet1", i,"lastname"));
			registration.enterPassword(excel.getCellData("Sheet1", i,"password"));
			registration.selectBirthDay(excel.getCellData("Sheet1", i,"birthday"));
			registration.selectBirthMonth(excel.getCellData("Sheet1", i,"birthmonth"));
			registration.selectBirthYear(excel.getCellData("Sheet1", i,"birthyear"));
			registration.enterCompany(excel.getCellData("Sheet1", i,"company"));
			registration.enterAddress1(excel.getCellData("Sheet1", i,"address"));
			registration.enterAddressCity(excel.getCellData("Sheet1", i,"city"));
			registration.selectStateByName(excel.getCellData("Sheet1", i,"state"));
			registration.enterZipzode(excel.getCellData("Sheet1", i,"zipcode"));
			registration.selectCountry(excel.getCellData("Sheet1", i,"country"));
			registration.mobilePhoneNumber(excel.getCellData("Sheet1", i,"mobile"));
			registration.enterAliasAddress(excel.getCellData("Sheet1", i,"alias"));
			HomePage homePage = registration.clickRegisterBtn();
			Thread.sleep(3000);
			String expectedTitle="My account - My Store";
			String actualTitle=driver.getTitle();
			String expectedURL="http://automationpractice.com/index.php?controller=my-account";
			String actualURL=driver.getCurrentUrl();
			if (actualTitle.equalsIgnoreCase(expectedTitle)&& actualURL.equalsIgnoreCase(expectedURL)) {
				boolean result=homePage.validateSignOut();
				if (result) {
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
