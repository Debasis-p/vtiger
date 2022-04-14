package com.crm.vtiger;

import java.io.IOException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.genericUtility.BaseClass;
import com.crm.genericUtility.PropertyUtility;
import com.crm.genericUtility.WorkbookUtility;
import com.crm.objectRepository.ContactInformationPage;
import com.crm.objectRepository.ContactPage;
import com.crm.objectRepository.CreateNewContact;


public class CreateContactTest extends BaseClass {
	@Test
		public void createContact() throws IOException {
		
		//Creating object for POM classes
				ContactPage contactPage= new ContactPage(driver);
				CreateNewContact createContactPage= new CreateNewContact(driver);
				ContactInformationPage contactInfoPage= new ContactInformationPage(driver);
		
		//Fetching last name
				String actLastName = WorkbookUtility.getData(PropertyUtility.getData("excelsheetname"), 2, 2);
				
		//Finding the contacts tab and creating new contact		
				homePage.clickContactTab();
				contactPage.clickCreateContactLookup();
				createContactPage.setLastnameTxtBox(actLastName);
				createContactPage.clickSaveButton();
		
		//Fetching last name
				//String expLastName = contactInfoPage.getLastNameData();
				
		//Verifying data
				boolean result = contactInfoPage.verifyData(actLastName);
				if(result==true) {
					Reporter.log("Testcase passed", true);
				}
				else {
					Reporter.log("Testcase failed", true);
				}				
					
					
	}			
}
