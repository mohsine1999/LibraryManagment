package com.mosine.librarymanagement.service;

import java.util.List;

import com.mosine.librarymanagement.dao.LivreDao;
import com.mosine.librarymanagement.dao.LivreDaoImpl;
import com.mosine.librarymanagement.entities.Livre;


public class LivreServiceImp implements LivreService {

	private LivreDao dao = new LivreDaoImpl();

	@Override
	public void createLivre(Livre l) {
		Livre ajoutLivre = dao.create(l);
		if (ajoutLivre != null)
			System.out.println("Le livre : " + ajoutLivre.getISBN() + " est ajouté!");
	}

	@Override
	public List<Livre> getAllLivre() {
		return dao.findAll();
	}

	@Override
	public Livre getLivre(int isbn) {
		return dao.getLivreByIsbn(isbn);
	}

	@Override
	public void updateLivre(Livre livre) {
		Livre l = dao.update(livre);
		if (l != null)
			System.out.println("Le livre " + l.getISBN() + " est mis à jour!");

	}

	@Override
	public void deleteLivre(int isbn) {
		Livre l = dao.delete(isbn);
		if (l != null)
			System.out.println("Le livre " + l.getISBN() + " est supprimé!");
	}

}
