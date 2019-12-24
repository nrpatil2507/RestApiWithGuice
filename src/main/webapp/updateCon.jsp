<%@page import="com.axelor.db.Contact"%>
<%@page import="com.axelor.module.ContactModule"%>
<%@page import="com.axelor.db.Phone"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="UpdateCon">
		<%@include file="home.jsp"%>
		<%Phone p=(Phone)request.getAttribute("data");
		Contact c=p.getContact();
		%>
		<table border=1 width="500px" align="center">
			<tr>
				<th colspan="2">Update Person Contact</th>
			</tr><td><input type="hidden" name="pid" value="<%= p.getPhoneid()%>"></td>
						<tr>
							<td>Phone Type.</td>
							<td><input type="text" name="pt" value="<%=p.getPhone_type() %>"/></td>
						</tr>
						<tr>
							<td>Service Provider.</td>
							<td><input type="text" name="sr" value="<%=p.getService_provider() %>" /></td>
						</tr>
						<tr>
							<td>Contact No.</td>
							<td><input type="text" name="cno" value="<%=c.getCno() %>" /></td>
						</tr>
						<tr>
				<td></td>
				<td><input type="submit" name="submit" formaction="http://localhost:8080/restJspDemo/updateCon" value="Add" /> <input
					type="reset" name="reset" value="reset" /></td>
				

			</tr>
	</table>
</form>
</body>
</html>