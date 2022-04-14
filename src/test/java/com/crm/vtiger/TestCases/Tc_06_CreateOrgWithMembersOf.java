package com.crm.vtiger.TestCases;

import org.openqa.selenium.WebDriver;

import com.crm.genericUtility.ConstantPath;
import com.crm.genericUtility.JavaUtility;
import com.crm.genericUtility.PropertyUtility;
import com.crm.genericUtility.WebDriverUtility;
import com.crm.objectRepository.CreateNewOrganizationPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;
import com.crm.objectRepository.OrganizationInformationPage;
import com.crm.objectRepository.OrganizationPage;

public class Tc_06_CreateOrgWithMembersOf {
	public static void main(String[] args) {
		
		WebDriver driver= null;
		
//Property file operation
		PropertyUtility.initializeProperty(ConstantPath.PropertyFilePath);
		String url = PropertyUtility.getData("url");
		String un = PropertyUtility.getData("username");
		String pwd = PropertyUtility.getData("password");
		String browser = PropertyUtility.getData("browser");
		String t = PropertyUtility.getData("timeout");
		long time = Long.parseLong(t);	
		String orgName = PropertyUtility.getData("orgName");
		
		int randomNum = JavaUtility.generateRandomNumber(1000);
		
//Browser operation
		driver= WebDriverUtility.openBrowser(driver, browser, time, url);
		LoginPage loginPage= new LoginPage(driver);
		HomePage homePage= new HomePage(driver);
		OrganizationPage orgPage = new OrganizationPage(driver);
		CreateNewOrganizationPage createNewOrg = new CreateNewOrganizationPage(driver);
		OrganizationInformationPage orgInfoPage = new OrganizationInformationPage(driver);
		
		
//Logging in to the application
		loginPage.loginAction(un, pwd);
		
//Clicking Organization link on homepage
		homePage.clickOrganizationsTab();

//Clicking on new organization lookup in organization page
		orgPage.clickCreateOrgLookup();
		
//Inserting the required fields and members of lookup
		String actOrgName = orgName+"_"+randomNum;
		createNewOrg.setOrgNameTxtBox(actOrgName);
		createNewOrg.clickMembersOfLookup();
		WebDriverUtility.switchWindow(driver, "Accounts&action");
		createNewOrg.selectingMemberFromList(driver, time);
		WebDriverUtility.switchWindow(driver, "Accounts");
		
//Clicking on save button
		createNewOrg.ClickOnSaveButton();
		
		String expOrgName = orgInfoPage.getOrgNameTxtBoxData();
		
//Verification of organization name and members of
		
		if(actOrgName.equals(expOrgName)) {
			System.out.println("Organization created sucessfully with members of field");
		}
		else{
			System.out.println("Failed");
		}
		
//Signing out from the application
		homePage.clickSignoutButton();
		
		
		
	
		
	}

}
