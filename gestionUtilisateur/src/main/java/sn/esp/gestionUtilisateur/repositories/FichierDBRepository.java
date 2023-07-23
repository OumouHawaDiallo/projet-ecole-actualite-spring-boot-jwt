package sn.esp.gestionUtilisateur.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.esp.gestionUtilisateur.entities.FichierDB;

import java.util.Optional;

public interface FichierDBRepository extends JpaRepository<FichierDB, String> {
    FichierDB findByNom(String nom);

    //	FichierDB findByIdfichierdb(String id);
    Optional<FichierDB> findByIdfichierdb(String id);
}
