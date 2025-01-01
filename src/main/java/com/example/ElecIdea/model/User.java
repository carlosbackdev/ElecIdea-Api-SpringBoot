package com.example.ElecIdea.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

@Entity
@Table(name = "login")
@Data
public class User {
    @Id
    @Column(name = "ID", nullable = false, unique = true)
    private String id;

    @Column(name = "USUARIO")
    private String usuario;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "USER", nullable = false, unique = true)
    private String user;

    @Column(name = "NIF")
    private String nif;

    public User() {
    }

    @JsonCreator
    public User(@JsonProperty("id") String id,
                @JsonProperty("usuario") String usuario,
                @JsonProperty("name") String name,
                @JsonProperty("password") String password,
                @JsonProperty("user") String user,
                @JsonProperty("nif") String nif) {
        this.id = id;
        this.usuario = usuario;
        this.name = name;
        this.password = password;
        this.user = user;
        this.nif = nif;
    }
}
