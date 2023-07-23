package sn.esp.gestionUtilisateur.constant;

public class Authority {

    public static final String[] EDITER_ADMIN_AUTHORITIES = {
            "article:read", "article:create", "article:update", "article:delete",
            "categorie:read", "categorie:create", "categorie:update", "categorie:delete"
    };

    public static final String[] SUPER_ADMIN_AUTHORITIES = {
            "user:read", "user:create", "user:update", "user:delete",
            "article:read", "article:create", "article:update", "article:delete",
            "categorie:read", "categorie:create", "categorie:update", "categorie:delete"
    };
}