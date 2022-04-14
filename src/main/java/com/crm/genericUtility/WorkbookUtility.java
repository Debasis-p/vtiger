package com.crm.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;

/**
 * This class is used to perform operation related to excel file
 * @author Deb
 *
 */
public class WorkbookUtility {
	
		static Workbook wb=null;
		
		/**
		 * This method is used to open the excel file 
		 * @param file path
		 */
		public static void openExcel(String path) {
			try {
				FileInputStream fis= new FileInputStream(path);
				try {
					Reporter.log("Excel opened sucessfully", true);
					wb = WorkbookFactory.create(fis);
				} catch (EncryptedDocumentException e) {
					e.printStackTrace();
					System.out.println("The file is encrypted");
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("IO Exception");
				} 
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("File not found in the specified path");
			}			
		}
		
		/**
		 * This method is used to close the excel file
		 */
		public static void closeExcel() {
			try {
				Reporter.log("Excel closed successfully", true);
				wb.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("IO Exception");
			}			
		}
		
		/**
		 * This method is used to fetch data from excel file
		 * @param sheetName
		 * @param rowNum
		 * @param cellNum
		 * @return cell data
		 */
		public static String getData(String sheetName, int rowNum, int cellNum) {
			String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).toString();
			return data;	
		}
		
		/**
		 * This method is used to fetch multiple data from excel file
		 * @param sheetName
		 * @param rowNum
		 * @param cellNum
		 * @return
		 */
		public static Object[][] getMultiData(String sheetName) {
			
			Sheet sh = wb.getSheet(sheetName);
			Object[][] arr= new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
			for(int r=0; r<sh.getLastRowNum(); r++) {
				for(int c=0; c<sh.getRow(r).getLastCellNum(); c++) {
					arr[r][c]= sh.getRow(r+1).getCell(c).toString();
				}
			}
			return arr;	
		}
		
		
		/**
		 * This method is used to input the data to a existing cell
		 * @param sheetName
		 * @param rowNum
		 * @param cellNum
		 * @param cellValue
		 * @param outputPath
		 */
		public static void writeDataToExistingCell(String sheetName, int rowNum, int cellNum, String cellValue, String outputPath) {
			wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(cellValue);
			FileOutputStream fos=null;
			try {
				fos= new FileOutputStream(outputPath);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("Specified file not found");
			}
			try {
				Reporter.log("Data inserted sucessfully to excel sheet", true);
				wb.write(fos);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("IO Exception");
			}
		}
		
		/**
		 * This method is used to input data into a new cell
		 * @param sheetName
		 * @param rowNum
		 * @param cellNum
		 * @param cellValue
		 * @param outputPath
		 */
		public static void writeDataToNewCell(String sheetName,int rowNum, int cellNum, String cellValue, String outputPath) {
			wb.getSheet(sheetName).createRow(rowNum).createCell(cellNum).setCellValue(cellValue);
			FileOutputStream fos= null;
			try {
				fos= new FileOutputStream(outputPath);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("File not found in the specified path");
			}
			try {
				Reporter.log("Data inserted sucessfully to excel sheet", true);
				wb.write(fos);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("IO Exception");
			}			
		}

}
