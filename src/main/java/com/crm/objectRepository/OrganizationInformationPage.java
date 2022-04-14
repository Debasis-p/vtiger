package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Creating public class and giving the class name as webpage name
public class OrganizationInformationPage {
	
//Declaration
	@FindBy(id = "mouseArea_Organization Name")
	private WebElement orgNameTxtBox;
	
	@FindBy(id = "mouseArea_Member Of")
	private WebElement memberOFTxtBox;
	
	
//Initialization
	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


//Utilization
	//using getter
		public WebElement getOrgNameTxtBox() {
			return orgNameTxtBox;
		}

		public WebElement getMemberOFTxtBox() {
			return memberOFTxtBox;
		}
		
		//using business logic
		public String getOrgNameTxtBoxData() {
			String data = orgNameTxtBox.getText();
			return data;
		}
		public String getMemberOFTxtBoxData() {
			String data = memberOFTxtBox.getText();
			return data;
		}
	


	

}
