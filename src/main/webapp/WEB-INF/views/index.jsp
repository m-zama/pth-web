<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>login</title>
</head>
<body>
	<h1>login</h1>
	<form:form action="home" modelAttribute="homeForm">
	<table>
    <tr><th>Email:</th><td><form:input type="text" path="email" /></td><td><form:errors path="email" element="div" cssStyle="color:red"/></td></tr>
    <tr><th>Password:</th><td><form:input type="password" path="password" /> </td><td><form:errors path="password" element="div" cssStyle="color:red"/></td></tr>
		<tr><td></td><td><form:button>Sign in</form:button></td></tr>
	</table>
	</form:form>
</body>
</html>