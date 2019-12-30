<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body text="white" width="900">

<%@page import="java.util.Date"%>
	
	<%Date date=null; 
		PrintWriter writer=response.getWriter();
		
	%>
	
		
	

		<form action="register" method="post"  >
		<table align="center" bgcolor="#CACFD2">
				<tr bgcolor="#85929E">
					<td>FirstName</td><td><input type="text" name="fname"></td>
				</tr>
				<tr bgcolor="#566573">
					<td>Last Name</td><td><input type="text" name="lname"></td>
				</tr>
				</tr>
				<tr bgcolor="#566573">
					<td>email</td><td><input type="text" name="email"></td>
				</tr>
				<tr bgcolor="#2C3E50">
					<td>Address</td><td><input type="text" name="address"></td>
				</tr>
				<tr bgcolor="#273746">
					<td>city</td><td><input type="text" name="city"></td>
				</tr>
				<tr bgcolor="#212F3D">
					<td>state</td><td><input type="text" name="state"></td>
				</tr>
				<tr bgcolor="#212F3D">
					<td>Pincode</td><td><input type="text" name="pincode"></td>
				</tr>
				<tr bgcolor="#1C2833">
					<td>User Name</td><td><input type="text" name="uname"></td>
				</tr>
				<tr bgcolor="#1C2833">
					<td>Password</td><td><input type="password" name="pwd"></td>
				</tr>
				<tr bgcolor="#17202A">
					<td>Gender</td><td><input type="radio" name="gender" value="Male">Male
										<input type="radio" name="gender" value="Female">Female
					</td>
				</tr>
				<tr bgcolor="#17202A" >
					<td>Contact</td><td><input type="text" name="contact"></td>
				</tr>
				<tr bgcolor="#2C3E50">
					<td><input type="submit" name="register" value="Register"></td>
				</tr>
				
		</table>
		
		</form>
</body>
</html>