<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Prachi</title>
</head>
<body>
<table>
<form:form action="authenticate" method="post" modelAttribute="prachi" >
<tr><td>Name</td><td> <form:input path="firstName"/></td></tr>
<tr><td>Last</td><td> <form:input path="lastName"/></td></tr>
<tr><td>email</td><td> <form:input path="email"/></td></tr>
 
 
<tr><td><form:button>submit</form:button></td></tr>
</form:form>
</table>
</body>
</html>