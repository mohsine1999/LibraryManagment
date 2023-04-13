package com.mosine.librarymanagement.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.mosine.librarymanagement.entities.*;
import com.mosine.librarymanagement.service.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/")
public class AuteurController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private AuteurService service = new AuteurServiceImp();
	private LivreService serviceLivre = new LivreServiceImp();
	private UserService userService = new UserServiceImpl();
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String path = request.getServletPath();

		try {
			switch (path) {
			////////////////
			//// Auteurs////
			////////////////
			case "/ajoutAuteur":
				ajoutAuteur(request, response);
				break;
			case "/updateAuteur":
				updateAuteur(request, response);
				break;
			case "/edit":
				edit(request, response);
				break;
			case "/listeAuteurs":
				listeAuteurs(request, response);
				break;
			case "/deleteAuteur":
				deleteAuteur(request, response);
				break;
			/////////////////
			/// Livres //////
			/////////////////
			case "/createl":
				create(request, response);
				break;
			case "/ajoutLivre":
				ajoutLivre(request, response);
				break;
			case "/listeLivres":
				listeLivres(request, response);
				break;
			case "/updateLivre":
				updateLivre(request, response);
				break;
			case "/modifieLivre":
				modifieLivre(request, response);
				break;
			case "/deleteLivre":
				deleteLivre(request, response);
				break;

				/////////////////
				/// Users //////
				/////////////////
				case "/ajoutUser":
					doPost(request, response);
					break;
				case "/updateUser":
					updateUser(request, response);
					break;
				case "/editUser":
					editUser(request, response);
					break;
				case "/listeUsers":
					listeUsers(request, response);
					break;
				case "/deleteUser":
					deleteUser(request, response);
					break;
				case "/visiteur":
					visiteur(request, response);
					break;
				case "/logout":
					logout(request, response);
					break;
			default:
				throw new IllegalArgumentException("Erreur de cheminement!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	//////////////////////
	////// Auteur ///////
	//////////////////////
	protected void ajoutAuteur(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String genre = request.getParameter("genre");

		Auteur a = new Auteur();
		a.setNom(nom);
		a.setPrenom(prenom);
		Genre genreParam = Genre.valueOf(genre);
		a.setGenre(genreParam);

		service.createAuteur(a);
		listeAuteurs(request, response);
	}

	protected void updateAuteur(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int matricule = Integer.parseInt(request.getParameter("m"));
		Auteur a = service.getAuteurByMatricule(matricule);
		request.setAttribute("a", a);
		RequestDispatcher d = getServletContext().getRequestDispatcher("/vues/updateAuteur.jsp");
		d.forward(request, response);
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String genre = request.getParameter("genre");
		int m = Integer.parseInt(request.getParameter("matricule"));

		Genre g = Genre.valueOf(genre);

		Auteur a = service.getAuteurByMatricule(m);

		a.setNom(nom);
		a.setPrenom(prenom);
		a.setGenre(g);
		service.updateAuteur(a);
		listeAuteurs(request, response);
	}

	protected void listeAuteurs(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Auteur> listAuteurs = service.getAllAuteurs();
		request.setAttribute("listAuteurs", listAuteurs);
		RequestDispatcher d = request.getRequestDispatcher("/vues/listeAuteurs.jsp");
		d.forward(request, response);
	}

	protected void deleteAuteur(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int m = Integer.parseInt(request.getParameter("m"));

		service.deleteAuteur(m);
		listeAuteurs(request, response);
	}

	//////////////////////
	////// Livre /////////
	//////////////////////

	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Auteur> listAuteurs = service.getAllAuteurs();
		request.setAttribute("listAuteurs", listAuteurs);
		RequestDispatcher d = request.getRequestDispatcher("/vues/AjoutLivre.jsp");
		d.forward(request, response);
	}

	protected void ajoutLivre(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		String titre = request.getParameter("titre");
		String desc = request.getParameter("desc");
		String dt_ed_str = request.getParameter("dt_ed");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dt_ed = format.parse(dt_ed_str);
		int matricule = Integer.parseInt(request.getParameter("auteur"));
		String editeur = request.getParameter("editeur");
		Editeur e = Editeur.valueOf(editeur);

		Auteur a = service.getAuteurByMatricule(matricule);
		Livre l = new Livre();
		l.setTitre(titre);
		l.setDescription(desc);
		l.setDate_edition(dt_ed);
		l.setAuteur(a);
		l.setEditeur(e);

		serviceLivre.createLivre(l);
		listeLivres(request, response);
	}

	protected void listeLivres(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Livre> listLivres = serviceLivre.getAllLivre();
		request.setAttribute("listLivres", listLivres);
		RequestDispatcher d = request.getRequestDispatcher("/vues/ListeLivres.jsp");
		d.forward(request, response);
	}

	protected void updateLivre(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int i = Integer.parseInt(request.getParameter("i"));
		Livre l = serviceLivre.getLivre(i);
		request.setAttribute("l", l);
		List<Auteur> listAuteurs = service.getAllAuteurs();
		request.setAttribute("listAuteurs", listAuteurs);
		RequestDispatcher d = getServletContext().getRequestDispatcher("/vues/updateLivre.jsp");
		d.forward(request, response);
	}

	protected void modifieLivre(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		String titre = request.getParameter("titre");
		String desc = request.getParameter("desc");
		String dt_ed_str = request.getParameter("dt_ed");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dt_ed = format.parse(dt_ed_str);

		int matricule = Integer.parseInt(request.getParameter("auteur"));
		String editeur = request.getParameter("editeur");
		Editeur e = Editeur.valueOf(editeur);

		int isbn = Integer.parseInt(request.getParameter("i"));

		Auteur a = service.getAuteurByMatricule(matricule);
		Livre l = serviceLivre.getLivre(isbn);
		l.setTitre(titre);
		l.setDescription(desc);
		l.setDate_edition(dt_ed);
		l.setAuteur(a);
		l.setEditeur(e);
		serviceLivre.updateLivre(l);
		listeLivres(request, response);
	}

	protected void deleteLivre(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int isbn = Integer.parseInt(request.getParameter("i"));
		Livre l = serviceLivre.getLivre(isbn);
		serviceLivre.deleteLivre(isbn);
		listeLivres(request, response);
	}

	//////////////////////
	////// Users /////////
	//////////////////////
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String role = "VISITEUR";
		Role r = Role.valueOf(role);

		User u = new User();
		u.setLogin(login);
		u.setPassword(password);
		u.setRole(r);

		userService.createUser(u);
		listeUsers(request, response);
	}

	protected void listeUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> listUsers = userService.getAllUser();
		request.setAttribute("listUsers", listUsers);
		RequestDispatcher d = request.getRequestDispatcher("/vues/listeUsers.jsp");
		d.forward(request, response);
	}

	protected void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int u = Integer.parseInt(request.getParameter("u"));
		User us = userService.getUserById(u);
		request.setAttribute("us", us);
		List<User> listUsers = userService.getAllUser();
		request.setAttribute("listUsers", listUsers);
		RequestDispatcher d = getServletContext().getRequestDispatcher("/vues/updateUser.jsp");
		d.forward(request, response);
	}

	protected void editUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		int u = Integer.parseInt(request.getParameter("u"));

		User us = userService.getUserById(u);

		us.setLogin(login);
		us.setPassword(password);

		userService.updateUser(us);
		listeUsers(request, response);
	}

	protected void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int u = Integer.parseInt(request.getParameter("u"));
		userService.deleteUser(u);
		listeUsers(request, response);
	}

	protected void visiteur(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Livre> listLivres = serviceLivre.getAllLivre();
		request.setAttribute("listLivres", listLivres);
		RequestDispatcher d = request.getRequestDispatcher("/vues/visiteur_home.jsp");
		d.forward(request, response);
	}

	protected void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession s = request.getSession(false);
		s.removeAttribute("u");
		response.sendRedirect("/Application_JPA/login.jsp");
	}

}
