package testNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class PracticeTest3 {
	@Test(groups = "smoke")
	public void Test1() {
		Reporter.log("This is 1st test method from PracticeTest3", true);
	}	
	
	@Test (groups = "regression")
	public void Test2() {
		Reporter.log("This is 2nd test method from PracticeTest3", true);
	}

}
