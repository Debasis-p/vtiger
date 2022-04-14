package com.crm.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseConnection {

	public static void main(String[] args) throws SQLException {
		Connection connection=null;
		try {
			//Step:1--> Creating the object for the driver of JDBC and registering it
			Driver driver= new Driver();
			DriverManager.registerDriver(driver);

		//Step:2-->Get the Connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet33", "root", "root");

		//Step:3-->Create Statement
			Statement statement = connection.createStatement();
			
		//Step:4-->Execute the Code
			//To fetch the data(DQL)
			ResultSet result = statement.executeQuery("select * from sdet33;");
			while(result.next()) {
				System.out.println(result.getString(4));
			}

			
		}
		finally {
			//Step:5-->Close the Connection to Database
			connection.close();
			System.out.println();
			System.out.println("---- Database connection is closed----");
			

		}

	

	}

}
