package com.laptrinhjavaweb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	 private static String DB_URL = "jdbc:mysql://localhost:3306/javacore72022?useSSL=false&serverTimezone=UTC";
	 private static String PASS = "1234";
	 private static String USER ="root";
	 

	public static Connection getConnection() {
		Connection conn  = null;
	try {
		 conn = DriverManager.getConnection(DB_URL, USER, PASS);
		return conn;
	}catch (SQLException e) {
		return null;
	}catch( Exception e) {
		return null;
	}
	
	}
}
