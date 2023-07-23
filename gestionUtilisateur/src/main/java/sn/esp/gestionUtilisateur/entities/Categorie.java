package sn.esp.gestionUtilisateur.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "categorie")
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcategorie")
    private Long  idcategorie;

    private String libelle;

    private String description;

    public Categorie(Long idcategorie, String libelle, String description) {
        this.idcategorie = idcategorie;
        this.libelle = libelle;
        this.description = description;
    }

    public Categorie() {
    }

    public Long getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(Long idcategorie) {
        this.idcategorie = idcategorie;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
