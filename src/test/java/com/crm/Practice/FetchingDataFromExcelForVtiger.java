
package com.crm.Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchingDataFromExcelForVtiger {

	public static void main(String[] args) throws IOException {
		FileInputStream fis= new FileInputStream("./src/test/resources/testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String url = wb.getSheet("Vtiger").getRow(1).getCell(0).getStringCellValue();
		String un = wb.getSheet("Vtiger").getRow(1).getCell(1).getStringCellValue();
		String pwd = wb.getSheet("Vtiger").getRow(1).getCell(2).getStringCellValue();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
		
		wb.getSheet("Vtiger").getRow(1).createCell(3).setCellValue("pass");
		
		FileOutputStream fos= new FileOutputStream("./src/test/resources/testData.xlsx");
		wb.write(fos);
		wb.close();
		
		
		driver.quit();
		
		
		
		
	}
	
}
