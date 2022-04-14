package com.crm.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FetchDataFromProperty {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis= new FileInputStream("./src/test/resources/commonData.properties");
		Properties prp= new Properties();
		prp.load(fis);
		String url = prp.getProperty("url");
		String un = prp.getProperty("username");
		String pwd = prp.getProperty("password");
		System.out.println("URL ==>> "+url);
		System.out.println("Username ==>> "+un);
		System.out.println("Password ==>> "+pwd);
		

	}

}
