package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Creating public class and giving the class name as webpage name
public class ContactInformationPage {
	
	
//Declaration
		@FindBy(id = "dtlview_Last Name")
		private WebElement lastName;
	
		@FindBy(id = "mouseArea_Reports To")
		private WebElement reportsTo;
	
	
//Initialization
		public ContactInformationPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}


		
//Utilization
	//using getter method
		public WebElement getLastName() {
			return lastName;
		}
	
		public WebElement getReportsTo() {
			return reportsTo;
		}
	//Using business library
		public String getLastNameData() {
			String data = lastName.getText();
			return data;
		}
		public String getReportsToData() {
			String data = reportsTo.getText();
			return data;
		}
		public boolean verifyData(String actLastName) {
			boolean data=false;
			if(actLastName.equals(getReportsToData())) {
				data = true;
			}
			else {
				data = false;
			}
			return data;
			
		}
	

	

}
