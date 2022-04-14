package testNG;


import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.genericUtility.BaseClass;
import com.crm.genericUtility.PropertyUtility;
import com.crm.genericUtility.WorkbookUtility;
import com.crm.objectRepository.ContactInformationPage;
import com.crm.objectRepository.ContactPage;
import com.crm.objectRepository.CreateNewContact;

public class PracticeAssert extends BaseClass {
	@Test
	
				public void practiceAssertTest() throws IOException {
				
				//Creating object for POM classes
						ContactPage contactPage= new ContactPage(driver);
						CreateNewContact createContactPage= new CreateNewContact(driver);
						ContactInformationPage contactInfoPage= new ContactInformationPage(driver);
				
				//Fetching last name
						String actLastName = WorkbookUtility.getData(PropertyUtility.getData("excelsheetname"), 2, 1);
						
				//Finding the contacts tab and creating new contact		
						homePage.clickContactTab();
						Assert.fail();
						contactPage.clickCreateContactLookup();
						createContactPage.setLastnameTxtBox(actLastName);
						createContactPage.clickSaveButton();
						
						
				
				//Fetching last name
						String expLastName = contactInfoPage.getLastNameData();
						
				//Verifying data
						Assert.assertEquals(actLastName, expLastName);	
						Reporter.log("TC Passed", true);
							
							
			}			
		}
	


