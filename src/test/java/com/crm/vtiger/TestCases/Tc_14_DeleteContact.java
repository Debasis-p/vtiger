package com.crm.vtiger.TestCases;

import org.openqa.selenium.WebDriver;

import com.crm.genericUtility.ConstantPath;
import com.crm.genericUtility.PropertyUtility;
import com.crm.genericUtility.WebDriverUtility;
import com.crm.objectRepository.ContactPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;

public class Tc_14_DeleteContact {
	public static void main(String[] args) {
		WebDriver driver= null;
		
//property file Operation
		PropertyUtility.initializeProperty(ConstantPath.PropertyFilePath);
		String url = PropertyUtility.getData("url");
		String un = PropertyUtility.getData("username");
		String pw = PropertyUtility.getData("password");
		String browser = PropertyUtility.getData("browser");
		String t = PropertyUtility.getData("timeout");
		long time = Long.parseLong(t);	
		
//Browser Operation
		driver= WebDriverUtility.openBrowser(driver, browser, time, url);
		LoginPage loginPage= new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		ContactPage contactPage= new ContactPage(driver);
		
//signing into the application
		loginPage.loginAction(un, pw);
		
//Finding contacts tab
		homePage.clickContactTab();
		
//Selecting multiple contacts and deleting it
		contactPage.clickSelectContact();
		contactPage.clickDeleteButton(driver, time);
		
//Logging out from the application
		
		WebDriverUtility.waitUntilExpectedElement(driver, time, homePage.getSignoutLookup());
		
		homePage.clickSignoutButton();
		
		
	}

}
