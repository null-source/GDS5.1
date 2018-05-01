<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager</title>
</head>
<body>
	<!-- Redirects user to EmployeeLogin.jsp if they are logged out -->
	<%
		//if(session.getAttribute("username") == null) {
		//response.sendRedirect("EmployeeLogin.jsp");
		//}
	%>


	<div class="topnav">
		<a class="active" href="manager.jsp">Home</a> <a class="active"
			href="#orders">Orders</a> <a class="active" href="#inventory">Inventory</a>
		<a class="active" href="viewFiscInfo.jsp">Financial Information</a> <a
			class="active" href="employeeManagement.jsp">Employee Management</a>
		<a class="emp" href="Main.jsp">Logout</a>
	</div>

	<center>
		<h1>
			<i>MANAGER</i>
		</h1>
	</center>
	<hr width=200>
	<br>
	<center>
		<img src="gds_logo.jpg" style="width: 222px; height: 107px;">
	</center>
	<br>
	<div>
		<h3 id="orders">
			<u>Orders</u>
		</h3>

		<input type="text" name="orderID"> <input type="submit"
			value="SEARCH">

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
							<td>1492</td>
							<td>Sam Wise: Bread</td>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<br>
	<div>
		<h3 id="inventory">
			<u>Inventory</u>
		</h3>
		<input type="text" name="orderID"> <input type="submit"
			value="SEARCH">
		<div id="table-wrapper">
			<div id="table-scroll">
				<br>
				<table>
					<thead>
						<tr>
							<th><span class="Price">Product ID</span></th>
							<th><span class="Item">Description</span></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1234</td>
							<td>Golden Apple</td>
					</tbody>
				</table>
			</div>
		</div>
	<br>
	</div>




</body>
</html>