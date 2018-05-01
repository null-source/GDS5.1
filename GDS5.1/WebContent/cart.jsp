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

#table-wrapper {
	position: relative;
}

#table-scroll {
	height: 150px;
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
	position: absolute;
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

.topnav a.checkout {
	float: right;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 14px;
}

.topnav a.checkout:hover {
	background-color: #ddd;
	color: black;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Your cart</title>
</head>
<body>
	<div class="topnav">
		<a class="active" href="Main.jsp">Home</a> <a href="">Account</a> <a
			href="searchPage.jsp">Deals</a> <a class="checkout"
			href="checkout.jsp">Checkout</a>
	</div>
	<center>
		<h1>
			<i>CART</i>
		</h1>
		<div id="table-wrapper">
			<div id="table-scroll">
				<table>
					<thead>
						<tr>
							<th><span class="Price">Price</span></th>
							<th><span class="Item">Item</span></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>29.99</td>
							<td>Golden Apple</td>
						<tr>
							<td>.99</td>
							<td>Red Apple</td>
						<tr>
							<td>29.99</td>
							<td>Water</td>
						<tr>
							<td>5.99</td>
							<td>Mayo</td>
						<tr>
							<td>12.99</td>
							<td>Coffee</td>
						<tr>
							<td>5.99</td>
							<td>Creamer</td>
						<tr>
							<td>5.99</td>
							<td>Goat cheese</td>
					</tbody>
				</table>
			</div>
		</div>
		<br> <input type="submit" id="removeItem" value="REMOVE ITEM">
		
	</center>
</body>
</html>