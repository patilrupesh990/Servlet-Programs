<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Login</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

<%@page import="java.util.Date"%>
	
		<b>Date: <%= (new java.util.Date()).toLocaleString()%></b>
		
		
	
		<center>
		<form action="login" method="Post">
		<div class="form-area">
			<div class="img-area">
			<img src="avatr.png" alt="">
			</div>
			<h2 class="h2_a">Login Form</h2>
			<p>UserName : </p>
			<input type="text" name="uname">
			<p>Password : </p>
			<input type="password" name="pwd">			
			
			<input type="submit"  class="btn-text" value="Login" >
			

			<a href="forgot.jsp"  class="for-pass">Forgot Password??</a> 
			<a href="register.jsp"  class="for-pass">New User??</a> 
			</div>
		</form>
		</center>
		
		
		
</body>
</html>