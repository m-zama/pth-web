<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>index</title>
</head>
<body>
	<h1>SigninForm</h1>
	<a href="<c:url value='/home'/>">Entry</a>
	<form:form action="home" modelAttribute="entryForm">
	<table>
    <tr><th>Email:</th><td><form:input type="text" path="email" /></td><td><form:errors path="email" element="div" cssStyle="color:red"/></td></tr>
    <tr><th>Password:</th><td><form:input type="password" path="password" /> </td><td><form:errors path="password" element="div" cssStyle="color:red"/></td></tr>
		<tr><td></td><td><form:button>Signin</form:button></td></tr>
	</table>
	</form:form>
</body>
</html>