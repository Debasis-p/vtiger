package testNG;

import org.testng.Reporter;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class PracticeTest2 {

	
	@Test(groups = {"smoke","regression"})
	public void Test1() {
		Reporter.log("This is 1st test method from PracticeTest2 ", true);
	}
	
	
	@Test(groups = "regression")
	public void Test2() {
		Reporter.log("This is 2nd test method from PracticeTest2", true);
	}
	
	
	/*@BeforeSuite
	public void beforeSuiteTest() {
		Reporter.log("This is before suite method from practice test1", true);
	}
	@AfterSuite
	public void afterSuiteTest() {
		Reporter.log("This is after suite method from practice test1", false);
	}*/
}
