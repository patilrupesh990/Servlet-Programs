package com.bridgelabz.loginservlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/forgot")
public class ForgotPassword extends HttpServlet
{
	PrintWriter writer;
	HttpSession session;
	RequestDispatcher dispatcher;
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		UserDTO user=new UserDTO();
		response.setContentType("text/html");
		writer=response.getWriter();
		session=request.getSession();
		String Mobile=request.getParameter("phno");
		user.setContact(Mobile);
		String password=request.getParameter("pwd");
		user.setPassword(password);
		
		int result=UserDAO.update(user);
		if(result>0)
			writer.print("Your Password Updated SuccessFully");
		else
			writer.println("<H2 FONT COLOR:RED> Please Check your Contact Number Or Register</H2>");
		
	}
}
