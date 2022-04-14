package testNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class PracticeTest4 {
	@Test(groups = "regression")
		public void Test1() {
		Reporter.log("This is 1st test method from PracticeTest4", true);
	}	
	
	@Test(groups = {"smoke","regression"}) 
	public void Test2() {
		Reporter.log("This is 2nd test method from PracticeTest4", true);
	}

}
