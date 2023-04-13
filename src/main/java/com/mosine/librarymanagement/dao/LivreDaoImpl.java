package com.mosine.librarymanagement.dao;

import java.util.List;

import com.mosine.librarymanagement.entities.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.RollbackException;

public class LivreDaoImpl implements LivreDao {

	@Override
	public List<Livre> findAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Application_JPA");
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction transaction = null;
		List<Livre> livres;
		try {
			transaction = mgr.getTransaction();
			transaction.begin();
			livres = mgr.createQuery("SELECT liv FROM Livre liv", Livre.class).getResultList();
			transaction.commit();

		} catch (RollbackException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println("Error: il n'y aucun livre!");
			e.printStackTrace();
			return null;
		} finally {
			mgr.close();
			emf.close();
		}
		return livres;
	}

	@Override
	public Livre create(Livre l) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Application_JPA");
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = null;

		try {
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(l);
			transaction.commit();
			return l;
		} catch (RollbackException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println("Erreur: probleme d'insertion!");
			e.printStackTrace();
			return null;
		} finally {
			manager.close();
			emf.close();
		}
	}

	@Override
	public Livre getLivreByIsbn(int isbn) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Application_JPA");
		EntityManager manager = emf.createEntityManager();

		try {
			Livre l = manager.find(Livre.class, isbn);
			if (l == null)
				throw new Exception("Erreur: aucun livre avec cet isbn!");
			return l;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		} finally {
			manager.close();
			emf.close();
		}
	}

	@Override
	public Livre update(Livre newLivre) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Application_JPA");
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = null;

		try {
			transaction = manager.getTransaction();
			transaction.begin();

			Livre l = manager.find(Livre.class, newLivre.getISBN());
			if (l != null) {
				l.setTitre(newLivre.getTitre());
				l.setDate_edition(newLivre.getDate_edition());
				l.setDescription(newLivre.getDescription());
				l.setEditeur(newLivre.getEditeur());
				l.setAuteur(newLivre.getAuteur());
				manager.merge(l);
			}
			transaction.commit();
			return l;
		} catch (RollbackException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println("Erreur de mis à jour");
			return null;
		} finally {
			manager.close();
			emf.close();
		}
	}

	@Override
	public Livre delete(int isbn) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Application_JPA");
		EntityManager manager = emf.createEntityManager();

		EntityTransaction transaction = null;
		try {
			transaction = manager.getTransaction();
			transaction.begin();

			Livre l = manager.find(Livre.class, isbn);
			if (l != null) {
				manager.remove(l);
			}
			transaction.commit();
			return l;

		} catch (RollbackException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println("Erreur de suppression!");
			e.printStackTrace();
			return null;
		}
	}
}
