package com.cg.dbutil;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DButil {
static Connection con;
static Properties prop;
static
{
	
	try {
		prop=new Properties();
		File file=new File("jdbc.properties");
		FileInputStream fileInputStream=new FileInputStream(file);
		prop.load(fileInputStream);
		
	} catch (Exception exception) {
		// TODO Auto-generated catch block
	System.out.println(exception.getMessage());
	}
}
public static Connection getConnection()
{
	try {

		String driver=prop.getProperty("driver");
		String url=prop.getProperty("url");
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
		Class.forName(driver);
		try {
			con=DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
}
}
