<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Profile</title>
</head>
<body>
	<form action="saveprofile" method="post" enctype="multipart/form-data">
		First Name : <input type= "text" name="firstName">
		<br>
		Email Id : <input type="email" name="email" >
		<br>
		Password : <input type="password" name="password" >
		<br>
		ProfilePic : <input type="file" name="profilepic">
		<br>
		<input type="submit" value="Upload Photo">
	</form>
</body>
</html>