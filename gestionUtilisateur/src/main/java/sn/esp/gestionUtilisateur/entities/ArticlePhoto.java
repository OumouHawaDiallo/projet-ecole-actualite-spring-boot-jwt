package sn.esp.gestionUtilisateur.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "articlephoto")
public class ArticlePhoto {

    @Id
    private Long  id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idarticle")
    private Article article;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idfichierdb")
    private FichierDB photo;

    public ArticlePhoto(Long id, Article article, FichierDB photo) {
        this.id = id;
        this.article = article;
        this.photo = photo;
    }

    public ArticlePhoto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public FichierDB getPhoto() {
        return photo;
    }

    public void setPhoto(FichierDB photo) {
        this.photo = photo;
    }
}
