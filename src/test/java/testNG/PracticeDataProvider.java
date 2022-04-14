package testNG;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.genericUtility.ConstantPath;
import com.crm.genericUtility.WorkbookUtility;

public class PracticeDataProvider {
	@Test(dataProvider = "dataProvider_Excel")
	public void practiceDataProviderTest(String username, String password) {
		Reporter.log(username+"<---->"+password, true);	
		
		
	}
	
	@DataProvider
	public Object[][] dataProvider_Excel() {
		WorkbookUtility.openExcel(ConstantPath.ExcelFilePath);
		Object[][] data = WorkbookUtility.getMultiData("practice");
		return data;
		
	}

}
