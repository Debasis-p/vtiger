package com.crm.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchDataFromDB {
	


	public static void main(String[] args) throws SQLException {
		Connection connection= null;
		String url=null;
		String username= null;
		String password = null;
		String lastname= null;
		String expRes= " vtiger";

		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet33", "root", "root");
			Statement statement= connection.createStatement();
			ResultSet result= statement.executeQuery("select * from vtiger;");
			while(result.next()) {
				url = result.getString(1);
				username = result.getString(2);
				password = result.getString(3);
				lastname = result.getString(4);
			}
			
			
			
			WebDriverManager.chromedriver().setup();
			WebDriver drvr= new ChromeDriver();
			drvr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			drvr.get(url);
			drvr.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
			drvr.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
			drvr.findElement(By.id("submitButton")).click();
			drvr.findElement(By.xpath("//a[text()='Contacts']")).click();
			drvr.findElement(By.xpath("//img[contains(@title,'Create Contact...')]")).click();
			drvr.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
			drvr.findElement(By.xpath("//input[@class='crmButton small save']")).click();
			String res = drvr.findElement(By.id("mouseArea_Last Name")).getText();
			System.out.println(res);
			if(expRes.equals(res)){
				System.out.println("Test case is passed");
				
			}
			else {
				System.out.println("Test case is failed");
			}
			
			WebElement logoutButton = drvr.findElement(By.xpath("//img[contains(@src,'themes/softed/images/user.PNG')]"));

			Actions axn= new Actions(drvr);
			axn.moveToElement(logoutButton).perform();

			drvr.findElement(By.xpath("//a[text()='Sign Out']")).click();
			drvr.close();


		}		


		finally {
			connection.close();
			System.out.println("----Connection is closed----");

		}

	}

}
