<%@page import="com.mosine.librarymanagement.entities.Auteur"%>
<%@page import="java.util.List"%>
<%@page import="com.mosine.librarymanagement.entities.Livre"%>
<%@page import="com.mosine.librarymanagement.entities.Editeur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="l" class="com.mosine.librarymanagement.entities.Livre" scope="request"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin - Modification livre</title>
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
	<h2 align="center" style="margin: 30px auto">Modifier le livre</h2>
	<form action="<%=request.getContextPath()%>/modifieLivre">
		<table style="border: 2px solid black; margin: 40px auto;">
			<tr>
				<th>Titre :
				<th><input name="titre" id="titre" value="<%=l.getTitre()%>" /></th>
			</tr>
			<tr>
				<th>Description :</th>
				<th><input name="desc" id="desc"
					value="<%=l.getDescription()%>" /></th>
			</tr>

			<tr>
				<th>date edition :</th>
				<th><input type="date" name="dt_ed" id="dt_ed"
					value="<%=l.getDate_edition()%>" /></th>
			</tr>

			<tr>
				<th>editeur:</th>
				<th><select name="editeur" id="editeur">
						<%
						for (Editeur e : Editeur.values()) {
						%>
						<option value="<%=e%>" <%if (e == l.getEditeur()) {%>
							selected="selected" <%}%>><%=e%></option>
						<%
						}
						%>
				</select></th>
			</tr>
			<tr>
				<th>Auteur :</th>
				<th><select name="auteur">
						<%
						List<Auteur> ll = (List<Auteur>) request.getAttribute("listAuteurs");
						for (Auteur la : ll) {
						%>
						<option value="<%=la.getMatricule()%>"
							<%if (la.getMatricule() == l.getAuteur().getMatricule()) {%>
							selected="selected" <%}%>><%=la.getMatricule()%></option>
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
		<input type="hidden" name="i" value="<%=l.getISBN()%>">
	</form>
</body>
</html>
