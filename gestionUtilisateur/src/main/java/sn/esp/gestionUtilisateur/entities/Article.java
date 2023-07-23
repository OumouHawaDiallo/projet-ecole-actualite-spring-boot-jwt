package sn.esp.gestionUtilisateur.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idarticle")
    private Long  idarticle;

    private String titre;
    private String contenu;
    private LocalDate dateCreation;
    private LocalDate dateModification;

    @OneToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(	name = "articlephoto",
            joinColumns = {
                    @JoinColumn(name = "idarticle")
            }, inverseJoinColumns = {
            @JoinColumn(name = "idfichierdb")
    }
    )
    private FichierDB photo;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idcategorie")
    private Categorie categorie;


    public Article(Long idarticle, String titre, String contenu, LocalDate dateCreation, LocalDate dateModification, FichierDB photo, Categorie categorie) {
        this.idarticle = idarticle;
        this.titre = titre;
        this.contenu = contenu;
        this.dateCreation = dateCreation;
        this.dateModification = dateModification;
        this.photo = photo;
        this.categorie = categorie;
    }

    public Article() {
    }

    public Long getIdarticle() {
        return idarticle;
    }

    public void setIdarticle(Long idarticle) {
        this.idarticle = idarticle;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDate getDateModification() {
        return dateModification;
    }

    public void setDateModification(LocalDate dateModification) {
        this.dateModification = dateModification;
    }

    public FichierDB getPhoto() {
        return photo;
    }

    public void setPhoto(FichierDB photo) {
        this.photo = photo;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
