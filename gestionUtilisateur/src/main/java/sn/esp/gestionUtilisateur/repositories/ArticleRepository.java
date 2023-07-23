package sn.esp.gestionUtilisateur.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.esp.gestionUtilisateur.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
