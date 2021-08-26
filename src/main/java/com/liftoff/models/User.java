package com.liftoff.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class User extends AbstractEntity{


    @NotNull
    private String username;

    @NotNull
    private String pwHash;

    private Boolean disableUser;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();



    public enum AdminRights {
        USER,
        ADMIN,
        SUPER,
    }

    private AdminRights adminRights;

    public User(){}

    public User(String username, String password) {
        this.username = username;
        this.pwHash = encoder.encode(password);
    }


    public Boolean getDisableUser() {
        return disableUser;
    }

    public void setDisableUser(Boolean disable) {
        this.disableUser = disable;
    }

    public String getUsername() {
        return username;
    }

    public String getPwHash() {
        return pwHash;
    }

    public boolean isMatchingPassword(String password){
        return encoder.matches(password, pwHash);
    }


}