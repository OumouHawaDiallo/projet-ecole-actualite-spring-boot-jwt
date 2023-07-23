package sn.esp.gestionUtilisateur.enumeration;

import static sn.esp.gestionUtilisateur.constant.Authority.*;


public enum Role {
    ROLE_ADMIN(EDITER_ADMIN_AUTHORITIES),
    ROLE_SUPER_ADMIN(SUPER_ADMIN_AUTHORITIES);

    private String[] authorities;

    Role(String... authorities) {
        this.authorities = authorities;
    }

    public String[] getAuthorities() {
        return authorities;
    }
}
