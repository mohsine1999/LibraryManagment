<%@page import="com.mosine.librarymanagement.entities.Role"%>
<%@page import="com.mosine.librarymanagement.entities.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin - Liste des utilisateurs</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
}
h2 {
	text-align: center;
	margin: 30px auto;
}
table {
	border-collapse: collapse;
	margin: 40px auto;
	background-color: #fff;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}
th, td {
	padding: 10px;
	border: 1px solid #ddd;
}
th {
	background-color: #f2f2f2;
	font-weight: bold;
}
a {
	color: #0099cc;
	text-decoration: none;
}
a:hover {
	text-decoration: underline;
}
.button-container {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 10vh;
}
.button {
	display: inline-block;
	padding: 10px 20px;
	font-size: 18px;
	background-color: #008CBA;
	color: #fff;
	border: none;
	border-radius: 5px;
	text-decoration: none;
	transition: background-color 0.3s ease;
	margin: 10px;
}
.button:hover {
	background-color: #005f79;
	cursor: pointer;
}
.disabled-link {
	color: gray;
	text-decoration: none;
	cursor: not-allowed;
}
</style>
</head>
<body>
	<%
	List<User> listUsers = (List<User>) request.getAttribute("listUsers");
	%>
	<h2 align="center" style="margin: 30px auto">Listes des
		utilisateurs</h2>
	<table style="border: 2px solid black; margin: 40px auto;">
		<tr>
			<th>ID Auteur</th>
			<th>Login</th>
			<th>Password</th>
			<th>Role</th>
			<th colspan="2">Actions</th>
		</tr>
		<%
		for (User u : listUsers) {
		%><tr>
			<td><%=u.getId()%></td>
			<td><%=u.getLogin()%></td>
			<td><%=u.getPassword()%></td>
			<td><%=u.getRole()%></td>

			<td>
				<%
				String updateUserUrl = response.encodeURL("updateUser?u=" + u.getId());
				%> <a href="<%=u.getRole() == Role.ADMIN ? "#" : updateUserUrl%>"
				<%if (u.getRole() == Role.ADMIN) {%> aria-disabled="true"
				style="pointer-events: none;" class="disabled-link" <%}%>>Modifier</a>

			</td>

			<td>
				<%
				String delUserUrl = response.encodeURL("deleteUser?u=" + u.getId());
				%> <a href="<%=u.getRole() == Role.ADMIN ? "#" : delUserUrl%>"
				<%if (u.getRole() == Role.ADMIN) {%> aria-disabled="true"
				style="pointer-events: none;" class="disabled-link" <%}%>>Supprimer</a>

			</td>
		</tr>
		<%
		}
		%>
	</table>
	<div class="button-container">
		<a href="vues/ajoutUser.jsp" class="button">Ajouter un
			utilisateur!</a> <a href="<%=request.getContextPath()%>/vues/home.jsp"
			class="button">home</a>
	</div>
</body>
</html>
