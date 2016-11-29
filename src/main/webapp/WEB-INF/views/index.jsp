<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<!-- <link rel="stylesheet" type="text/css" href="/css/main.css""> -->
<title>login</title>
</head>
<body>

	<a href="?locale=en">English</a>
	<a href="?locale=ja">Japanese</a>

	<p>
		<spring:message code="welcome.message" htmlEscape="false" />
	</p>
	<%-- 	<h2>${WelcomeMassage}</h2> --%>
	<p>JSON:${jsonBean.hello}</p>

	<form:form action="home" modelAttribute="homeForm">
		<table style="border-collapse: collapse; border: 2px grey solid">
			<tr>
				<th
					style="background-color: grey; border: 2px grey solid; padding: 5px">Login
					Form</th>
			</tr>
			<tr>
				<td>Email:<form:input
						type="text" path="email" /></td>
			</tr>
			<tr>
			<td>
				<form:errors path="email" element="div" cssStyle="color:red" />
			</td>
			</tr>
			<tr>
				<td>
					Password:<form:input type="password" path="password" />
				</td>
			</tr>
			<tr>
			<td>
				<form:errors path="password" element="div" cssStyle="color:red" />
			</td>
			</tr>
			<tr>
				<td><form:button>login</form:button></td>
			</tr>
		</table>
	</form:form>
</body>
</html>