<%@page import="com.mosine.librarymanagement.entities.Genre"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="us" class="com.mosine.librarymanagement.entities.User" scope="request"></jsp:useBean>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin - Modification Utilisateur</title>
<style>
body {
	background-color: #f2f2f2;
	font-family: Arial, sans-serif;
}
h2 {
	margin: 30px auto;
	text-align: center;
}
form {
	border: 2px solid black;
	margin: 40px auto;
	padding: 20px;
	max-width: 500px;
}
table {
	width: 100%;
}
th {
	padding: 10px;
	text-align: left;
}
input, select {
	width: 100%;
	padding: 10px;
	margin: 5px 0;
	box-sizing: border-box;
}
input[type=submit] {
	background-color: #4CAF50;
	color: white;
	border: none;
	cursor: pointer;
	font-size: 16px;
	padding: 10px 20px;
	float: right;
	border-radius: 5px;
	margin-top: 10px;
}
input[type=submit]:hover {
	background-color: #45a049;
}
a {
	display: block;
	text-align: center;
	margin: 30px auto;
	color: #333;
	font-weight: bold;
	text-decoration: none;
}
</style>
</head>
<body>
	<h2>Modifier l'utilisateur</h2>
	<form action="<%=request.getContextPath()%>/editUser">
		<table>
			<tr>
				<th>Login :</th>
				<td><input name="login" id="login" value="<%=us.getLogin()%>" /></td>
			</tr>
			<tr>
				<th>Password :</th>
				<td><input name="password" id="password"
					value="<%=us.getPassword()%>" /></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
		<input type="hidden" name="u" value="<%=us.getId()%>">
	</form>
</body>
</html>
