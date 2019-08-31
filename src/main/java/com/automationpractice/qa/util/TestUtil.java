package com.automationpractice.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.automationpractice.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static String TestDataPath=System.getProperty("user.dir")+ "/src/main/java/com/automationpractice"
			+ "/qa/testdata/TestData.xlsx";
	static Workbook workbook;
	static Sheet sheet;
	static Cell cell;
	static Row row;
	static Logger log = Logger.getLogger(TestUtil.class);
	
	public static void takeScreenshot() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + "Success Screenshot_" + System.currentTimeMillis() + ".png"));
	}
	
	public static Object[][] getTestData(String sheetName){
		
		FileInputStream input=null;
		try {
			 input=new FileInputStream(TestDataPath);
			 log.info("Loading Properties file");
						
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		try {
			workbook=WorkbookFactory.create(input);
		} catch (InvalidFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
		
			log.error("Unable to load Excel file");
			e.printStackTrace();
		}
		sheet=workbook.getSheet(sheetName);
		log.info("Data in Excel:");
		Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) 
		{
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) 
			{
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				
				System.out.println(data[i][k]);
			}
		}
		return data;
				
	}
}
