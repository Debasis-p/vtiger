package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchOrgPage {
//Declaration
	@FindBy(name = "search_text")
	private WebElement searchTxtBox;
	@FindBy(name = "search")
	private WebElement searchButton;
	@FindBy(xpath = "//a[@href='javascript:window.close();']")
	private WebElement selectOrg;
	
//Initialization
	public SearchOrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
//Utilization
	//Using Business logic
	public void setSearchTxtBoxValue(String value) {
		searchTxtBox.sendKeys(value);
	}
	public void clickSearchButton() {
		searchButton.click();
	}
	public void selectReqOrg() {
		selectOrg.click();
	}
	

}
