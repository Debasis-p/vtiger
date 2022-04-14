package com.crm.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel {
	
	public static void main(String[] args) throws IOException {
		FileInputStream fis= new FileInputStream("./src/test/resources/testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet("SDET33").getRow(1).getCell(0).getStringCellValue();
		System.out.println(data);
		
	}

}
