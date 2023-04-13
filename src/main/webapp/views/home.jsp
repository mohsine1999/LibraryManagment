<%@page import="com.mosine.librarymanagement.entities.User"%>
<%@page import="com.mosine.librarymanagement.entities.Role"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home Page</title>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f2f2f2;
}

.container {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	height: 70vh;
	margin-top: 10px;
}

.title {
	font-size: 48px;
	font-weight: bold;
	text-align: center;
	margin-bottom: 20px;
}

.menu {
	display: flex;
	flex-direction: row;
	align-items: center;
	justify-content: space-between;
	width: 80%;
	margin-top: 40px;
	padding: 20px;
	background-color: white;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
	border-radius: 10px;
}

.menu a {
	text-decoration: none;
	color: black;
	font-size: 24px;
	font-weight: bold;
	padding: 10px;
	transition: all 0.3s ease;
}

.menu a:hover {
	background-color: #f2f2f2;
	color: #4CAF50;
}

.menu a:last-child {
	margin: 0 auto;
	display: block;
}

.logout {
	text-decoration: none;
	color: #ffffff;
	background-color: #4CAF50;
	padding: 10px;
	border-radius: 5px;
	transition: all 0.3s ease;
}

.logout:hover {
	background-color: #ffffff;
	color: #4CAF50;
}
</style>
</head>
<body>
	<%
	User u = (User) session.getAttribute("u");
	if (u != null && u.getRole().equals(Role.ADMIN)) {
	%>

	<div class="container">
		<a href="<%=request.getContextPath()%>/logout" class="logout">Log
			out</a>
		<h1 class="title">Bienvenue dans le panneau d'administration</h1>
		<div class="menu">
			<a href="<%=request.getContextPath()%>/vues/AjoutAuteur.jsp">Ajouter
				un auteur</a><br /> <a href="<%=request.getContextPath()%>/createl">Ajouter
				un livre</a><br /> <a href="<%=request.getContextPath()%>/listeAuteurs">Liste
				des auteurs</a><br /> <a
				href="<%=request.getContextPath()%>/listeLivres">Liste des
				livres disponibles</a><br /> <a
				href="<%=request.getContextPath()%>/vues/ajoutUser.jsp">ajouter
				un utilisateur</a><br /> <a
				href="<%=request.getContextPath()%>/listeUsers">Liste des
				utilisateurs actifs</a>

		</div>
	</div>
	<%
	} else {
	response.sendRedirect(request.getContextPath() + "/Application_JPA/login.jsp");
	}
	%>
</body>
</html>
