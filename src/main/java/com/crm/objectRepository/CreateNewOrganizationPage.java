package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericUtility.PropertyUtility;
import com.crm.genericUtility.WebDriverUtility;

public class CreateNewOrganizationPage {
	
//Declaration	
	@FindBy(name = "accountname")
	private WebElement orgNameTxtBox;
	
	@FindBy(xpath = "//td[contains(.,'Member Of')]/following-sibling::td[1]/img[@title='Select']")
	private WebElement membersOfLookup;
	
	@FindBy(xpath = "//a[@href='javascript:window.close();' and @id='2']")
	private WebElement selectingMemberOfOrg;
	
	@FindBy(xpath = "(//input[@class='crmbutton small save' ])[1]")
	private WebElement saveButton;
	
	@FindBy(xpath = "//select[@name='industry']")
	private WebElement indusSelectButton;
	
	@FindBy(xpath = "//select[@name='accounttype']")
	private WebElement typeSelectButton;
	
	
//Initialization
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//Utilization
		//Using getter method
		public WebElement getOrgNameTxtBox() {
			return orgNameTxtBox;
		}
		
		public WebElement getMembersOfLookup() {
			return membersOfLookup;
		}	
		
		public WebElement getSelectingMemberOfOrg() {
			return selectingMemberOfOrg;
		}
		
		public WebElement getSaveButton() {
			return saveButton;
		}
		
		//Using Business logic
		
		public void setOrgNameTxtBox(String orgName) {
			orgNameTxtBox.sendKeys(orgName);
		}
		public void clickMembersOfLookup() {
			membersOfLookup.click();
		}
		public void selectingMemberFromList(WebDriver driver, long time) {
			WebDriverUtility.moveToElementAndClick(driver, selectingMemberOfOrg);
			WebDriverUtility.waitUntilExpectedAlert(driver, time);
			driver.switchTo().alert().accept();
			
		}
		public void ClickOnSaveButton() {
			getSaveButton().click();
		}
		
		public void selectingIndustry() {
			WebDriverUtility.selectElement(indusSelectButton, PropertyUtility.getData("industry"));
		}
		
		public void selectingType() {
			WebDriverUtility.selectElement(typeSelectButton, PropertyUtility.getData("type"));;
		}
		
	

}
