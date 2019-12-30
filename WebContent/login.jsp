<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<center>
		<form action="login" method="get">
			<br><br><br><br>
			<table>
			<tr><td>UserName :</td><td> <input type="text" name="uname"></td></tr>
			<tr><td>Password :</td><td> <input type="password" name="pwd"></td></tr>
			</table>
			<br><br>
			<input type="submit" value="Login" align="middle"><br>
			
			<a href="register.jsp">New User??</a><br>
			<a href="forgot.jsp">Forgot Your Password ??</a>
			<br>
			<span style="color: red;">${message}</span>
			
		</form>
		</center>
		
</body>
</html>