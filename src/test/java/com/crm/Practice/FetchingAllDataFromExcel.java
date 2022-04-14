package com.crm.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingAllDataFromExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream("./src/test/resources/testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("test");
		
		for(int i=1; i<=sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			for(int j=0; j<row.getLastCellNum();j++) {
				String data = row.getCell(j).getStringCellValue();
				System.out.print(data+" ");
			}
			System.out.println();
		}
		
	}

}
