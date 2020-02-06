<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Guru Logged In</title>
</head>
<body>
<form action="logout" method="get">

<% String user = null;
if(session.getAttribute("name") == null){
	response.sendRedirect("login.jsp");
}else user = (String) session.getAttribute("user");%>
<%@page import="java.util.Date"%>
	Date: <%= (new java.util.Date()).toLocaleString()%>
	
	<table style="with: 50%">
	<tr><td>
	
	
		
		<% out.println("Wellcome Mr./Mrs. ");%> ${name} <%out.println("Your Address is ");%> <%out.print(" ");%> ${address} <% out.print(" ");%>  ${city}  <% out.print(" ");%>  ${state} <% out.print(" Your Contact Number Is ");%> ${Contact} 
	
	
          // reuse existing %>
	
</table>

	<input type="submit" value="Logout">
	</form>
</body>
</html>