package com.crm.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class is used perform operation related to property file
 * @author Deb
 *
 */
public class PropertyUtility {
	
	static Properties prp=null;
	/**
	 * This method is used to initialize the property file
	 * @param path
	 */
	public static void initializeProperty(String path) {
		try {
			FileInputStream fis = new FileInputStream(path);
			prp= new Properties();
			try {
				prp.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("IO Exception");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Specified file not found");	
		}		
	}
	
	/**
	 * This method is used to fetch the data from the property file
	 * @param value
	 * @return
	 */
	public static String getData(String value) {
		String data = prp.getProperty(value);
		return data;
		
	}
	
	

}
