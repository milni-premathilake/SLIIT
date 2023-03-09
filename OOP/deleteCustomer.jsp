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
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		
	
	%>   <!-- used to insert java codes inside the jsp page -->
	
	<h1>Customer Account Delete</h1>
	<form action="delete" method="post">
	
	<table>
	<tr>
		<td> Customer ID</td>
		<td> <input type="text" name="cusid" value= "<%=id %>" readonly>  <!-- notation to use when a java variable is assigning to a input tag in form --></td>
	</tr>
	
	<tr>
		<td> Name</td>
		<td> <input type="text" name="name" value= "<%=name %>"readonly></td>
	</tr>
	
	<tr>
		<td>Email </td>
		<td><input type="text" name="email" value= "<%=email %>"readonly> </td>
	</tr>
	
	<tr>
		<td> Phone Number</td>
		<td> <input type="text" name="phone" value= "<%=phone %>"readonly></td>
	</tr>
	
	<tr>
		<td>User Name </td>
		<td><input type="text" name="uname" value= "<%=username %>"readonly></td>
	</tr>
	

	</table>
	
		<br>
		
		<input type="submit" name="Submit" value="Delete my account"><br>
	
	
	</form>
</body>
</html>