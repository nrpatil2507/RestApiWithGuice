<%@page import="com.axelor.entity.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="home.jsp" %>
<form method="post" action="insert">
	
	<table border=1 align="center">
		<tr>
			<th colspan="2">Insert Person Details</th>
		<tr>
			<td>First Name</td>
			<td><input type="text" name="fname" /></td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><input type="text" name="lname" /></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="text" name="email" /></td>
		</tr>
			<tr>
			<td>Address</td>
			<td><input type="text" name="add" /></td>
		</tr>
		<tr>
			<td><td><input type="submit" name="submit" value="insert" />
			<input type="reset" name="reset" value="reset" /></td>

		</tr>
	</table>
	</form>
</body>
</html>
