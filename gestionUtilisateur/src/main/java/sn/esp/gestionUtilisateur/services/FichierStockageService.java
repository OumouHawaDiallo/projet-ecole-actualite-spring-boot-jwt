package sn.esp.gestionUtilisateur.services;

import org.springframework.web.multipart.MultipartFile;
import sn.esp.gestionUtilisateur.entities.FichierDB;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

public interface FichierStockageService {
    public FichierDB store(MultipartFile file) throws IOException;

    public FichierDB getFile(String id);

    public FichierDB getFileByNom(String id);

    public void deleteFile(String id);

    public Stream<FichierDB> getAllFiles();


    public Optional<FichierDB> getFileById(String id);
}
