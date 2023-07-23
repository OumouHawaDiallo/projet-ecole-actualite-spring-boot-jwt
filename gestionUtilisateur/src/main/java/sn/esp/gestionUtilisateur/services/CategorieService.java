package sn.esp.gestionUtilisateur.services;

import sn.esp.gestionUtilisateur.entities.Categorie;

import java.util.List;

public interface CategorieService {

    Categorie saveCategorie(Categorie t);
    Categorie updateCategorie(Categorie t);
    void deleteCategorie(Categorie t);
    void deleteCategorieById(Long id);
    Categorie getCategorie(Long id);
    List<Categorie> getAllCategories();
}
