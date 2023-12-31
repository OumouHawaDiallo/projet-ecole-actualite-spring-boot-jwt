package sn.esp.gestionUtilisateur.controllers;

import com.google.common.net.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import sn.esp.gestionUtilisateur.entities.FichierDB;
import sn.esp.gestionUtilisateur.message.ReponseFichier;
import sn.esp.gestionUtilisateur.message.ReponseMessageFichier;
import sn.esp.gestionUtilisateur.services.FichierStockageService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@CrossOrigin("http://localhost:4200")
public class FichierController {

    @Autowired
    private FichierStockageService fichierStockageService;

    @PostMapping("/AjouterFichierById")
    public ResponseEntity<ReponseMessageFichier> AjouterFichierById(@RequestParam("fichier") MultipartFile fichier) {

        String message = "";
        try {


            message = fichierStockageService.store(fichier).getIdfichierdb();
            return ResponseEntity.status(HttpStatus.OK).body(new ReponseMessageFichier(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + fichier.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ReponseMessageFichier(message));
        }
    }

    @PostMapping("/AjouterFichier")
    public ResponseEntity<ReponseMessageFichier> uploadFile(@RequestParam("fichier") MultipartFile fichier) {
        String message = "";
        try {
            fichierStockageService.store(fichier);

            message = "Uploaded the file successfully: " + fichier.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ReponseMessageFichier(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + fichier.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ReponseMessageFichier(message));
        }
    }

    @PostMapping("/AjouterFichiers")
    public ResponseEntity<ReponseMessageFichier> uploadFiles(@RequestParam("fichiers") MultipartFile[] fichiers) {
        String message = "";
        try {
            for (MultipartFile fichier : fichiers) {
                fichierStockageService.store(fichier);
            }
            message = "Uploaded all files successfully.";
            return ResponseEntity.status(HttpStatus.OK).body(new ReponseMessageFichier(message));
        } catch (Exception e) {
            message = "Could not upload all files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ReponseMessageFichier(message));
        }
    }

    @GetMapping("/Fichiers")
    public ResponseEntity<List<ReponseFichier>> getListFiles() {
        List<ReponseFichier> files = fichierStockageService.getAllFiles().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/Fichier/")
                    .path(dbFile.getIdfichierdb())
                    .toUriString();

            return new ReponseFichier(
                    dbFile.getNom(),
                    fileDownloadUri,
                    dbFile.getType(),
                    dbFile.getdonnee().length);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/Fichier/{id}")
    public ResponseEntity<Resource> getFileById(@PathVariable String id) {
        FichierDB fichierDB = fichierStockageService.getFile(id);
        ByteArrayResource resource = new ByteArrayResource(fichierDB.getdonnee());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fichierDB.getIdfichierdb() + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }


//    @GetMapping("/Fichier/{id}")
//    public ResponseEntity<byte[]> getFileById(@PathVariable String id) {
//        FichierDB fichierDB = fichierStockageService.getFile(id);
//
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fichierDB.getIdfichierdb() + "\"")
//                .body(fichierDB.getdonnee());
//    }

//	@GetMapping("/FichierById/{id}")
//	@ResponseBody
//	public Optional<FichierDB> UtilisateurById(@PathVariable String id) {
//		Optional<FichierDB> fichierDB = fichierStockageService.getFileById(id);
//		return fichierDB;
//	}

    @GetMapping("/FichierById/{id}")
    @ResponseBody
    public Optional<FichierDB> UtilisateurById(@PathVariable String id) {
        Optional<FichierDB> fichierDB = fichierStockageService.getFileById(id);
        return fichierDB;
    }
}
