package com.crm.vtiger;


import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.genericUtility.BaseClass;
import com.crm.genericUtility.JavaUtility;
import com.crm.genericUtility.PropertyUtility;
import com.crm.genericUtility.WorkbookUtility;
import com.crm.objectRepository.CreateNewOrganizationPage;
import com.crm.objectRepository.OrganizationInformationPage;
import com.crm.objectRepository.OrganizationPage;


public class CreateOrgTest extends BaseClass {
	@Test
	public void createOrgTest() throws Exception {
		
//Creating object for the POM class
		OrganizationPage orgPage= new OrganizationPage(driver);
		CreateNewOrganizationPage createNewOrg= new CreateNewOrganizationPage(driver);
		OrganizationInformationPage orgInfoPage = new OrganizationInformationPage(driver);
		
//Fetching organization name		
		String actOrgName = WorkbookUtility.getData(PropertyUtility.getData("excelsheetname"), 3, 2)+ JavaUtility.generateRandomNumber(1000);
		
//Finding the Organization tab and creating new organization
		homePage.clickOrganizationsTab();
		orgPage.clickCreateOrgLookup();
		createNewOrg.setOrgNameTxtBox(actOrgName);
		createNewOrg.ClickOnSaveButton();

//Verifying the Organization created	
		String expOrgName = orgInfoPage.getOrgNameTxtBoxData();
		if(actOrgName.equals(expOrgName)) {
			Reporter.log("Organization Created", true);
			Reporter.log("TestCase Passed", true);
		}
			
		
	}

}
