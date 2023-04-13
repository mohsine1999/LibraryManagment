package com.mosine.librarymanagement.service;

import java.util.List;

import com.mosine.librarymanagement.entities.Auteur;


public interface AuteurService {

	void createAuteur(Auteur a);
	List<Auteur> getAllAuteurs();
	Auteur getAuteurByMatricule(int matricule);
	void updateAuteur(Auteur auteur);
	void deleteAuteur(int matricule);
}
