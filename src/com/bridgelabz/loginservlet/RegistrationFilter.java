package com.bridgelabz.loginservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class RegistrationFilter
 */
@WebFilter("/register")
public class RegistrationFilter implements Filter {

   PrintWriter writer;
   
   
	
	public void destroy() {
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		writer=response.getWriter();
		
		String error_fname="",error_address = "",error_city="",error_state="",error_pincode="",error_uname="",error_pwd="",error_contact="";
		
		String firstName=request.getParameter("fname");
		String lastname=request.getParameter("lname");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		System.out.println(state);
		String pincode=request.getParameter("pincode");
		String userName=request.getParameter("uname");
		String password=request.getParameter("pwd");
		String contact=request.getParameter("contact");
		
		
		boolean flag=true;
		
		if(firstName.equals(null)||firstName.equals(""))
		{
			error_fname="Student Name is required";
			flag=false;
		}
		if(address.equals(null)||address.equals(""))
		{
			error_address="you have to entered Address";
			flag=false;
		}
		if(city.equals(null)||city.equals(""))
		{
			error_city="you have to entered city";
			flag=false;
		}
		if(state.equals(null)||state.equals(""))
		{
			error_state="state must need to enter";
			flag=false;
		}
		if(pincode.equals(null)||pincode.equals(""))
		{
			error_pincode="you must need to enter pincode";
			flag=false;
		}
		
		if(userName.equals(null)||userName.equals(""))
		{	
			error_uname="you must entered userName";
			flag=false;
		}
		if(password.equals(null)||password.equals(""))
		{
			error_pwd="you must entered password";
			flag=false;
		}
		if(contact.equals(null)||contact.equals(""))
		{
			error_contact="you must entered Contact Number";
			flag=false;
		}
		if(flag==true)
			chain.doFilter(request, response);
		else
		{
			writer.println("<body text='white' width='900'>");
			writer.println("<form action='register' method='post'>");
			writer.println("<table align='center' bgcolor='#CACFD2'>");
			
			writer.println("<tr bgcolor='#85929E'>");
			writer.println("<td>FirstName</td><td><input type='text' name='fname' value='"+firstName+"'></td>");
			writer.println("<td><font color='red' size='2'><b>*"+error_fname+"</b></td></tr>");
			
			writer.println("<tr bgcolor='#566573'>");
			writer.println("<td>Last Name</td><td><input type='text' name='lname' value='"+lastname+"'></td></tr>");
		
			writer.println("<tr bgcolor='#2C3E50'>");
			writer.println("<td>Address</td><td><input type='text' name='address' value='"+address+"'></td>");
			writer.println("<td><font color='red' size='2'><b>*"+error_address+"</b></td></tr>");
		
			writer.println("<tr bgcolor='#273746'>");
			writer.println("<td>city</td><td><input type='text' name='city' value='"+city+"'></td>");
			writer.println("<td><font color='red' size='2'><b>*"+error_city+"</b></td></tr>");

			writer.println("<tr bgcolor='#212F3D'>");
			writer.println("<td>state</td><td><input type='text' name='state' value='"+state+"'></td>");
			writer.println("<td><font color='red' size='2'><b>*"+error_state+"</b></td></tr>");

			writer.println("<tr bgcolor='#212F3D'>");
			writer.println("<td>Pincode</td><td><input type='text' name='pincode' value='"+pincode+"'></td>");
			writer.println("<td><font color='red' size='2'><b>*"+error_pincode+"</b></td></tr>");
			
			writer.println("<tr bgcolor='#1C2833'>");
			writer.println("<td>User Name</td><td><input type='text' name='uname' value='"+userName+"'></td>");
			writer.println("<td><font color='red' size='2'><b>*"+error_uname+"</b></td></tr>");
			
			writer.println("<tr bgcolor='#1C2833'>");
			writer.println("<td>User Name</td><td><input type='text' name='password' value='"+password+"'></td>");
			writer.println("<td><font color='red' size='2'><b>*"+error_pwd+"</b></td></tr>");
						
			writer.println("<tr bgcolor='#17202A'>");
			writer.println("<td>Gender</td><td><input type='radio' name='gender' value='Male'>Male<input type='radio' name='gender' value='Female'>Female</td>");
			
			writer.println("<tr bgcolor='#17202A'>");
			writer.println("<td>Contact</td><td><input type='text' name='contact' value='"+contact+"'></td>");
			writer.println("<td><font color='red' size='2'><b>*"+error_contact+"</b></td></tr>");
		
			writer.println("<tr bgcolor='#2C3E50'>");
			writer.println("<td><input type='submit' name='register' value='Register'></td>");
					
			writer.println("</table>");
			writer.println("</form>");
			writer.println("</body>");

	
		}
		
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException 
	{
		
	}

}
