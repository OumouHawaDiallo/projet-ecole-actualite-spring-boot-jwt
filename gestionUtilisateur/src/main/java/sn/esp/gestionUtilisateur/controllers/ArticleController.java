package sn.esp.gestionUtilisateur.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.esp.gestionUtilisateur.entities.Article;
import sn.esp.gestionUtilisateur.entities.Categorie;
import sn.esp.gestionUtilisateur.repositories.ArticleRepository;
import sn.esp.gestionUtilisateur.repositories.CategorieRepository;
import sn.esp.gestionUtilisateur.services.ArticleService;
import sn.esp.gestionUtilisateur.services.CategorieService;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class ArticleController {

    @Autowired
    ArticleService articleService;


    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("/Articles")
    @ResponseBody
    public List<Article> getAllArticles() {
        List<Article> list = articleService.getAllArticles();
        return list;
    }

    @GetMapping("/ArticleById/{id}")
    @ResponseBody
    public Article ArticleById(@PathVariable long id) {
        Article article = articleService.getArticle(id);
        return article;
    }

    @PostMapping("/AjouterArticle")
    @ResponseBody
    public Article AjouterArticle(@RequestBody Article q) {
        return articleService.saveArticle(q);
    }

    @PutMapping("/ModifierArticle/{id}")
    @ResponseBody
    public Article ModifierArticle(@PathVariable long id, @RequestBody Article q) {
        q.setIdarticle(id);
        return articleService.updateArticle(q);
    }

    @DeleteMapping("SupprimerArticle/{id}")
    public void SupprimerArticle(@PathVariable("id") Long idarticle) {
        articleService.deleteArticleById(idarticle);
    }
}
