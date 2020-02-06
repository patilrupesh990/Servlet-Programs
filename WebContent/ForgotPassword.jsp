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
	
		Date: <%= (new java.util.Date()).toLocaleString()%>
		
		<form action="forgot" method="get">
			<center><a href="login.jsp">Cancel</a></center><br><br><br>
			contact/Mobile No : <input type="text" name="phno"><br>
			 New Password :<input type="password" name="pwd"><br>
			<input type="submit" value="Change"><br>
		</form>
		</center>
</body>
</html>