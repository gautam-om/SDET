package com.crm.genericUnit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getFromDataExcel(String sheetName, int rownum, int cellnum) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstant.EXCELFILEPATH); 
		Workbook wk = WorkbookFactory.create(fis);
		Sheet sheet = wk.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String value = cell.getStringCellValue();
	     return value;
			
	}
	
//	public String getFromDataExcel(String sheetName, String tcid, String header) throws Throwable
//	{
//		
//		FileInputStream fis = new FileInputStream("./data/Details.xlsx");
//		Workbook wk = WorkbookFactory.create(fis);
//		Sheet sheet = wk.getSheet(sheetName);
//		int lrow = sheet.getLastRowNum();
//		int excetedRow = 0;
//	}

}
