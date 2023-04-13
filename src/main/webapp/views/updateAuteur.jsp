<%@page import="com.mosine.librarymanagement.entities.Genre"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="a" class="com.mosine.librarymanagement.entities.Auteur" scope="request"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Modification</title>
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
	<h2>Modifier l'auteur</h2>
	<form action="<%=request.getContextPath()%>/edit">
		<table>
			<tr>
				<th>Nom :</th>
				<td><input name="nom" id="nom" value="<%=a.getNom()%>" /></td>
			</tr>
			<tr>
				<th>Prénom :</th>
				<td><input name="prenom" id="prenom" value="<%=a.getPrenom()%>" /></td>
			</tr>
			<tr>
				<th>Genre :</th>
				<td>
					<select name="genre" id="genre">
						<%
						for (Genre g : Genre.values()) {
						%>
						<option value="<%=g%>" <%if (g == a.getGenre()) {%> selected="selected" <%}%>><%=g%></option>
						<%
						}
						%>
					</select>
				</td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
		<input type="hidden" name="matricule" value="<%=a.getMatricule()%>">
	</form>
</body>
</html>
