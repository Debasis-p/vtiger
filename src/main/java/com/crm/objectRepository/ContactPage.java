package com.crm.objectRepository;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericUtility.WebDriverUtility;

//Creating public class and giving the class name as webpage name
public class ContactPage {

//Declaration
		
	@FindBy(xpath = "//img[contains(@title,'Create Contact...')]")
	private WebElement createContactLookup;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	private List<WebElement> selectContact;
	
	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement deleteButton;
	
//Initialization
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//Utilization
	//Using getter
	
	public WebElement getCreateContactsTab() {
		return createContactLookup;
	}
	public List<WebElement> getSelectContact() {
		return selectContact;
	}
	public WebElement getDeleteButton() {
		return deleteButton;
	}
	
	
	
	//Using business logic
	public void clickCreateContactLookup() {
		createContactLookup.click();
	}
	public void clickSelectContact() {
		for(int i=1; i<selectContact.size(); i++) {
				selectContact.get(i).click();	
				if(i==2) {
					break;
				}
		}
	}
	public void clickDeleteButton(WebDriver driver, long time) {		
		deleteButton.click();
		WebDriverUtility.waitUntilExpectedAlert(driver, time);
		driver.switchTo().alert().accept();
	}
	
	
	
	
	
}
