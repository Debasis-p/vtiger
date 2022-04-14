package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Creating public class and giving the class name as webpage name
public class CreateNewContact {

//Declaration
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement LastnameTxtBox;
	@FindBy(xpath = "//td[contains(.,'Reports To') and @class='dvtCellLabel']/following-sibling::td[1]/img")
	private WebElement reportsToLookup;
	@FindBy(xpath = "//a[@href='javascript:window.close();' and @id='2']")
	private  WebElement moveToOption;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	@FindBy(xpath = "//input[@type='radio' and @value='T']")
	private WebElement assignToRadioBtn;
	@FindBy(xpath = "//select[@name='assigned_group_id']")
	private WebElement selectOption;
	@FindBy(xpath = "//td[contains(.,'Organization Name') and @class='dvtCellLabel']/following-sibling::td[1]/img[@src='themes/softed/images/select.gif']")
	private WebElement orgLookupButton;
	
//Initialization
	public CreateNewContact (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
//Utilization
	//using getter
	public WebElement getLastnameTxtBox() {
		return LastnameTxtBox;
	}
	public WebElement getReportsToLookup() {
		return reportsToLookup;
	}
	public WebElement getMoveToOption() {
		return moveToOption;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	public WebElement getAssignToRadioBtn() {
		return assignToRadioBtn;
	}
	public WebElement getSelectOption() {
		return selectOption;
	}
	
	
	//Using business logic
	public void setLastnameTxtBox(String actLastName) {
		LastnameTxtBox.sendKeys(actLastName);
		
	}
	public void clickReportsToLookup() {
		reportsToLookup.click();
	}
	public void clickSaveButton() {
		saveButton.click();
	}
	public void clickAssignToRadioBtn() {
		assignToRadioBtn.click();
	}
	public void clickOrgLookupButton() {
		orgLookupButton.click();
	}
	
	
	
	
	
}
