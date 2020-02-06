package com.bridgelabz.usermanagemant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabz.usermanagemant.dto.UserDTO;
/***********************************************************************************************************
 * @author Rupeshp007
 * date:02/01/2020
 * @version 1.0
 * Purpose: Its and DAO layer class of Servlet login it contains database connection object and database operations related methods
 * 			
 * -insert()
 * -update()
 * -authentication()
 * -checkEntry()
 * -getConnection()
 * 
 **********************************************************************************************************/

public class UserDAO 
{
	private static Connection connection;
	private static PreparedStatement preparestatement;
	private static ResultSet resultset;

	/*********************************************************************************
	 *  Static block to load Driver and prepare Connection for Mysql database
	 *******************************************************************************/
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
	/*********************************************************************************
	 *  private constructor to prevent Object creation
	 *******************************************************************************/
	private UserDAO() {
	}
	
	/*********************************************************************************
	 * To Provide Object of Connection class to calling methods.
	 * 
	 * @return Connection
	 *******************************************************************************/
	public static Connection getConnection()
	{
		return connection;
	}
	
	
	/***********************************************************************************************************************************************
	 *  To Authenticate User Before LogedIn To Application it will check username and password entered by user is Valid or not
	 *  
	 *  
	 *  @param String UserName,String password
	 *  @return Resultset
	 *******************************************************************************/

	public static ResultSet Authentication(String username,String password)
	{
		connection=UserDAO.getConnection();
		try
		{
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

	
	/*************************************************************************************************************************
	 * To check user is already registered or not it will check user by his Email and contact for Authenticate.
	 *  
	 *  @param UserDTO user
	 *  @return boolean
	 *******************************************************************************/
	public static boolean checkEntry(UserDTO user)
	{
		connection=UserDAO.getConnection();
		try{
			preparestatement=connection.prepareStatement("select * from Register");

			ResultSet resultset=preparestatement.executeQuery();
			while(resultset.next())
			{
				if(resultset.getString(11).equals(user.getEmail()));
				{
					System.out.println(resultset.getString(11)+"database");

					System.out.println(user.getEmail());
					System.out.println("hello");
					return false;
				}
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}
	
	
	/*************************************************************************************************************************
	 *  To update the Entry in database its use in Forgot Password of user to reset password  
	 *  @param UserDTO user
	 *  @return int
	 *******************************************************************************/
	
	public static int update(UserDTO user)
	{
		connection=UserDAO.getConnection();
		int result=0;
		try{
			preparestatement=connection.prepareStatement("update Register set password=? where  contact=?");
			preparestatement.setString(1,user.getPassword());
			preparestatement.setString(2,user.getContact());
			result=preparestatement.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	
	/*************************************************************************************************************************
	 * insert data into user data Table  its used to registration form of user.
	 *  
	 *  @param UserDTO user
	 *  @return int
	 *******************************************************************************/
	public static int insert(UserDTO user)
	{
		connection=UserDAO.getConnection();
		int result=0;
		try{
			preparestatement=connection.prepareStatement("insert into Register values(?,?,?,?,?,?,?,?,?,?,?)");
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
			preparestatement.setString(11, user.getEmail());
			result=preparestatement.executeUpdate();
			
			return result;

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}
	
	public static void closeConnection()
	{
		try {
			connection.close();
			preparestatement.close();
			resultset.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
