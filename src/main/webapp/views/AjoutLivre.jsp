<%@page import="com.mosine.librarymanagement.entities.Auteur"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin - ajouter un livre</title>
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
</style>
</head>
<body>
	<h2>Ajouter un livre</h2>
	<form action="<%=request.getContextPath()%>/ajoutLivre">
		<table>
			<tr>
				<th>Titre :</th>
				<th><input name="titre" id="titre" /></th>
			</tr>
			<tr>
				<th>Description :</th>
				<th><input name="desc" id="desc" /></th>
			</tr>
			<tr>
				<th>date edition :</th>
				<th><input type="date" name="dt_ed" id="dt_ed" /></th>
			</tr>
			<tr>
				<th>editeur:</th>
				<th><select name="editeur" id="editeur">
						<option value="ENI">ENI</option>
						<option value="DUNOD">DUNOD</option>
						<option value="FIRST">FIRST</option>
				</select></th>
			</tr>
			<tr>
				<th>Auteur :</th>
				<th><select name="auteur">
						<%
						List<Auteur> la = (List<Auteur>) request.getAttribute("listAuteurs");
						for (Auteur a : la) {
						%>
						<option value="<%=a.getMatricule()%>"><%=a.getMatricule()%></option>
						<%
						}
						%>
				</select></th>
			</tr>
			<tr>
				<th></th>
				<th><input type="submit" value="Submit" /></th>
			</tr>
		</table>
	</form>
	<div class="button-container">
		<a href="listeLivres" class="button">Liste de tous les livres.</a> <a
			href="<%=request.getContextPath()%>/vues/home.jsp" class="button">home</a>
	</div>
</body>
</html>
