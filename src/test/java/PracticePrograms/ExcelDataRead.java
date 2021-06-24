package PracticePrograms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelDataRead 
{
  public static void main(String[] args) throws Throwable
  {
	  FileInputStream fis = new FileInputStream("./data/Details.xlsx");
	  
	  Workbook wb = WorkbookFactory.create(fis);
	  Sheet sheet = wb.getSheet("Sheet1");
	  Row rw = sheet.getRow(2);
	  Cell cl = rw.getCell(1);
	  String value = cl.getStringCellValue();
	  System.out.println(value);
			   
  }
} 
