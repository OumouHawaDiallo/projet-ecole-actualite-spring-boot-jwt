package sn.esp.gestionUtilisateur.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.esp.gestionUtilisateur.entities.Categorie;
import sn.esp.gestionUtilisateur.repositories.CategorieRepository;
import sn.esp.gestionUtilisateur.services.CategorieService;

import java.util.List;

@Service
public class CategorieServiceImpl implements CategorieService {

    @Autowired
    CategorieRepository categorieRepository;

    @Override
    public Categorie saveCategorie(Categorie u) {
        return categorieRepository.save(u);
    }

    @Override
    public Categorie updateCategorie(Categorie u) {
        return categorieRepository.save(u);
    }

    @Override
    public void deleteCategorie(Categorie u) {
        categorieRepository.delete(u);
    }

    @Override
    public void deleteCategorieById(Long id) {
        categorieRepository.deleteById(id);
    }

    @Override
    public Categorie getCategorie(Long id) {
        return categorieRepository.findById(id).get();
    }

    @Override
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }
}
