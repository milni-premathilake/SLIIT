<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- to call to the java page from jsp page -->

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>

	<table>
	
	<c:forEach var="feedback" items="${feedbackDetails}">
	
	<c:set var="id" value=" ${feedback.id}"/>
	<c:set var="feedback" value=" ${feedback.feedback}"/>
	<c:set var="name" value=" ${feedback.name}"/>
	<c:set var="email" value="  ${feedback.email}"/>
	<c:set var="phone" value="${feedback.phone}"/>

	
	<tr>
		<td> Feedback ID</td>
		<td> ${feedback.id}</td> <!-- internally calling getmethods in customer class -->
	</tr>
	
	<tr>
		<td>Feedback</td>
		<td>${feedback.feedback}</td>
	</tr>
	
	<tr>
		<td>Name</td>
		<td>${feedback.name}</td>
	</tr>
	
	<tr>
		<td> Customer email</td>
		<td> ${feedback.email}</td>
	</tr>
	
	<tr>
		<td> Customer phone</td>
		<td> ${feedback.phone}</td>
	</tr>
	

	</c:forEach>
	</table>
	
	<c:url value="updateCustomer.jsp" var="cusupdate">
		<c:param name="id" value="${id}"/> <!-- passing the var name passed in the c tag library in c set -->
		<c:param name="feedback" value="${feedback}"/>
		<c:param name="name" value="${name}"/>
		<c:param name="email" value="${email}"/>
		<c:param name="phone" value="${phone}"/>

		
	</c:url>
	
	<a href="${cusupdate}">
	<input type="button" name="update" value="Update">
	</a>
	
	<br><br>
	<c:url value="deleteCustomer.jsp" var="cusdelete">
	
		<c:param name="id" value="${id}"/> <!-- passing the var name passed in the c tag library in c set -->
		<c:param name="feedback" value="${feedback}"/>
		<c:param name="name" value="${name}"/>
		<c:param name="email" value="${email}"/>
		<c:param name="phone" value="${phone}"/>
		
	</c:url>
	
	<a href="${cusdelete }">
	<input type="button" name="delete" value="Delete">
	</a>
	
</body>
</html>