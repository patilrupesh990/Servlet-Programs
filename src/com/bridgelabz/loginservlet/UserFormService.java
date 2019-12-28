package com.bridgelabz.loginservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class UserFormService extends HttpServlet
{
	RequestDispatcher dispature;
	PrintWriter writer;
	String Login;
	String Register;
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{

		response.setContentType("text/html");
		writer=response.getWriter();
		
		try{
		 Login=request.getParameter("Login");
		 Register=request.getParameter("Register");
		}catch (NullPointerException e) {
	
		}
		if(Login!=null)
		{
			dispature=request.getRequestDispatcher("login.jsp");
			try {
				dispature.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
		else
		{
			dispature=request.getRequestDispatcher("register.jsp");
			try {
				dispature.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
	}
}
