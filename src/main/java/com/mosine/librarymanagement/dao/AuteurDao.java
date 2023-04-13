package com.mosine.librarymanagement.dao;

import java.util.List;

import com.mosine.librarymanagement.entities.Auteur;


public interface AuteurDao {

	public List<Auteur> findAll();

	public Auteur create(Auteur a);

	Auteur getAuteurByMatricule(int matricule);

	Auteur update(Auteur newAuteur);

	Auteur delete(int matricule);
}
