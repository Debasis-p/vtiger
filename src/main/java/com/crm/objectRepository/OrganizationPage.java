package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Creating public class and giving the class name as webpage name
public class OrganizationPage {
	
//Declaration
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createOrgLookup;
	
	
//Initialization
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


//Utilization
	//Using getter
	public WebElement getCreateOrgLookup() {
		return createOrgLookup;
	}
	
	//Using business logic
	public void clickCreateOrgLookup() {
		createOrgLookup.click();
	}
	

	

}
