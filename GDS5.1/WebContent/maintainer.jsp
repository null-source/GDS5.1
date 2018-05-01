<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
	background-color: white;
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
<title>Maintainer</title>
</head>
<body>
	<div class="topnav">
		<a class="active" href="maintainer.jsp">Home</a> <a class="active"
			href="#inventory">Inventory</a><a class="active" href="#alerts">Alerts</a>
		<a class="active" id="clock"
			onclick="getElementById('clock').innerHTML=Date()">Clock in/out</a> <a
			class="active" href="viewFiscInfo.jsp"> <a class="emp"
			href="Main.jsp">Logout</a>
	</div>
	<center>
		<h1>
			<i>MAINTAINER</i>
		</h1>

	</center>
	<div>
		<center>
			<h3>ALERTS</h3>
			<hr width=100>
			<div id="table-wrapper">
				<div id="table-scroll">
					<br>
					<table>
						<thead>
							<tr>
								<th><span class="Price">Date</span></th>
								<th><span class="Item">Alert</span></th>
							</tr>
						</thead>
						<tbody>
						<tr>
								<td>04/16/2018</td>
								<td>Iced coffee expires in 3 days</td>
							</tr>
							<tr>
								<td>04/14/2018</td>
								<td>Roasted turkey expires in 3 days</td>
							</tr>
						<tr>
								<td>04/12/2018</td>
								<td>Lemon muffins expire in 3 days</td>
							</tr>
							<tr>
								<td>04/10/2018</td>
								<td>Hotdog buns expire in 3 days</td>
							</tr>
							<tr>
								<td>04/09/2018</td>
								<td>Orange juice expires in 3 days</td>
							</tr>
							<tr>
								<td>04/04/2018</td>
								<td>Wheat bread expires in 3 days</td>
							</tr>
							<tr>
								<td>04/03/2018</td>
								<td>Bagels expire in 3 days</td>
							</tr>
							<tr>
								<td>04/03/2018</td>
								<td>Orange juice expires in 3 days</td>
							</tr>
							<tr>
								<td>04/02/2018</td>
								<td>Eggs expire in a week</td>
							</tr>
							<tr>
								<td>04/01/2018</td>
								<td>American cheese expires in 3 days</td>
							</tr>
							<tr>
								<td>04/01/2018</td>
								<td>Milk expires in 3 days</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</center>
	</div>
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