
package com.example.ElecIdea.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "company")
public class Company {
    
    @Column(name = "NAME",nullable = false, unique = true)
    private String name;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NIF",nullable = false, unique = true)
    private Long nif;
    
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNif() {
        return nif;
    }

    public void setNif(Long Nif) {
        this.nif = nif;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String Address) {
        this.address = address;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String Postal) {
        this.postal = postal;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String City) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String Phone) {
        this.phone = phone;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String Iban) {
        this.iban = iban;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String IdUser) {
        this.idUser = idUser;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String Code) {
        this.code = code;
    }
}
       
