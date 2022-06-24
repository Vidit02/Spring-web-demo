<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>  
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up Here</title>
</head>
<body>

	<s:form action="saveuser" method="post" modelAttribute="user">
		First name : <s:input path="fname" />
		<s:errors path="fname"></s:errors>
		 <br>
		Email : <s:input path="email"/> <s:errors path="email"></s:errors> <br>
		Password : <s:password path="password"/> <s:errors path="password"></s:errors> <br>
		<br>
		<input type="submit" value="Save User">
	</s:form>
	<%-- <form action="saveuser" method="post">
	<div>
			<label for="exampleInputPassword1">First name</label> <input
				type="text" id="exampleInputPassword1" name="fname"
				placeholder="Enter first name">
		</div>
		<div>
			<label for="exampleInputEmail1">Email address</label> <input
				type="email"id="exampleInputEmail1" name="email"
				aria-describedby="emailHelp" placeholder="Enter email"> <small
				id="emailHelp">We'll never
				share your email with anyone else.</small>
		</div>
		<div>
			<label for="exampleInputPassword1">Password</label> <input
				type="password" id="exampleInputPassword1" name="password"
				placeholder="Password">
		</div>
		<div >
			<input type="checkbox" id="exampleCheck1">
			<label for="exampleCheck1">Check me
				out</label>
		</div>
		<button type="submit" >Submit</button>
	</form> --%>
</body>
</html>