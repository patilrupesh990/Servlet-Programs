package com.bridgelabz.usermanagemant;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.usermanagemant.dao.UserDAO;
import com.bridgelabz.usermanagemant.dto.UserDTO;
/***********************************************************************************************************
 * @author Rupeshp007
 * date:28/12/2019
 * @version 1.0
 * Purpose: Its Servlet to Logout by user and It will invalidate session object and remove attribute and will be redirect to the 
 * 			Login page
 * 
 * 
 * 
 ***********************************************************************************************************************************************************/

@SuppressWarnings("serial")
@WebServlet("/forgot")
public class ForgotPasswordServlet extends HttpServlet
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
