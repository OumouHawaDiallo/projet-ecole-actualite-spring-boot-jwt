package sn.esp.gestionUtilisateur.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.esp.gestionUtilisateur.entities.Categorie;
import sn.esp.gestionUtilisateur.repositories.CategorieRepository;
import sn.esp.gestionUtilisateur.services.CategorieService;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class CategorieController {

    @Autowired
    CategorieService categorieService;


    @Autowired
    CategorieRepository categorieRepository;

    @GetMapping("/Categories")
    @ResponseBody
    public List<Categorie> getAllTrajets() {
        List<Categorie> list = categorieService.getAllCategories();
        return list;
    }

    @GetMapping("/CategorieById/{id}")
    @ResponseBody
    public Categorie CategorieById(@PathVariable long id) {
        Categorie categorie = categorieService.getCategorie(id);
        return categorie;
    }

    @PostMapping("/AjouterCategorie")
    @ResponseBody
    public Categorie AjouterCategorie(@RequestBody Categorie q) {
        return categorieService.saveCategorie(q);
    }

    @PutMapping("/ModifierCategorie/{id}")
    @ResponseBody
    public Categorie ModifierCategorie(@PathVariable long id, @RequestBody Categorie q) {
        q.setIdcategorie(id);
        return categorieService.updateCategorie(q);
    }

    @DeleteMapping("SupprimerCategorie/{id}")
    public void SupprimerCategorie(@PathVariable("id") Long idcategorie) {
        categorieService.deleteCategorieById(idcategorie);
    }




}
