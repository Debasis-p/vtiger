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

public class Tc_10_CreateContactWithAssignTo {
	public static void main(String[] args) {
		WebDriver driver=null;
		
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
				driver= WebDriverUtility.openBrowser(driver, browser, time, url);
				LoginPage loginPage= new LoginPage(driver);
				HomePage homePage= new HomePage(driver);
				ContactPage contactPage= new ContactPage(driver);
				CreateNewContact createNewContact= new CreateNewContact(driver);
				
			//signing into the application
				loginPage.loginAction(un, pw);
				
			//Finding contacts tab
				homePage.clickContactTab();
			
			//creating new contact	
				contactPage.clickCreateContactLookup();
				createNewContact.setLastnameTxtBox(actLastName);
				
			//Selecting assign to radio button and drop down 
				createNewContact.clickAssignToRadioBtn();
				//driver.findElement(By.xpath("//input[@type='radio' and @value='T']")).click();
				WebElement selEle = createNewContact.getSelectOption();
				WebDriverUtility.selectElement("Marketing Group", selEle);
				
			//Clicking on save button and signing out from the application
				createNewContact.clickSaveButton();
				//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				WebElement elem = homePage.getSignoutLookup();
				WebDriverUtility.moveToElement(driver, elem);
				homePage.clickSignoutButton();
				//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				
				WebDriverUtility.closeBrowser(driver);
				
	}

}
