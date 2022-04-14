package com.crm.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.genericUtility.ConstantPath;
import com.crm.genericUtility.WorkbookUtility;

public class practice {
	
	@Test(dataProvider = "dataProvider_excel")
	public void practiceTest(String username, String password) {
		System.out.println(username+"-----"+password);		
		
	}
	
	
	@DataProvider
	public Object[][] dataProvider_excel() {
		WorkbookUtility.openExcel(ConstantPath.ExcelFilePath);
		Object[][] data = WorkbookUtility.getMultiData("practice");
		return data;	
		
	}

}
