<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>All Images</h2>
	<table border="1">
		<tr>
			<td>File</td>
			<td>Action</td>
		</tr>
		<c:forEach items="${allFiles}" var="i">
			<tr>
				<td><img src="${i}" height="100px" width="100px" /></td>
				<td><a href="viewimg?imgName=${i}">${i}</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>