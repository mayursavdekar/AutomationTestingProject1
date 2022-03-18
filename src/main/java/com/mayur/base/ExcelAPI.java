package com.mayur.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelAPI {
	public FileInputStream fi = null;
	public FileOutputStream fo = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	String filepath;

	// constructor to initialize excel class
	public ExcelAPI(String file) throws Exception {
		this.filepath = file;
		fi = new FileInputStream(filepath);
		workbook = new XSSFWorkbook(fi);
		fi.close();
	}

	// reading cell data using colomn index
	public String getCellData(String sheetName, int rowNumber, int colomnNumber) {
		try {
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowNumber);
			cell = row.getCell(colomnNumber);
			if (cell.getCellType().name().equalsIgnoreCase("string")) {
				return cell.getStringCellValue();

			} else {
				double val = cell.getNumericCellValue();
				return String.valueOf(val);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "no matching value";
		}
	}

	// reading cell data using colomn name
	public String getCellData(String sheetName, int rowNumber, String colomnName) {
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);
		int colomnNumber = 0;
		for (int i = 0; i < row.getLastCellNum(); i++) {
			if (row.getCell(i).getStringCellValue().equalsIgnoreCase(colomnName)) {
				colomnNumber = i;
			}
		}
		row = sheet.getRow(rowNumber);
		cell = row.getCell(colomnNumber);
		if (cell.getCellType().name().equalsIgnoreCase("string")) {
			return cell.getStringCellValue();
		} else if (cell.getCellType().name().equalsIgnoreCase("numeric")) {
			double val = cell.getNumericCellValue();
			return String.valueOf(val);
		} else {
			System.out.println("invalid cell types");
			return null;
		}

	}

	// writing data in cell using colomn number
	public void setCellData(String sheetName, int rowNumber, int colomnNumber, String Data) throws Exception {
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNumber);
		if (row == null) {
			sheet.createRow(rowNumber);
		}
		cell = row.getCell(colomnNumber);
		if (cell == null) {
			cell = row.createCell(colomnNumber);
		}
		cell.setCellValue(Data);
		fo = new FileOutputStream(filepath);
		workbook.write(fo);
		fo.close();
	}

	// writing data in cell using colomn name
	public void setCellData(String sheetName, int rowNumber, String colomnName, String data) throws Exception {
		// here colomn number is used as per need
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);
		int resultColomnNumber = 0;
		for (int i = 0; i < row.getLastCellNum(); i++) {
			if (row.getCell(i).getStringCellValue().equalsIgnoreCase("result")) {
				resultColomnNumber = i;
			}
		}
		row = sheet.getRow(rowNumber);
		if (row == null) {
			row = sheet.createRow(rowNumber);
		}
		cell = row.getCell(resultColomnNumber);
		if (cell == null) {
			cell = row.createCell(resultColomnNumber);
		}
		cell.setCellValue(data);
		fo = new FileOutputStream(filepath);
		workbook.write(fo);
		fo.close();
	}

	// get number of rows counted from 1
	public int getNumberOfRows(String sheetName) {
		sheet = workbook.getSheet(sheetName);
		int rowNum = sheet.getLastRowNum()+1;
		return rowNum;

	}

	// get number of colomns in row 0
	public int getNumberOfColomns(String sheetName) {
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);
		int num = row.getLastCellNum();
		return num;
	}
	
	//get number of colomns in particular row counted from 1
	public int getNumberOfColomns(String sheetName,int rowNumber) {
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNumber);
		int num = row.getLastCellNum();
		return num;
	}

	// get cell type (we use this when we don't have cell and if we have cell then
	// we can use inbuilt method cell.getCellType().name() )
	public String getCellType(String sheetName, int rowNumber, int colomnNumber) {
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNumber);
		cell = row.getCell(colomnNumber);
		String var = cell.getCellType().name();
		return var;
	}
}
