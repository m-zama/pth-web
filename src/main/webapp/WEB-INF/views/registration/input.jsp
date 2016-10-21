<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>input</title>
</head>
<body>
<h2>input your Email and Password.</h2>
	<form:form action="confirm" modelAttribute="homeForm">
	<table>
    <tr><th>Email:</th><td><form:input type="text" path="email" /></td><td><form:errors path="email" element="div" cssStyle="color:red"/></td></tr>
    <tr><th>Password:</th><td><form:input type="password" path="password" /> </td><td><form:errors path="password" element="div" cssStyle="color:red"/></td></tr>
		<tr><td></td><td><form:button>confirm</form:button></td></tr>
	</table>
	</form:form>
</body>
</html>