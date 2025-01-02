
package com.example.ElecIdea.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;


@Entity
@Table(name = "company")
@Data

public class Company {
    @Column(name = "NAME",nullable = false, unique = true)
    private String name;
    
    @Id
    @Column(name = "NIF",nullable = false, unique = true)
    private String nif;
    
    @Column(name = "ADDRESS")
    private String address;
    
    @Column(name = "POSTAL")
    private String postal;
    
    @Column(name = "CITY")
    private String city;
    
    @Column(name = "EMAIL",nullable = false, unique = true)
    private String email;
    
    @Column(name = "PHONE",nullable = false, unique = true)
    private String phone;
    
     @Column(name = "IBAN")
    private String iban;
     
      @Column(name = "ID_USER")
    private String idUser;
      
       @Column(name = "CODE")
    private String code;
    
    public Company() {
    }
    
    @JsonCreator
    public Company(@JsonProperty("name") String name,
                   @JsonProperty("nif") String nif,
                   @JsonProperty("email") String email,
                   @JsonProperty("iban") String iban,
                   @JsonProperty("address") String address,
                   @JsonProperty("postal") String postal,
                   @JsonProperty("city") String city,
                   @JsonProperty("phone") String phone,
                   @JsonProperty("idUser") String idUser,
                   @JsonProperty("code") String code) {
        this.name = name;
        this.nif = nif;
        this.email = email;
        this.iban = iban;
        this.address = address;
        this.postal = postal;
        this.city = city;
        this.phone = phone;
        this.idUser = idUser;
        this.code = code;
    }
}
       
