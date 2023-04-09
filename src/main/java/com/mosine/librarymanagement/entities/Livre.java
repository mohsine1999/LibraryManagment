package entities;

import java.io.Serializable;
import java.sql.Date;

import enumerations.ListeEditeur;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Livre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int isbn;
    private String titre;
    private String description;
    private Date dateEdition;
    private ListeEditeur editeur;

    public Livre() {
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
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

    public Date getDateEdition() {
        return dateEdition;
    }

    public void setDateEdition(Date dateEdition) {
        this.dateEdition = dateEdition;
    }

    public ListeEditeur getEditeur() {
        return editeur;
    }

    public void setEditeur(ListeEditeur editeur) {
        this.editeur = editeur;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    @ManyToOne
    private Auteur auteur;

}
