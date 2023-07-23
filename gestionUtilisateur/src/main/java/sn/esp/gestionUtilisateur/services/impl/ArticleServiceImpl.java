package sn.esp.gestionUtilisateur.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.esp.gestionUtilisateur.entities.Article;
import sn.esp.gestionUtilisateur.entities.Categorie;
import sn.esp.gestionUtilisateur.repositories.ArticleRepository;
import sn.esp.gestionUtilisateur.repositories.CategorieRepository;
import sn.esp.gestionUtilisateur.services.ArticleService;
import sn.esp.gestionUtilisateur.services.CategorieService;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public Article saveArticle(Article u) {
        return articleRepository.save(u);
    }

    @Override
    public Article updateArticle(Article u) {
        return articleRepository.save(u);
    }

    @Override
    public void deleteArticle(Article u) {
        articleRepository.delete(u);
    }

    @Override
    public void deleteArticleById(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public Article getArticle(Long id) {
        return articleRepository.findById(id).get();
    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }
}
