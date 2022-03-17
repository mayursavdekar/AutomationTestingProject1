package com.mayur.testcases;

import org.testng.annotations.Test;

import com.mayur.base.BasePage;
import com.mayur.base.ExcelAPI;

public class ForTest extends BasePage {
	@Test
	public void f() throws Exception {
		String data = getData("username");
		System.out.println(data);

		ExcelAPI excel=new ExcelAPI("C:\\Users\\Admin\\eclipse-workspace\\SeleniumProject\\testdata\\book.xlsx");
		String cellData = excel.getCellData("Sheet1", 0, 0);
		System.out.println(cellData);
		excel.setCellData("Sheet1", 9,"abc", "Data");
	}
}
