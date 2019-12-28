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
			Class.forName("com.mysql.cj.jdbc.Driver");
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
	
	public static int insert(UservVo user)
	{
		connection=UserDAO.getConnection();
		int result=0;
		try{
			preparestatement=connection.prepareStatement("insert into Register values(?,?,?,?,?,?,?,?,?,?)");
			preparestatement.setString(1,user.getFirstName());
			preparestatement.setString(2,user.getLastName());
			preparestatement.setString(3, user.getUserName());
			preparestatement.setString(4, user.getAddress());
			preparestatement.setString(5, user.getCity());
			preparestatement.setString(6, user.getState());
			preparestatement.setString(7, user.getPincode());
			preparestatement.setString(8, user.getPassword());
			preparestatement.setString(9, user.getGender());
			preparestatement.setString(10, user.getContact());
			 result=preparestatement.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
