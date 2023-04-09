package com.mosine.librarymanagement.entities;

import java.io.Serializable;
import java.util.Collection;

import com.mosine.librarymanagement.enumerations.Genre;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Auteur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int matricule;
    private String nom;
    private String prenom;
    private String texte;
    private Genre genre;

    @OneToMany(mappedBy="auteur")
    Collection<Livre> livres;
}
