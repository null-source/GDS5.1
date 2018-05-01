<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
	background-color: "white"";
}

td {
	text-align: center;
	vertical-align: middle;
}

.topnav {
	overflow: hidden;
	background-color: #133251;
}

.topnav a {
	float: left;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 14px;
}

.topnav a:hover {
	background-color: #ddd;
	color: black;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<div class="topnav">
		<a class="active" href="Main.jsp">Home</a> 
	</div>
	<center>
		<form action="CustomerLogin" method="POST">
		<h1>Login</h1>
		<table>
			<tr>
				<td>Email<br>
				<input type="text" name="customersEmail"></td>
			</tr>
			<tr>
				<td>Password<br>
				<input type="password" name="customersPassword"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
		</form>
		<hr width=210>
		<p>
			New to the grocery delivery system? <br> <a href="register.jsp">Register</a>
		</p>
	</center>
</body>
</html>