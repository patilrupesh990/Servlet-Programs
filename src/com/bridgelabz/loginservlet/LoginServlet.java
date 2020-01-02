package com.bridgelabz.loginservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/***********************************************************************************************************
 * @author Rupeshp007
 * date:28/12/2019
 * @version 1.0
 * Purpose: Its Servlet to Login by user It will Take UserName And password as a user it will authentic the user with username and password if correct 
 * 			user will loggedIn.
 * 
 * 		-Login
 * 		-register User
 * 		-Forgot password
 * 
 * 
 ***********************************************************************************************************************************************************/
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet
{
	private ResultSet resultSet;
	PrintWriter writer;
	HttpSession session;
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		response.setContentType("text/html");
		writer=response.getWriter();
		session=request.getSession();
		
		String userName=request.getParameter("uname");
		String password=request.getParameter("pwd");
		resultSet=UserDAO.Authentication(userName, password);
		
		
		
		try {
			
					if(resultSet.next())
					{
						session.setAttribute("name",resultSet.getString(1));
						session.setAttribute("address",resultSet.getString(4));
						session.setAttribute("city",resultSet.getString(5));
						session.setAttribute("state",resultSet.getString(6));
						session.setAttribute("Contact",resultSet.getString(10));
						RequestDispatcher dispatcher=request.getRequestDispatcher("output.jsp");
						dispatcher.forward(request, response);
					}
					else
					{
						writer.println("Invalid UserName and Password");
			            response.sendRedirect("login.jsp");

					}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**To destroy All connection resources*/

	@Override
	public void destroy()
	{
		UserDAO.closeConnection();
	}
}
