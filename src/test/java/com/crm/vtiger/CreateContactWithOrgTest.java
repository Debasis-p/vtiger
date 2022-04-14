package com.crm.vtiger;

import java.io.IOException;
import org.testng.annotations.Test;

import com.crm.genericUtility.BaseClass;
import com.crm.genericUtility.JavaUtility;
import com.crm.genericUtility.PropertyUtility;
import com.crm.genericUtility.WebDriverUtility;
import com.crm.genericUtility.WorkbookUtility;
import com.crm.objectRepository.ContactPage;
import com.crm.objectRepository.CreateNewContact;
import com.crm.objectRepository.CreateNewOrganizationPage;
import com.crm.objectRepository.OrganizationPage;
import com.crm.objectRepository.SearchOrgPage;


public class CreateContactWithOrgTest extends BaseClass {
	
	@Test

	public void createOrgWithIndustryTest() throws IOException, Throwable {
		
		homePage.clickOrganizationsTab();
		
	//Creating objects for POM classes
		OrganizationPage orgPage= new OrganizationPage(driver);
		CreateNewOrganizationPage createOrgPage = new CreateNewOrganizationPage(driver);
		ContactPage contactPage= new ContactPage(driver);
		CreateNewContact createNewContactPage= new CreateNewContact(driver);
		SearchOrgPage searchPage= new SearchOrgPage(driver);
		
		
		String orgName = WorkbookUtility.getData(PropertyUtility.getData("excelsheetname"), 2, 2)+JavaUtility.generateRandomNumber(1000);
	//Finding organization tab and creating new organization
		orgPage.clickCreateOrgLookup();
		createOrgPage.setOrgNameTxtBox(orgName);
		createOrgPage.ClickOnSaveButton();
		
	//Creating new contact with organization
		Thread.sleep(2000);
		homePage.clickContactTab();
		contactPage.clickCreateContactLookup();
		createNewContactPage.setLastnameTxtBox(WorkbookUtility.getData(PropertyUtility.getData("excelsheetname"), 2, 1));
		createNewContactPage.clickOrgLookupButton();
		WebDriverUtility.switchWindow(driver, "Accounts");
		searchPage.setSearchTxtBoxValue(orgName);
		searchPage.clickSearchButton();
		searchPage.selectReqOrg();
		WebDriverUtility.switchWindow(driver, "Contacts");
		createNewContactPage.clickSaveButton();
		
		
			
		}

}
