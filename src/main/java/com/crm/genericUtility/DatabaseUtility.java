package com.crm.genericUtility;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * This class is used to perform operation related to database
 * @author Deb
 *
 */
public class DatabaseUtility {
	 static Connection connection;
	
	/**
	 * This method is used to create connection with the database
	 * @throws Throwable 
	 */
	public static void getDbConnection(String url, String dbun, String dbpwd) throws Throwable {
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		connection= DriverManager.getConnection(url, dbun, dbpwd);				
	}
	
	public static void closeDbConnection() throws SQLException {
		connection.close();
	}
	
	

}
