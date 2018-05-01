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
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Checkout</title>
</head>
<body>
	<div class="topnav">
		<a class="active" href="Main.jsp">Home</a> <a href="">Account</a> <a
			href="searchPage.jsp">Deals</a> 
	</div>
	<center>
		<h1>
			<i>CHECKOUT</i>
		</h1>
		<hr width=300>
		<br>
		<p id="checkout" onclick="myFunction()">
			<input type="submit" id="checkout" value="MAKE PURCHASE">
		</p>
	</center>

	<script>
		function myFunction() {
			document.getElementById("checkout").innerHTML = "Nice, you are buying something";
		}
	</script>

</body>
</html>