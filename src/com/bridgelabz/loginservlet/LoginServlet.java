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

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet
{
	private ResultSet resultSet;
	PrintWriter writer;
	HttpSession session;
	RequestDispatcher dispatcher;
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
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
				dispatcher=request.getRequestDispatcher("output");
				try {
					dispatcher.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
			}
			else
			{
				writer.println("Invalid UserName and Password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
