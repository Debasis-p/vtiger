package com.crm.Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritingDataInExcel {
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis= new FileInputStream("./src/test/resources/testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet("SDET33").getRow(1).getCell(1).setCellValue("pass");
		wb.getSheet("SDET33").getRow(1).createCell(2).setCellValue("Sucess");
		
		
		FileOutputStream fos= new FileOutputStream("./src/test/resources/testData.xlsx");
		System.out.println("Data stored sucessfully");
		wb.write(fos);
		wb.close();
		
	}

}
