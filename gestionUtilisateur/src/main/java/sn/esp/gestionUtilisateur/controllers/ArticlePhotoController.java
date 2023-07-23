package sn.esp.gestionUtilisateur.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sn.esp.gestionUtilisateur.entities.Article;
import sn.esp.gestionUtilisateur.entities.ArticlePhoto;
import sn.esp.gestionUtilisateur.entities.FichierDB;
import sn.esp.gestionUtilisateur.repositories.ArticlePhotoRepository;
import sn.esp.gestionUtilisateur.services.ArticlePhotoService;
import sn.esp.gestionUtilisateur.services.ArticleService;
import sn.esp.gestionUtilisateur.services.FichierStockageService;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class ArticlePhotoController {

    @Autowired
    ArticlePhotoRepository articlePhotoRepository;

    @Autowired
    ArticlePhotoService articlePhotoService;

    @Autowired
    ArticleService articleService;

    @Autowired
    FichierStockageService fichierStockageService;

    @GetMapping("/ArticlePhotos")
    @ResponseBody
    public List<ArticlePhoto> getAllchauffeurPhotos() {
        List<ArticlePhoto> list = articlePhotoService.getAllArticlePhotos();
        return list;
    }

    @PostMapping("/AjouterArticlePhotoById/{idarticle}/{idfichierdb}")
    @ResponseBody
    public void AjouterArticlePhotoById(@PathVariable long idarticle, @PathVariable String idfichierdb) {

        Article article = articleService.getArticle(idarticle);
        FichierDB fichierDB = fichierStockageService.getFile(idfichierdb);

        if(article != null && fichierDB != null) {
            ArticlePhoto chauffeurPhoto = new ArticlePhoto(article.getIdarticle(), article, fichierDB);
            articlePhotoService.saveArticlePhoto(chauffeurPhoto);
        }
    }
}
