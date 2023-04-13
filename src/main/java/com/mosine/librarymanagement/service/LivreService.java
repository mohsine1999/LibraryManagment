package com.mosine.librarymanagement.service;

import com.mosine.librarymanagement.entities.Livre;

import java.util.List;

public interface LivreService {
    void createLivre(Livre livre);

    List<Livre> getAllLivre();

    Livre getLivre(int i);

    void updateLivre(Livre livre);

    void deleteLivre(int i);
}
