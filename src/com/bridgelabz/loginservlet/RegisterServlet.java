package com.bridgelabz.loginservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet 
{
	PrintWriter writer;
	RequestDispatcher dispatcher;
		public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
		{
			UservVo user=new UservVo();
			response.setContentType("text/html");
			writer=response.getWriter();
			user.setFirstName(request.getParameter("fname"));
			user.setLastName(request.getParameter("uname"));
			user.setAddress(request.getParameter("address"));
			user.setCity(request.getParameter("city"));
			user.setState(request.getParameter("state"));
			user.setPincode(request.getParameter("pincode"));
			user.setUserName(request.getParameter("uname"));
			user.setPassword(request.getParameter("pwd"));
			user.setGender(request.getParameter("gender"));
			user.setContact(request.getParameter("contact"));
			
			int result=UserDAO.insert(user);
			
			if(result>0)
			{
				writer.println("You have Registered SuccessFully");
				dispatcher=request.getRequestDispatcher("register.jsp");
				dispatcher.include(request, response);

			}
			else
			{
				writer.println("You could not Registered yet try Again");
				dispatcher=request.getRequestDispatcher("register.jsp");
				dispatcher.include(request, response);

			}
		}
}
