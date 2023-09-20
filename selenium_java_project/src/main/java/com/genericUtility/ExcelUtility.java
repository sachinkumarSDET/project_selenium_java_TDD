package com.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	
	public String readData_Excel(String filePath, String sheetName, int row, int column) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(filePath);
		String cellValue =  WorkbookFactory.create(fis).getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		fis.close();
		return cellValue;
	}
	
	public int rowCount_Excel(String filePath, String sheetName, int row) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(filePath);
		int rowCount = WorkbookFactory.create(fis).getSheet(sheetName).getLastRowNum();
		fis.close();
		return rowCount;
	}
	
	public int cellCount_Excele(String filePath, String sheetName, int row) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(filePath);
		int cellCount = WorkbookFactory.create(fis).getSheet(sheetName).getRow(row).getLastCellNum();
		fis.close();
		return cellCount;
	}
	
	public void writeData_into_Excel(String filePath, String sheetName, int row, int cell, String cellValue) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(filePath);
		Workbook workbook = WorkbookFactory.create(fis);
		 Sheet sheet = workbook.createSheet(sheetName);
		 sheet.createRow(row++).createCell(cell).setCellValue(cellValue);
	}
	
	public Map<String, String> map_readData_Excel(String filePath, String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(filePath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		int totalRow = sheet.getLastRowNum();
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i <= totalRow; i++) {
			String key = sheet.getRow(i).getCell(0).getStringCellValue();
			String value = sheet.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}
}
