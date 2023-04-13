<%@page import="com.mosine.librarymanagement.entities.Livre"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des livres disponibles</title>
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
	List<Livre> listLivres = (List<Livre>) request.getAttribute("listLivres");
	%>
	<h2>Listes des livres disponibles</h2>
	<table>
		<thead>
			<tr>
				<th>ISBN</th>
				<th>Titre</th>
				<th>Description</th>
				<th>Date d'édition</th>
				<th>Editeur</th>
				<th>Auteur</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Livre l : listLivres) {
			%><tr>
				<td><%=l.getISBN()%></td>
				<td><%=l.getTitre()%></td>
				<td><%=l.getDescription()%></td>
				<td><%=l.getDate_edition()%></td>
				<td><%=l.getEditeur()%></td>
				<td><%=l.getAuteur().getNom()%>&nbsp;<%=l.getAuteur().getPrenom()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<div class="button-container">
		<a href="logout" class="button">Log Out</a>
	</div>
</body>
</html>
