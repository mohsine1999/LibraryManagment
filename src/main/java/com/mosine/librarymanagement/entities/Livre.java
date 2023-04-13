package com.mosine.librarymanagement.entities;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ISBN;
    private String titre;
    private String description;

    @Temporal(TemporalType.DATE)
    private Date date_edition;

    @Enumerated(EnumType.STRING)
    private Editeur editeur;

    @ManyToOne
    private Auteur auteur;

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int iSBN) {
        ISBN = iSBN;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_edition() {
        return date_edition;
    }

    public void setDate_edition(Date date_edition) {
        this.date_edition = date_edition;
    }

    public Editeur getEditeur() {
        return editeur;
    }

    public void setEditeur(Editeur editeur) {
        this.editeur = editeur;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }
}
