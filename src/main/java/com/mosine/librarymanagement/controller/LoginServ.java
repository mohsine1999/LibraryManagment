package com.mosine.librarymanagement.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import com.mosine.librarymanagement.entities.Role;
import com.mosine.librarymanagement.entities.User;
import com.mosine.librarymanagement.service.UserService;
import com.mosine.librarymanagement.service.UserServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		User u = userService.findUserByLogin(login);
		if (u != null) {
			MessageDigest digest;
			try {
				digest = MessageDigest.getInstance("SHA-256");
				byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
				String hashedPassword = new String(encodedHash, StandardCharsets.UTF_8);

				if (hashedPassword.equals(u.getPassword())) {
					HttpSession session = request.getSession();
					session.setAttribute("u", u);

					if (u.getRole().equals(Role.ADMIN)) {
						RequestDispatcher d = getServletContext().getRequestDispatcher("/vues/home.jsp");
						d.forward(request, response);

					} else if (u.getRole().equals(Role.VISITEUR)) {
						RequestDispatcher d = getServletContext().getRequestDispatcher("/vues/v_home.jsp");
						d.forward(request, response);
					} else {
						// Unknown role, login failed
						response.sendRedirect("/Application_JPA/login.jsp");
					}
				} else {
					// Passwords don't match, login failed
					response.sendRedirect("/Application_JPA/login.jsp");
				}
			} catch (NoSuchAlgorithmException e) {
				// Handle hashing error
				e.printStackTrace();
				response.sendRedirect("/Application_JPA/login.jsp");
			}
		} else {
			// User not found, login failed
			System.out.println("Login failed!");
			response.sendRedirect("/Application_JPA/login.jsp");
		}
	}

}
