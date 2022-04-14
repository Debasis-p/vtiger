package com.crm.Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demo {
public static void main(String[] args) {
	System.out.println("hi");
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	
	driver.get("http://localhost:8888/");	
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.linkText("Contacts")).click();
	
	List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
	int num=1;
	
	for(int i=1; i<checkboxes.size(); i++) {
	checkboxes.get(i).click();
	if(num==5) {
		break;
	}
	num++;
	}
	
	
	
		
		}
	}


