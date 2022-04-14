package com.crm.vtiger.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.crm.genericUtility.ConstantPath;
import com.crm.genericUtility.PropertyUtility;
import com.crm.genericUtility.WebDriverUtility;
import com.crm.objectRepository.ContactPage;
import com.crm.objectRepository.CreateNewContact;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;

public class Tc_07_CreateContactWithReportsTo {
	public static void main(String[] args) {
		WebDriver driver = null;
	
	//property file Operation
		PropertyUtility.initializeProperty(ConstantPath.PropertyFilePath);
		String url = PropertyUtility.getData("url");
		String un = PropertyUtility.getData("username");
		String pw = PropertyUtility.getData("password");
		String browser = PropertyUtility.getData("browser");
		String t = PropertyUtility.getData("timeout");
		long time = Long.parseLong(t);	
		String actLastName = PropertyUtility.getData("lastname");
		
		
		
	//Browser Operation
		driver= WebDriverUtility.openBrowser(driver,browser, time, url);		
		LoginPage loginPage= new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		ContactPage contactPage= new ContactPage(driver);
		CreateNewContact createNewContact= new CreateNewContact(driver);
		
	//Signing into the application
		loginPage.loginAction(un, pw);
			
	//creating new contact
		homePage.clickContactTab();
		contactPage.getCreateContactsTab();
		
	//Filling the data into create new contact page  
		createNewContact.setLastnameTxtBox(actLastName);
		
	//finding the report to lookup 
		createNewContact.clickReportsToLookup();
		WebDriverUtility.switchWindow(driver, "Contacts&action");
		WebElement ele = createNewContact.getMoveToOption();
		WebDriverUtility.moveToElementAndClick(driver, ele);
		WebDriverUtility.switchWindow(driver, "Contacts");
		
	//Clicking on save Button	
		createNewContact.clickSaveButton();
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
	//signing out from the application
		WebElement elem = homePage.getSignoutLookup();
		WebDriverUtility.moveToElement(driver, elem);
		homePage.clickSignoutButton();
		
	//Closing the web browser
		WebDriverUtility.closeBrowser(driver);		
		
	}

}
