package com.crm.genericUtility;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class is used to perform operation related to browser
 * @author Deb
 *
 */
public class WebDriverUtility {
	
	/**
	 * This method is used to open the browser	
	 * @param browser name
	 * @param wait time
	 * @return 
	 */
	public static WebDriver openBrowser(WebDriver driver,String browser,long timeOut, String url) {
		
		//WebDriver driver=null;
		
		if(browser.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();	
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else {
			System.out.println("Browser details not specified");
		}		
		waitImplicitily(driver, timeOut);
		maximizeWindow(driver);
		driver.get(url);
		return driver;	
		
	}
	
	/**
	 * This method is used to maximize the window  
	 * @param driver
	 */
	public static void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 *This method is used to close the browser 
	 */
	public static void closeBrowser(WebDriver driver) {
		driver.quit();
	}
	
	/**
	 * This method is to wait for a specified time period
	 * @param driver
	 * @param time
	 */
	public static void waitImplicitily(WebDriver driver, long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);		
	}
	
	/**
	 * This method is used to wait for an expected condition
	 * @param driver
	 * @param time
	 * @param element
	 */
	public static void waitUntilExpectedElement(WebDriver driver, long time, WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method is used to wait until the expected alert 
	 * @param driver
	 * @param time
	 */
	public static void waitUntilExpectedAlert(WebDriver driver, long time) {
		WebDriverWait wait= new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	/**
	 * This method is used to wait for an expected condition with polling time
	 * @param driver
	 * @param time
	 * @param element
	 * @param pollingTime
	 */
	public static void waitUntilExpectedConditionWithPollingTime(WebDriver driver, long time,WebElement element,long pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.pollingEvery(Duration.ofSeconds(pollingTime));
		wait.ignoring(Throwable.class);
	}
	
	/**
	 * This method is used to wait for custom time period
	 * @param element
	 * @param pollingTime
	 * @param timeOut
	 * @throws InterruptedException
	 */
	public static void customWaitTillElementInteractable(WebElement element, int pollingTime, int timeOut) throws InterruptedException {
		int time=0;
		while(time<=timeOut) {
		try {
			element.click();			
			break;
		}
		catch(NoSuchElementException n) {
			Thread.sleep(pollingTime);
			time++;
		}
		}
	}
	
	/**
	 * This method is used to switch windows 
	 * @param driver
	 * @param partialText
	 */
	public static void switchWindow(WebDriver driver, String partialText) {
		Set<String> winIds=driver.getWindowHandles();
		for(String id:winIds) {
			driver.switchTo().window(id);
			if(driver.getTitle().contains(partialText)) {				
				break;				
			}
		}
	}
	
	/**
	 * This method is used to move mouse cursor to a particular web element
	 * @param driver
	 * @param element
	 */
	public static void moveToElement(WebDriver driver, WebElement element) {
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method is used to move mouse cursor to a particular web element
	 * @param driver
	 * @param element
	 */
	public static void moveToElementAndClick(WebDriver driver, WebElement element) {
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
		act.click().perform();
	}
	
	/** 
	 * This method is used to double click on a web element
	 * @param driver
	 * @param element
	 */
	public static void doubleClickOnElement(WebDriver driver, WebElement element) {
		Actions act= new Actions(driver);
		act.doubleClick(element).perform();;
	}
	
	/**
	 * This method is used to right click on a web element
	 * @param driver
	 * @param element
	 */
	public static void rightClickOnElement(WebDriver driver, WebElement element) {
		Actions act= new Actions(driver);
		act.contextClick(element).perform();;
	}
	
	/**
	 * This method is used to select a drop down element with index value
	 * @param element
	 * @param indexValue
	 */
	public static void selectElement(WebElement element, int indexValue) {
		Select sel= new Select(element);
		sel.selectByIndex(indexValue);
	} 
	
	/**
	 * This method is used to select a drop down element with value
	 * @param element
	 * @param value
	 */
	public static void selectElement(WebElement element, String value ) {
		Select sel= new Select(element);
		sel.selectByValue(value);
	}
	
	/**
	 * This method is used to select a drop down element with visible text
	 * @param text
	 * @param element
	 */
	public static void selectElement(String text, WebElement element) {
		Select sel= new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/**
	 * This method is used to take the screenshot of the required/failed test case
	 * @param driver
	 * @param filename
	 * @throws IOException
	 */
	public static void takeScreenshotOfFailedTestcase(WebDriver driver, String filename) throws IOException {
		TakesScreenshot t= (TakesScreenshot)driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest = new File("./failedshot/"+filename+"_"+JavaUtility.getCurrentTimeAndDate()+".png");
		FileUtils.copyFile(src, dest);
	}
	
	/**
	 * This method is used to take the screenshot of failed test case and get the path of the output file
	 * @param driver
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static String takeScreenshotOfFailesTestcaseAndFilePath(WebDriver driver, String fileName) throws IOException {
		TakesScreenshot t= (TakesScreenshot)driver;
		File scr = t.getScreenshotAs(OutputType.FILE);
		File dest = new File("./failedshot."+fileName+"_"+JavaUtility.getCurrentTimeAndDate()+".png");
		FileUtils.copyFile(scr, dest);
		String absolutePath = dest.getAbsolutePath();
		return absolutePath;		
	}
	
	/**
	 * This method is used to open the browser through Java script
	 * @param driver
	 * @param url
	 */
	public static void openAppThroughJS(WebDriver driver, String url) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.location='"+url+"'");		
	}
	
	/**
	 * This method is used to input value through Java script
	 * @param driver
	 * @param element
	 * @param input
	 */
	public static void inputValuesThroughJS(WebDriver driver,WebElement element, String input) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("argument[0].value='"+input+"'", element);
	}
	
	/**
	 * This method is used to click the element through Java Script
	 * @param driver
	 * @param element
	 */
	public static void clickElementThroughJS(WebDriver driver, WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("argument[0].click();", element);		
	}
	
	/**
	 * This method is used to scroll the webpage to a particular element through Java Script
	 * @param driver
	 * @param element
	 */
	public static void scrollIntoElementThroughJS(WebDriver driver, WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("argument[0].scrollIntoview();", element);
	}
	
	/**
	 * THis method is used to scroll up or down to the page through Java Script
	 * @param driver
	 * @param upOrDown
	 */
	public static void scrollDownToPageThroughJS(WebDriver driver, String upOrDown) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,"+upOrDown+"document.body.scrollHeight)");
	}
	
	

 }
