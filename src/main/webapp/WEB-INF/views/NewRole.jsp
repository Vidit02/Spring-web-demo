<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>

<style>
	.error{
		color: red;
	}
</style>
<meta charset="UTF-8">
<title>Role Register</title>
</head>
<body>
	<s:form action="saverole" method="post" modelAttribute="role">
		Role name : <s:input path="roleName"/>
		<s:errors path="roleName" cssClass="error"></s:errors>
		<s:button >Submit</s:button>
	</s:form>
</body>
</html>