package com.bridgelabz.usermanagemant;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.usermanagemant.dao.UserDAO;
import com.bridgelabz.usermanagemant.dto.UserDTO;
/**********************************************************************************************************************************************************
 * @author Rupeshp007
 * date:28/12/2019
 * @version 1.0
 * Purpose:its a servlet to Register User into the application it will take user Inputs from user 
 * 
 * 		-username
 * 		-password
 * 		-firstName
 * 		-lastNAme
 * 		-address
 * 		-city
 * 		-state
 * 		-email
 * 		-pincode
 * 		-gender
 * 		-contact No.
 * 
 * before executing this Class first will execute Registration Filter to Validate Form.
 * 
 ***********************************************************************************************************************************************************/


@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet 
{
	//initialization 
	
	PrintWriter writer;
	RequestDispatcher dispatcher=null;
	
	//HttpServlet Class HttpServlet Class to Send Data to Browser and Data Base 
	
		public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
		{
			UserDTO user=new UserDTO();
			response.setContentType("text/html");
			writer=response.getWriter();
			user.setFirstName(request.getParameter("fname"));
			user.setLastName(request.getParameter("uname"));
			user.setAddress(request.getParameter("address"));
			user.setCity(request.getParameter("city"));
			user.setState(request.getParameter("state"));
			user.setEmail(request.getParameter("email"));
			user.setPincode(request.getParameter("pincode"));
			user.setUserName(request.getParameter("uname"));
			user.setPassword(request.getParameter("pwd"));
			user.setGender(request.getParameter("gender"));
			user.setContact(request.getParameter("contact"));
			
		
					int result=UserDAO.insert(user);
					System.out.println();
					if(result>0)
					{
						writer.print("You have Registered SuccessFully");
						dispatcher=request.getRequestDispatcher("login.jsp");
						dispatcher.include(request, response);
		
					}
					else
					{
						writer.println("<h3>You could not Registered yet try Again</h3>");
						dispatcher=request.getRequestDispatcher("register.jsp");
						dispatcher.include(request, response);
		
					}
		
			
			
		}
		/**To destroy All connection resorses*/
		@Override
		public void destroy()
		{
			UserDAO.closeConnection();
		}
}
