
package com.example.ElecIdea.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "login")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String USUARIO;
    private String NAME;
    private String PASSWORD;
    @Column(nullable = false, unique = true)
    private String USER;
    private String NIF;

}
