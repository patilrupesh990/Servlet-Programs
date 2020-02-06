<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<head>
<script>  
function validateemail()  
{  
var x=document.f1.email.value;  
var atposition=x.indexOf("@");  
var dotposition=x.lastIndexOf(".");  
if (atposition<1 || dotposition<atposition+2 || dotposition+2>=x.length){  
  alert("Please enter a valid e-mail address \n atpostion:"+atposition+"\n dotposition:"+dotposition);  
  return false;  
  }  
}  
</script>  
<style>
.table
{
 font-family: Tahoma;
 font-size: 14px;
 font-weight: bold;
 color: white;
}
</style>
</head>
<body  width="900">

<%@page import="java.util.Date"%>
	
		Date: <%= (new java.util.Date()).toLocaleString() %>
		
	
		
		<br><br><br><br>
		<form name="f1" action="register" method="post" onsubmit="return validateemail()" >
		<table class="table"  align="center" bgcolor="#CACFD2" width="100%">
				<tr bgcolor="#85929E">
					<td>FirstName</td><td><input type="text" width="30" name="fname" style="width: 259px; "></td>
				</tr>
				<tr bgcolor="#566573">
					<td>Last Name</td><td><input type="text" name="lname" style="width: 259px; "></td>
				</tr>
				<tr bgcolor="#566573">
					<td>Email</td><td><input type="text" name="email" style="width: 259px; "></td>
				</tr>
				<tr bgcolor="#2C3E50">
					<td>Address</td><td><input type="text" name="address" style="width: 259px; "></td>
				</tr>
				<tr bgcolor="#273746">
					<td>city</td><td><input type="text" name="city" style="width: 259px; "></td>
				</tr>
				<tr bgcolor="#212F3D">
					<td>state</td><td><input type="text" name="state" style="width: 259px; "></td>
				</tr>
				<tr bgcolor="#212F3D">
					<td>Pincode</td><td><input type="text" name="pincode" style="width: 259px; "></td>
				</tr>
				<tr bgcolor="#1C2833">
					<td>User Name</td><td><input type="text" name="uname" style="width: 259px; "></td>
				</tr>
				<tr bgcolor="#1C2833">
					<td>Password</td><td><input type="password" name="pwd" onchange="validatePassword()" required style="width: 259px; "></td>
				</tr>
				<tr bgcolor="#1C2833">
					<td>Re-Enter-Password</td><td><input type="password2"  onkeyup="validatePassword()" name="pwd" required style="width: 259px; "></td>
				</tr>
				<tr bgcolor="#17202A">
					<td>Gender</td><td><input type="radio" name="gender" value="Male">Male
										<input type="radio" name="gender" value="Female">Female
					</td>
				</tr>
				<tr bgcolor="#17202A" >
				
					<td>Contact</td><td><input type="text" id="n" name="contact"" style="width: 259px; "></td>
				</tr>
				<tr bgcolor="#2C3E50">
					<td align="center" style="height: 42px;"><input type="submit" align="middle" name="register" value="Register"  onclick="matchpass()" style="width: 211px; height: 36px"></td>
				</tr>
				
		</table>
		
		<p id="demo"></p>
		</form>
		
</body>
</html>