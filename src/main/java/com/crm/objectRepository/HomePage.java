package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Creating public class and giving the class name as webpage name
public class HomePage {
	
//Declaration
	@FindBy(linkText = "Contacts")
	private WebElement contactsTab;
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationsTab;
	
	@FindBy(xpath = "//img[contains(@src,'themes/softed/images/user.PNG')]")
	private WebElement signoutLookup;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signoutButton;
	
	
//Initialization
		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
	
		
//Utilization
	//Using getter
		public WebElement getContactsTab() {
			return contactsTab;
		}
		public WebElement getorganizationsTab() {
			return organizationsTab;
		}
		
		public WebElement getSignoutLookup() {
			return signoutLookup;
		}
		public WebElement getSignoutButton() {
			return signoutButton;
		}
		
	//Using business logic
		public void clickContactTab() {
			contactsTab.click();
		}
		public void clickOrganizationsTab() {
			organizationsTab.click();
		}
		
		public void clickSignoutButton() {
			signoutLookup.click();
			signoutButton.click();
		}

	
	
	

}
