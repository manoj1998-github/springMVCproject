<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Manager</title>
</head>
<body>

	<div align="center">
		<h1>Customer Manager</h1>
		<form method="get" action="search">
			<input type="text" name="keyword" /> 
			<input type="submit" value="search" />
				
		</form>
		<h3><a href="new">New Customer</a></h3>
		<table border="2" cellpadding="5">
		<tr> 
		<th> ID </th>
		<th> NAME </th>
		<th> E-MAIL </th>
		<th> ADDRESS </th>
		<th> ACTION </th>
		</tr>
		<c:forEach items="${listCustomer}" var="customer">
		<tr> 
		<td>${customer.id}</td>
		<td>${customer.name}</td>
		<td>${customer.email}</td>
		<td>${customer.address}</td>
		<td> 
		 <a href="edit?id=${customer.id}">Edit</a>
		 &nbsp &nbsp  &nbsp  &nbsp
		  <a href="delete?id=${customer.id}">Delete</a>
		</td>
		</tr>
		
		</c:forEach>
	</table>

	</div>
</body>
</html>