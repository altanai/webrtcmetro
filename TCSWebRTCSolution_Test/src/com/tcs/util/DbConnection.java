package com.tcs.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


 
public class DbConnection {
	
	static String url=null;
	static String dbuser=null;
	static String dbpassword=null;
	static Connection con = null;
	static String DRIVER_NAME = "com.mysql.jdbc.Driver";
	
	public static Connection getConnection() {
		try {
			Class.forName(DRIVER_NAME);
			getDbCrefentials();
			// ----------------------------- reading frm db config file
			con = DriverManager.getConnection("jdbc:mysql://" +url, dbuser, dbpassword);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally{
			
		}

		return con;
  }
	
	public static void closeConnection(Connection con) {

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void closeStatement(PreparedStatement ps) {

		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void getDbCrefentials(){
		Properties prop = new Properties();
		InputStream input = null;
	 
		try {
	 
			input = new FileInputStream("/home/altanai/webservicesworkspace2/TCSWebRTCSolution_Test/src/config.properties");
	 
			// load a properties file
			prop.load(input);
	 
			// get the property value and print it out
			url=prop.getProperty("url");
			dbuser=prop.getProperty("dbuser");
			dbpassword=prop.getProperty("dbpassword");
	 
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
}