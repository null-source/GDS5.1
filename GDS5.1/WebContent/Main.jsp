<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
	background-color: white;
	font-family: "helvetica";
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

.topnav a.emp {
	float: right;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 14px;
}

.topnav a.emp:hover {
	background-color: #ddd;
	color: black;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GDS</title>
</head>
<body>
	<div class="topnav">
		<a class="active" href="customerLogin.jsp">Login</a> <a
			href="register.jsp">Register</a> <a href="searchPage.jsp">Browse</a>
		<a href="cart.jsp">Cart</a> <a class="emp"
			href="EmployeeLogin.jsp">Employees</a>
	</div>

	<center>
		<h1>
			<i> G R O C E R Y &ensp; D E L I V E R Y &ensp; S E R V I C E</i>
		</h1>
	</center>
	<center>
		<br>
		<table>
			<tr>
				<td><input type="text" name="searchProducts"></td>
				<!-- SEARCH BUTTON, TEMP LINKED TO searchPage.jsp -->
				<td><a href="searchPage.jsp"><input type="submit"
						value="SEARCH"></a></td>

			</tr>
		</table>
		<br>
		<!--  
		<br> <a href="customerLogin.jsp">Login</a> <br> <a
			href="register.jsp">Register</a> <br> <br>
		-->
	</center>
	<div
		style='position: background; z-index: 0; left: 0; top: 0; width: 100%; height: 50%'>
		<center>
			<img src='gds-welcome.gif' style='width: 524px; height: 274px'
				alt='[]' />
		</center>
	</div>
	<!--  
	<div style="position: absolute; bottom: 5px; background-color: linen">
		<a href="EmployeeLogin.jsp">EMPLOYEES</a>
	</div>
	-->

</body>
</html>