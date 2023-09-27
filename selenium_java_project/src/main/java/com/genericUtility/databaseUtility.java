package com.genericUtility;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class databaseUtility {
	
	public Driver driver;
	public Connection con = null;
	int set = 0;
	/*
	 * @author Sachinkumar_Biradar
	 * Connecting to the database
	 */
	public void connectToDB(String url, String username, String password) throws Throwable {
		 DriverManager.registerDriver(driver);
		 con = DriverManager.getConnection(url, username, password);
	}
	
	/*
	 * @author Sachinkumar_Biradar
	 * Disconnecting to the database
	 */
	public void closeFromDB() throws SQLException {
		con.close();
	}
	
	/*
	 * @author Sachinkumar_Biradar
	 * Read data from the database
	 */
	//read data from the database
	public String readDataFromDB(String query, int columnIndex, String expdata) throws SQLException {
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag = false;
		while (result.next()) {
			if (result.getString(columnIndex).equalsIgnoreCase(expdata)) {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println("Data has been validated upon the verification");
			return expdata;
		} else {
			System.out.println("Data has not been validated upon the verification");
			return "";
		}
		
	}
	
	/*
	 * @author Sachinkumar_Biradar
	 * Delete data in the database
	 */
	public void deleteDataInDBAndValidate(String expectedProject) throws Throwable {
		String query = "delete from project where project_Id = '"+expectedProject+"';";
		int set = con.createStatement().executeUpdate(query);
			if (set==1) {
				System.out.println("deleted successfully in Database");
			} else {
				System.out.println("Not achieved the deletion of the project in Database");
			}
	}
	
	//Update data in database
	public void updateDataInDB(String firstname, String lastname, double phonenumber) throws SQLException {
		String query = "insert into project values('"+firstname+"', '"+lastname+"', '"+phonenumber+"')";
		set = con.createStatement().executeUpdate(query);
		
		if (set==1) {
			System.out.println("Data updated successfully");
		} else {
			System.out.println("Data has not been updated");
		}
	}
}