<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Roles</title>
</head>
<body>
	<h1>All Roles</h1>
	<table border="1">
		<tr>
			<th>RoleId</th>
			<th>RoleName</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${roles}" var="x">
			<tr>
				<td>${x.roleid}</td>
				<td>${x.roleName}</td>
				<td><a href="deleterole?userid=${x.roleid}">Delete</a>
				<a href="viewrole?roleid=${x.roleid}">View Role</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>