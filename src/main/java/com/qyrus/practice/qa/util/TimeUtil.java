package com.qyrus.practice.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.qyrus.practice.qa.parent.PBase;

public class TimeUtil extends PBase{
	
	static Workbook wbook;
	static Sheet sheet;
	static Row row;
	static Cell cell;
	
	public TimeUtil() throws Exception {
		super();
	}

	public static long Page_Load_Timeout = 40;
	public static long Implicitly_Wait = 20;
	public static String TestData_Sheet_Path = "D:\\Selenium\\frameworkbuild\\src\\main\\java\\com\\qyrus\\practice\\qa\\testdata\\TestData.xlsx";
	
	public void switchToFrame() {
		driver.switchTo().frame(1);
	}
	
	public void screenShot(String path) throws Exception {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		FileHandler.copy(src, dest);
	}
	
	public static Object[][] getDataFromExcel(String sheetName) throws Exception{
		
		FileInputStream fis = new FileInputStream(TestData_Sheet_Path);
		wbook = WorkbookFactory.create(fis);
		sheet = wbook.getSheetAt(0);
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i<sheet.getLastRowNum(); i++) {
			for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				System.out.println(data[i][j]);
			}	
			
		}
		return data;	
	}
}
