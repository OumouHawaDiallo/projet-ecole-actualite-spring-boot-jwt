package sn.esp.gestionUtilisateur.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.esp.gestionUtilisateur.entities.ArticlePhoto;

public interface ArticlePhotoRepository extends JpaRepository<ArticlePhoto, Long> {
}
