package testNG;

import org.testng.Reporter;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class PracticeTest1 {
	
	@Test(groups = "smoke")
	public void Test1() {
		Reporter.log("This is 1st test method from PracticeTest1", true);
	}	
	
	@Test (groups = {"smoke", "regression"})
	public void Test2() {
		Reporter.log("This is 2nd test method from PracticeTest1", true);
	}
	
	
	
	/*@BeforeSuite
	public void beforeSuite() {
		Reporter.log("This is before suite from practice test", true);
	}*/
	/*@AfterSuite
	public void afterSuite() {
		Reporter.log("This is after suite from practice test", true);
		
	}*/

}
