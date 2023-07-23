package sn.esp.gestionUtilisateur.services;

import sn.esp.gestionUtilisateur.entities.Article;
import sn.esp.gestionUtilisateur.entities.Categorie;

import java.util.List;

public interface ArticleService {

    Article saveArticle(Article t);
    Article updateArticle(Article t);
    void deleteArticle(Article t);
    void deleteArticleById(Long id);
    Article getArticle(Long id);
    List<Article> getAllArticles();
}
