<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- VIEW ORDERS FOR THE SHOPPER. -->
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
<title>GDS - Employees</title>
</head>
<body>

	<div class="topnav">
		<a class="active" href="manager.jsp">Home</a> <a class="active"
			href="#orders">Orders</a> <a class="active" href="#inventory">Inventory</a>
		<a class="active" href="viewFiscInfo.jsp">Financial Information</a> <a
			class="emp" href="Main.jsp">Logout</a>
	</div>

	<a href="manager.jsp">BACK</a>
	<center>
		<h1>
			<i>EMPLOYEE MANAGEMENT</i>
		</h1>
	</center>
	<hr width=200>
	<br>
	<center>
		<img src="gds_logo.jpg" style="width: 222px; height: 107px;">
	</center>

	<center>
		<div id="table-wrapper">
			<div id="table-scroll">
				<br>
				<table>
					<thead>
						<tr>
							<th><span class="Price">Employee Name</span></th>
							<th><span class="Price">ID</span></th>
							<th><span class="Item">Type</span></th>
						</tr>
					</thead>
					<tbody>
					<!-- Placeholder testing. -->
						<tr>
							<td>Brenda Trejo</td>
							<td>a001</td>
							<td>1</td>
						</tr>
						<tr>
							<td>Shane Bogard</td>
							<td>a002</td>
							<td>2</td>
						</tr>
						<tr>
							<td>Jordan McCarthy</td>
							<td>a003</td>
							<td>3</td>
						</tr>
						<tr>
							<td>Daniel Ghazvini</td>
							<td>a004</td>
							<td>0</td>
						</tr>
						<tr>
							<td>Stephanie Callahan</td>
							<td>a005</td>
							<td>2</td>
						</tr>
						<tr>
							<td>Clarence Bumanglag</td>
							<td>a006</td>
							<td>0</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</center>

</body>
</html>