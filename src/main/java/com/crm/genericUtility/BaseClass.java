package com.crm.genericUtility;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public HomePage homePage;
	public static WebDriver sDriver;
	
	@BeforeSuite
	public void openConnection() throws Throwable {
		PropertyUtility.initializeProperty(ConstantPath.PropertyFilePath);
		DatabaseUtility.getDbConnection(ConstantPath.DataBasePath, PropertyUtility.getData("dbusername"), PropertyUtility.getData("dbpassword"));
		WorkbookUtility.openExcel(ConstantPath.ExcelFilePath);
	
	}
	
	//@Parameters("browser")
	@BeforeClass
	public void launchBrowser(/*String browser*/) {
		driver=WebDriverUtility.openBrowser(driver, PropertyUtility.getData("browser"),JavaUtility.convertStringToLong(PropertyUtility.getData("timeout")), PropertyUtility.getData("url"));
		sDriver= driver;
	}
	
	@BeforeMethod
	public void loginToApp() {
		LoginPage login= new LoginPage(driver);
		login.loginAction(PropertyUtility.getData("username"),PropertyUtility.getData("password"));
		homePage= new HomePage(driver);
		
	}
	
	@AfterMethod
	public void logoutFromApp() {
		homePage.clickSignoutButton();	
		
	}
	
	@AfterClass
	public void closeBrowser() {
		WebDriverUtility.closeBrowser(driver);	
		
	}
	
	@AfterSuite
	public void closeConnection() throws SQLException {
		WorkbookUtility.closeExcel();
		DatabaseUtility.closeDbConnection();
		
	}
	

}
