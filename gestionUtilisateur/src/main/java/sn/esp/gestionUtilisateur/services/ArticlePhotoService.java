package sn.esp.gestionUtilisateur.services;

import sn.esp.gestionUtilisateur.entities.ArticlePhoto;

import java.util.List;

public interface ArticlePhotoService {

    ArticlePhoto saveArticlePhoto(ArticlePhoto q);
    ArticlePhoto updateArticlePhoto(ArticlePhoto q);
    void deleteArticlePhoto(ArticlePhoto q);
    void deleteArticlePhotoById(Long id);
    ArticlePhoto getArticlePhoto(Long id);
    List<ArticlePhoto> getAllArticlePhotos();
}
