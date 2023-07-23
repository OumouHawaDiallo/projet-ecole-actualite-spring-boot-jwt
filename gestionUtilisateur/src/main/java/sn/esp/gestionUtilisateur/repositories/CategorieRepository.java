package sn.esp.gestionUtilisateur.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.esp.gestionUtilisateur.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}
