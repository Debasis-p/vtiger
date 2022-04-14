package com.crm.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingReqDataFromExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fis= new FileInputStream("./src/test/resources/testData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet("test");
	for(int i=1; i<=sheet.getLastRowNum();i++) {
		String rwData = sheet.getRow(i).getCell(0).getStringCellValue();
		if(rwData.equals("admin13")) {
			String cellData = sheet.getRow(i).getCell(1).getStringCellValue();
			System.out.println("password--> "+cellData);
			
		}
		
	}
	}

}
