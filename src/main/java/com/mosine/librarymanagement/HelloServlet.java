package com.mosine.librarymanagement;

import java.io.*;
import java.sql.Date;

import com.mosine.librarymanagement.entities.Livre;
import com.mosine.librarymanagement.enumerations.ListeEditeur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String titre = req.getParameter("title");
        // Create the EntityManagerFactory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

        // Create the EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Begin the transaction
        entityManager.getTransaction().begin();

        try {
            // Create a new instance of your entity
            Livre livre = new Livre();
            livre.setDescription("my fist book jpa test");
            livre.setTitre(titre);
            livre.setDateEdition(new Date(1999,05,04));
            livre.setEditeur(ListeEditeur.FIRST);
            entityManager.persist(livre);
            // Set the entity attributes based on the request parameters

            // Persist the entity to the database
            entityManager.persist(livre);

            // Commit the transaction
            entityManager.getTransaction().commit();

            // Send a success response
            resp.getWriter().println("Entity persisted successfully!");
        } catch (Exception e) {
            // Rollback the transaction if an exception occurs
            entityManager.getTransaction().rollback();

            // Send an error response
            resp.getWriter().println("Error persisting entity: " + e.getMessage());
        } finally {
            // Close the EntityManager
            entityManager.close();

            // Close the EntityManagerFactory
            entityManagerFactory.close();
        }

        resp.getWriter().println("Votre titre est : " + titre);
    }

    public void destroy() {
    }
}
