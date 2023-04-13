package com.mosine.librarymanagement.controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.mosine.librarymanagement.entities.Role;
import com.mosine.librarymanagement.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class userinit
 *
 */
@WebListener
public class userinit implements ServletContextListener{

	private EntityManagerFactory emf;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		emf = Persistence.createEntityManagerFactory("LibraryManagement");
		EntityManager em = emf.createEntityManager();

		// Check if the default user exists in the database
		if (em.find(User.class, 1) == null) {
			// Create a new User object with the default values
			User defaultUser = new User();
			defaultUser.setLogin("admin@gmail.com");
			defaultUser.setRole(Role.ADMIN);

			defaultUser.setPassword("admin");
			// Persist the default user to the database
			em.getTransaction().begin();
			em.persist(defaultUser);
			em.getTransaction().commit();
		}

		em.close();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		if (emf != null) {
			emf.close();
		}
	}
	
}
