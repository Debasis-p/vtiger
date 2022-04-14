package com.crm.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingMutliDataFromExcel {
	public static void main(String[] args) throws IOException {
		FileInputStream fis= new FileInputStream("./src/test/resources/testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("test");
		
		for(int i=1; i<=sheet.getLastRowNum(); i++) {
		String admin= sheet.getRow(i).getCell(0).getStringCellValue();
		String pass = sheet.getRow(i).getCell(1).getStringCellValue();
		System.out.println(admin+"----"+pass);
	}
		wb.close();

}
}