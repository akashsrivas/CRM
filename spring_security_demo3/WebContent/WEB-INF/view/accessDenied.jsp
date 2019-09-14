<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Access Denied</title>
</head>
<body>
You are not autherised person to access this page.......<br><br>
<a href="${pageContext.request.contextPath}/">back to home page</a>
<form:form action="${pageContext.request.contextPath}/logout"
		method="POST" class="form-horizontal">
		
		<button type="submit" class="btn btn-success">Logout</button>
	</form:form>
</body>
</html>