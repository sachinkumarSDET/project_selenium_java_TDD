package com.genericUtility;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class databaseUtility {

	Driver driver;
	Connection con;
	
	/*
	 * @sachinkumar_biradar
	 * connect to the database
	 */
	
	public void connect_To_DB(String URL, String userName, String password) throws SQLException {
	DriverManager.registerDriver(driver);
	con = DriverManager.getConnection(URL, userName, password);
	}
	
	/*
	 * @sachinkumar_biradar
	 * Execute the query
	 */
	public void execute_database(String query) throws SQLException {
		ResultSet rs = con.createStatement().executeQuery(query);
		while(rs.next()) {
			String firstName = rs.getString(0);
			String lastName = rs.getString(1);
		}
	}
	
	/*
	 * @sachinkumar_biradar
	 * update the database
	 */
	public void update_database(String query) throws SQLException {
		con.createStatement().executeUpdate(query);
	}
	
	/*
	 * @sachinkumar_biradar
	 * close the connection from the database
	 */
	
	public void close_database() throws SQLException {
		if (con!=null) {
			con.close();
		}
	}
}
