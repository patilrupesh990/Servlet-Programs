package com.bridgelabz.loginservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class OutputPage extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		session.getAttribute("address");
		writer.println("Wellcome Mr./Mrs. "+session.getAttribute("name")+" Your Address is "+session.getAttribute("address")
		+" "+session.getAttribute("city")+" "+ session.getAttribute("state")+" Your Contact Number Is "+session.getAttribute("Contact"));
	}
}
