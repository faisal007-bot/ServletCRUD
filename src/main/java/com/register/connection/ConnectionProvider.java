package com.register.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	
	private static Connection conn;
	private static final String driverClassName = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/student";
	private static final String username = "root";
	private static final String password = "faisal";

	public static Connection getConnection() {
		try {
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, username, password);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
