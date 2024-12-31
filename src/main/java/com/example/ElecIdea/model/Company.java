
package com.example.ElecIdea.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "company")
public class Company {
    
    @Column(nullable = false, unique = true)
    private String NAME;
    @NIF
    private String NIF;
    private String ADDRESS;
    private String POSTAL;
    private String CITY;
    @Column(nullable = false, unique = true)
    private String EMAIL;
    @Column(nullable = false, unique = true)
    private String PHONE;
    private String IBAN;
    private String ID_USER;
    private String CODE;
    // Getters and Setters
}