<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>confirm</title>
</head>
<h2>Do you sign up for an account with this content?</h2>
<table>
<tr><th>Email:</th><td><c:out value="${homeForm.email}"></c:out></td></tr>
<tr><th>Password:</th><td><c:out value="${homeForm.password}"></c:out></td></tr>
<tr><td></td><td>
<form:form action="complete" modelAttribute="homeForm">
<form:hidden path="email" value="${homeForm.email}"/>
<form:hidden path="password" value="${homeForm.password}"/>
<form:button>sign up</form:button>
</form:form></td></tr>

</table>
<body>

</body>
</html>