<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Welcome!
	<h1>home</h1>
	<a href="<c:url value='/input'/>">Sign up</a>
<hr />
<table style="border-collapse:collapse;border:2px grey solid">
<tr><th style="background-color:grey;border:2px grey solid;padding:5px">Email:</th></tr>
	<c:forEach var="userList" items="${userList}">
	<tr><td style="border:2px grey solid;padding:5px">
		<c:out value="${userList.email}"></c:out>
		</td></tr>
	</c:forEach>
</table>
</body>
</html>