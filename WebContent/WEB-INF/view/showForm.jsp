<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

<form:form action="authenticate" method="Post" ModelAttribute="prachi" >

<form:input path="firstName" />

<form:input path="lastName" />

<form:input path="email"/>

<input type="submit" value="Click here"/>

</form:form>

 


</body>
</html>