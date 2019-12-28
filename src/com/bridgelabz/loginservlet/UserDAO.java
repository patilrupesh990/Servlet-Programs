package com.bridgelabz.loginservlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO 
{
	private static Connection connection;
	private static PreparedStatement preparestatement;
	private static ResultSet resultset;
	
	static
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Login","root","1234Rp");
		} 
		catch (SQLException | ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
	private UserDAO() {
	}
	
	public static Connection getConnection()
	{
		return connection;
	}
	
	public static ResultSet Authentication(String username,String password)
	{
		
		connection=UserDAO.getConnection();
		
		try {
				preparestatement=connection.prepareStatement("select * from Register where UserName=? and password=?");
				preparestatement.setString(1, username);
				preparestatement.setString(2, password);
				resultset=preparestatement.executeQuery();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return resultset;

		
	}
	
	
}
