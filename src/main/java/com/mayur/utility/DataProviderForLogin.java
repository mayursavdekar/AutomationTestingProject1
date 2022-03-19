package com.mayur.utility;

import org.testng.annotations.DataProvider;

import com.mayur.base.ExcelAPI;

public class DataProviderForLogin {
	ExcelAPI excel;
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
