<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
#table-wrapper {
	position: relative;
}

#table-scroll {
	height: 200px;
	overflow: auto;
	margin-top: 20px;
}

#table-wrapper table {
	width: 50%;
}

#table-wrapper table * {
	background: white;
	color: black;
}

#table-wrapper table thead th .text {
	position: left;
	top: -20px;
	z-index: 2;
	height: 20px;
	width: 35%;
	border: 1px solid black;
}
table {
	border-collapse: collapse;
}

table, th, td {
	border: 1px solid black;
}

td {
	text-align: left;
	vertical-align: middle;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Driver</title>
</head>
<body>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

	if(session.getAttribute("user") == null)
		response.sendRedirect("Main.jsp");

%>
	<div class="topnav">
		<a class="active" href="Main.jsp">Home</a> <a class="active"
			href="#orders">Orders</a>
		<a class ="active" href="currentOrderDriver.jsp">Current Order</a>
			<a class="active" id="clock" onclick="getElementById('clock').innerHTML=Date()">Clock in/out</a>
		<a class="active" href="viewFiscInfo.jsp">
	</div>
	<center>
		<h1>
			<i>DRIVER</i>
		</h1>
	</center>
	
	<div>
		<h3><u>Available Orders</u></h3>
	</div>
	<div id="table-wrapper">
			<div id="table-scroll">
				<br>
				<table>
					<thead>
						<tr>
							<th><span class="Price">Order ID</span></th>
							<th><span class="Item">Description</span></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>8888</td>
							<td>Adam Scott: Pencil</td>
					</tbody>
				</table>
			</div>
		</div>
	
	<form action="Logout" method="post">
	<input type="submit" value="Logout">
	</form>
</body>
</html>