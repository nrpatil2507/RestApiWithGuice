<%@page import="com.axelor.db.Person"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.http.HttpRequest"%>
<%@page import="javax.ws.rs.core.Request"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Student detail</title>
</head>
<body>
<%@include file="home.jsp" %>
	<%
	List<Person> s=(ArrayList<Person>)request.getAttribute("data");
	
	%>
		<table border=1 align="center">
		<tr>
		
		  <th>Fname</th>
		  <th>Lname</th>
		  <th>Add</th>
		  <th>email</th>
		  <th>ShowContact</th>
		  <th>Update</th>
		  <th>Delete</th>
		 
			</tr>
			<%for(Person p :s){%>
			<tr>
				<td><%= p.getFname() %></td>
				<td><%= p.getLname()%></td>
				<td><%= p.getAdd()%></td>
				<td><%= p.getEmail() %></td>
				<td><a href='http://localhost:8080/restJspDemo/showContact/<%= p.getPid()%>'>ShowContact</a></td>	
				<td><a href='http://localhost:8080/restJspDemo/up/<%= p.getPid()%>'>Update</a></td>
				<td><a href='http://localhost:8080/restJspDemo/delete/<%= p.getPid()%>'>Delete</a></td>				
			</tr>
			
			<% }%>
        </table>
	
</body>
</html>
