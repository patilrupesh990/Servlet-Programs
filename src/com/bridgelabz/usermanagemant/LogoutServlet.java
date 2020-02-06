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

import org.omg.DynamicAny.DynAnyOperations;

import com.bridgelabz.usermanagemant.dao.UserDAO;
@SuppressWarnings("serial")

/*************************************************************************************************************************
 *  @author Rupeshp007
 * date:28/12/2019
 * @version 1.0
 * 
 * Its Servlet class Executes Bebofe Logout It will invalidate Session and redirect user to Login Page
 * 
 * url-pattern="logout"
 * 
 *******************************************************************************/
public class LogoutServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	      PrintWriter out = response.getWriter();
	      HttpSession session = request.getSession(true);
	      // session.setAttribute("user", null);
	      session.removeAttribute("address");
	      session.removeAttribute("city");
	      session.removeAttribute("state");
	      session.removeAttribute("Contact");

	      

	      
	      out.println("thank you!!, Your session was destroyed successfully &"
	      		+ " Logout successfully!!");
	      
	            session.removeAttribute("name");
	            session.invalidate();
	            RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
	            dispatcher.include(request, response);
	     
	}
	
	/**To destroy All connection resources*/

	@Override
	public void destroy()
	{
		UserDAO.closeConnection();
	}
}
