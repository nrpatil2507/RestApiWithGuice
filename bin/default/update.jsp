<%@page import="java.util.ArrayList"%>
<%@page import="com.axelor.db.Person"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update data</title>
</head>
<body>
<%@include file="home.jsp" %>
<form method="post" action="http://localhost:8080/restJspDemo/update">
	<%
	Person p=(Person)request.getAttribute("data");
	
	%>
	<table border=1 align="center" width="500">
		<tr>
			<th colspan="2">Insert Person Details</th>
		</tr>
		<tr>
		<td><input type="hidden" name="id" value=<%= p.getPid()%> /></td>
		</tr>
		<tr>
			<td>First Name</td>
			<td><input type="text" name="fname" value=<%= p.getFname() %> /></td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><input type="text" name="lname" value=<%= p.getLname() %> /></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="text" name="email" value=<%= p.getEmail() %> /></td>
		</tr>
			<tr>
			<td>Address</td>
			<td><input type="text" name="add" value=<%= p.getAdd() %> /></td>
		</tr>
		<tr>
			<td><td><input type="submit" name="submit" value="update" />
			<input type="reset" name="reset" value="reset" /></td>

		</tr>
	</table>
	</form>

</body>
</html>