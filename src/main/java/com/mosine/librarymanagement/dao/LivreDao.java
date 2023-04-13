package com.mosine.librarymanagement.dao;

import java.util.List;

import com.mosine.librarymanagement.entities.Livre;



public interface LivreDao {

	public List<Livre> findAll();

	public Livre create(Livre l);

	Livre getLivreByIsbn(int isbn);

	Livre update(Livre newLivre);

	Livre delete(int isbn);
}
