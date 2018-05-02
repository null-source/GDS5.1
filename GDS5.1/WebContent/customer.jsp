<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="application.model.Customer" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Account Page</title>
<style>
body {
	background-color: linen;
	font-family: "helvetica";
}
p.oneLine {
	font-family: comic sans;
	font-size: 18px;
}
</style>
</head>
<body>
	<i><p class="oneLine">ACCOUNT PAGE</p></i>
	<br>
	<a href="Main.jsp">GO TO HOMEPAGE</a>
	<br>
	<br>
	
	<%
		Customer c = (Customer) session.getAttribute("user");
		out.println("Hi <b>" + c.getFullname() +"</b>, this is your Account Page!<br><br>");
		String address;
		String email = c.getEmail();
		if (c.getDeliveryInfo() == null)
			address = "address not specified";
		else {
			address = c.getDeliveryInfo();
		}
	%>
	<% 
		out.println("Your email: <i>" + email + "</i><br>");
		out.println("Your delivery address: <i>" + address + "</i>");
	%>
	<div style="position: absolute; bottom: 5px; background-color: linen">
		<form action="Logout" method="post">
			<button name="Logout" type="submit">Logout</button>
		</form>
	</div>
</body>
</html>