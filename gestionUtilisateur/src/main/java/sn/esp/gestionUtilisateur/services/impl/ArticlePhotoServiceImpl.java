package sn.esp.gestionUtilisateur.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.esp.gestionUtilisateur.entities.ArticlePhoto;
import sn.esp.gestionUtilisateur.repositories.ArticlePhotoRepository;
import sn.esp.gestionUtilisateur.services.ArticlePhotoService;

import java.util.List;

@Service
public class ArticlePhotoServiceImpl implements ArticlePhotoService {

    @Autowired
    ArticlePhotoRepository articlePhotoRepository;

    @Override
    public ArticlePhoto saveArticlePhoto(ArticlePhoto u) {
        return articlePhotoRepository.save(u);
    }

    @Override
    public ArticlePhoto updateArticlePhoto(ArticlePhoto u) {
        return articlePhotoRepository.save(u);
    }

    @Override
    public void deleteArticlePhoto(ArticlePhoto u) {
        articlePhotoRepository.delete(u);
    }

    @Override
    public void deleteArticlePhotoById(Long id) {
        articlePhotoRepository.deleteById(id);
    }

    @Override
    public ArticlePhoto getArticlePhoto(Long id) {
        return articlePhotoRepository.findById(id).get();
    }

    @Override
    public List<ArticlePhoto> getAllArticlePhotos() {
        return articlePhotoRepository.findAll();
    }
}