package com.crm.objectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



//Creating public class and giving the class name as webpage name
public class LoginPage {
	
	
//Declaration 
		@FindBy(name = "user_name")
		private WebElement usernameTxtBox;
		
		@FindBy(name = "user_password")
		private WebElement passwordTxtBox;
		
		@FindBy(id = "submitButton")
		private WebElement submitBtn;
		
		@FindBy(xpath = "//img[contains(@src,'themes/softed/images/user.PNG')]")
		private WebElement signoutLookup;
		
		@FindBy(xpath = "//a[text()='Sign Out']")
		private WebElement signoutButton;
		
//Initialization
		public LoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		
//Utilization
		//Using Getter method
		public WebElement getUsernameTxtBox() {
			return usernameTxtBox;
		}

		public WebElement getPasswordTxtBox() {
			return passwordTxtBox;
		}

		public WebElement getSubmitBtn() {
			return submitBtn;
		} 
		
		
		
		//Using business logic
		public void loginAction(String un, String pwd) {
			inputUsername_Password(un, pwd);
			submitBtn.click();
		}
		
		public void inputUsername_Password(String un, String pwd) {
			usernameTxtBox.sendKeys(un);
			passwordTxtBox.sendKeys(pwd);
		}
						
		
	}

