<%@page import="com.axelor.db.Contact"%>
<%@page import="com.axelor.db.Phone"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.axelor.db.Person"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Display Contact</title>
</head>
<body>
<%@include file="home.jsp" %>
	<%
	Person p=(Person)request.getAttribute("data");
	
	%>
		<table border=1 align="center">
		<tr>
		  <th>Phone Id</th>
		  <th>Phone type</th>
		  <th>Service provider</th>
		  <th>ContactNo</th>
		  <th>Update</th>
		  <th>Delete</th>
			</tr>
			<tr>
				<%
				List<Phone> ph=p.getPlist();
				for(Phone pno:ph){
				Contact c=pno.getContact();	
				%>
				<td><%= pno.getPhoneid() %></td>
				<td><%= pno.getPhone_type()%></td>
				<td><%= pno.getService_provider()%></td>
				<td><%= c.getCno()%></td>
				<td><a href='http://localhost:8080/restJspDemo/upCon/<%= pno.getPhoneid()%>'>Update</a></td>
				<td><a href='http://localhost:8080/restJspDemo/deleteCon/<%= pno.getPhoneid()%>'>Delete</a></td>				
			</tr>
			<%}%>
        </table>
</body>
</html>