<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.axelor.db.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Contact Detail</title>
</head>
<body>

	<form method="post" action="insertCon">
		<%@include file="home.jsp"%>
		<table border=1 width="500px" align="center">
			<tr>
				<th colspan="2">Person Contact Add</th>
			</tr>

			<tr>
				<td>User</td>
				<td>
					<%	
						List<Person> per = (ArrayList<Person>)request.getAttribute("data");
						out.println("<select name='person_id' width='200px'>");
						for (Person person : per) {
							
							out.println("<option value=" + person.getPid() + "> " + person.getFname() + " " 
									+ person.getLname() + " </option> ");
						}
						out.println("</select>");
					%>
				</td>
			</tr>
			<tr>
				<td>Contact Details</td>
				<td>
					<table>
						<tr>
							<td>Phone Type.</td>
							<td><input type="text" name="phone_type" /></td>
						</tr>
						<tr>
							<td>Service Provider.</td>
							<td><input type="text" name="sr" /></td>
						</tr>
						<tr>
							<td>Contact No.</td>
							<td><input type="text" name="cno" /></td>
						</tr>
					</table>
				</td>
			</tr>

			<tr>
				<td>
				<td><input type="submit" name="submit" value="Add" /> <input
					type="reset" name="reset" value="reset" /></td>
				</td>

			</tr>
		</table>
	</form>

</body>
</html>
