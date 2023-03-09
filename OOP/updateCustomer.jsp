<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% 
		String id=request.getParameter("id");//parameter name passed in the c tag library in useraccount.jsp
		String feedback=request.getParameter("feedback");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		
	
	%>   <!-- used to insert java codes inside the jsp page -->

	
	<form action="Update" method="post">
	
	<table>
	<tr>
		<td> feedback ID</td>
		<td> <input type="text" name="fid" value= "<%=id %>" readonly>  <!-- notation to use when a java variable is assigning to a input tag in form --></td>
	</tr>
	
	<tr>
		<td> feedback </td>
		<td> <input type="text" name="feedback" value= "<%=id %>" >  <!-- notation to use when a java variable is assigning to a input tag in form --></td>
	</tr>
	
	<tr>
		<td> Name</td>
		<td> <input type="text" name="name" value= "<%=name %>"></td>
	</tr>
	
	<tr>
		<td>Email </td>
		<td><input type="text" name="email" value= "<%=email %>"> </td>
	</tr>
	
	<tr>
		<td> Phone Number</td>
		<td> <input type="text" name="phone" value= "<%=phone %>"></td>
	</tr>
	
	
	</table>
	
		<br>
		
		<input type="submit" name="Submit" value="Update"><br>
	
	
	</form>
	
</body>
</html>