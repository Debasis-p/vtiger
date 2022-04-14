package com.crm.vtiger;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import com.crm.genericUtility.BaseClass;
import com.crm.genericUtility.JavaUtility;
import com.crm.genericUtility.PropertyUtility;
import com.crm.genericUtility.WorkbookUtility;
import com.crm.objectRepository.CreateNewOrganizationPage;
import com.crm.objectRepository.OrganizationInformationPage;
import com.crm.objectRepository.OrganizationPage;


public class CreateOrgWithIndustryTest extends BaseClass {
	@Test

	public void createOrgWithIndustryTest() throws IOException, Throwable {
		//Creating object of POM class
				OrganizationPage orgPage= new OrganizationPage(driver);
				CreateNewOrganizationPage createNewOrgPage = new CreateNewOrganizationPage(driver);
				OrganizationInformationPage orgInfoPage = new OrganizationInformationPage(driver);
				
				
				homePage.clickOrganizationsTab();
								
		//Clicking on creating new organization tab and inserting values
				orgPage.clickCreateOrgLookup();
				String orgName = WorkbookUtility.getData(PropertyUtility.getData("excelsheetname"), 4, 2)+JavaUtility.generateRandomNumber(1000);
				createNewOrgPage.setOrgNameTxtBox(orgName);
				createNewOrgPage.selectingIndustry();
				createNewOrgPage.selectingType();
				createNewOrgPage.ClickOnSaveButton();
				
				String expOrgName = orgInfoPage.getOrgNameTxtBox().getText();
				assertEquals((orgName.trim()), expOrgName.trim());
				
									
				Thread.sleep(3000);
					
				
			}

	

}
