<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin - Ajouter un auteur</title>
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
	<h2>Ajouter un auteur</h2>
	<form action="<%=request.getContextPath()%>/ajoutAuteur">
		<table>
			<tr>
				<th><label for="nom">Nom :</label></th>
				<td><input type="text" name="nom" id="nom" required /></td>
			</tr>
			<tr>
				<th><label for="prenom">Prénom :</label></th>
				<td><input type="text" name="prenom" id="prenom" required /></td>
			</tr>
			<tr>
				<th><label for="genre">Genre :</label></th>
				<td><select name="genre" id="genre" required>
						<option value="">-- Sélectionner --</option>
						<option value="MASCULIN">MASCULIN</option>
						<option value="FEMININ">FÉMININ</option>
				</select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Ajouter" /></td>
			</tr>
		</table>
	</form>
	<div class="button-container">
		<a href="<%=request.getContextPath()%>/listeAuteurs" class="button">Liste
			de tous les auteurs</a> <a
			href="<%=request.getContextPath()%>/vues/home.jsp" class="button">home</a>
	</div>
</body>
</html>
