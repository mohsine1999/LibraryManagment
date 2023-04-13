<%@page import="com.mosine.librarymanagement.entities.Auteur"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin - Liste des auteurs</title>
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
</style>
</head>
<body>
	<%
	List<Auteur> listAuteurs = (List<Auteur>) request.getAttribute("listAuteurs");
	%>
	<h2 align="center" style="margin: 30px auto">Listes des auteurs</h2>
	<table style="border: 2px solid black; margin: 40px auto;">
		<tr>
			<th>ID Auteur</th>
			<th>Nom Auteur</th>
			<th>Prenom Auteur</th>
			<th>Genre</th>
			<th>Modification</th>
		</tr>
		<%
		for (Auteur a : listAuteurs) {
		%><tr>
			<td><%=a.getMatricule()%></td>
			<td><%=a.getNom()%></td>
			<td><%=a.getPrenom()%></td>
			<td><%=a.getGenre()%></td>
			<td><a href="updateAuteur?m=<%=a.getMatricule()%>">Modifier</a></td>
			<td><a href="deleteAuteur?m=<%=a.getMatricule()%>">Supprimer</a></td>
		</tr>
		<%
		}
		%>
	</table>
	<div class="button-container">
		<a href="vues/ajoutAuteur.jsp" class="button">Ajouter un auteur!</a> <a
			href="<%=request.getContextPath()%>/vues/home.jsp" class="button">home</a>
	</div>
</body>
</html>
