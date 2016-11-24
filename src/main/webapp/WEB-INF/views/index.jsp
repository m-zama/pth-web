<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<title>login</title>
</head>
<body>

	<a href="?locale=en">English</a>
	<a href="?locale=ja">Japanese</a>

	<h2>
		<spring:message code="welcome.message" htmlEscape="false" />
	</h2>
	<%-- 	<h2>${WelcomeMassage}</h2> --%>
	<h2>${jsonBean.hello}</h2>

	<form:form action="home" modelAttribute="homeForm">
		<table>
			<tr>
				<th colspan="2">Login Form</th>
			</tr>
			<tr>
				<th>Email:</th>
				<td><form:input type="text" path="email" /></td>
				<td><form:errors path="email" element="div"
						cssStyle="color:red" /></td>
			</tr>
			<tr>
				<th>Password:</th>
				<td><form:input type="password" path="password" /></td>
				<td><form:errors path="password" element="div"
						cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td></td>
				<td><form:button>login</form:button></td>
			</tr>
		</table>
	</form:form>
</body>
</html>