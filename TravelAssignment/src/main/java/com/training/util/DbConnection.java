package com.training.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DbConnection {
	
public static Connection getOracleConnection() {
	Connection con=null;
	try {
		Properties props=new Properties();
		
		ClassLoader classloader=Thread.currentThread().getContextClassLoader();
		InputStream inStream=classloader.getResourceAsStream("/DbConnection.properties");
		

		
		props.load(inStream);
		
		Class.forName(props.getProperty("db.oracle.driverClass"));
		
		con=DriverManager.getConnection(props.getProperty("db.oracle.url"),
				props.getProperty("db.oracle.userName"),
				props.getProperty("db.oracle.passWord"));
				
	} catch (SQLException |ClassNotFoundException | IOException e) {
		e.printStackTrace();
	}
	return con;
}
}
