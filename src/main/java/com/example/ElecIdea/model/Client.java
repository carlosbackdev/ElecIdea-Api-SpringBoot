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
@Table(name = "client")
@Data
public class Client {

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @Id
    @Column(name = "ID", nullable = false, unique = true)
    private String id;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CITY")
    private String city;

    @Column(name = "POSTAL")
    private String postal;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "NIF")
    private String nif;

    @Column(name = "DATE")
    private String date;

    public Client() {
    }

    @JsonCreator
    public Client(@JsonProperty("name") String name,
                  @JsonProperty("id") String id,
                  @JsonProperty("address") String address,
                  @JsonProperty("city") String city,
                  @JsonProperty("postal") String postal,
                  @JsonProperty("email") String email,
                  @JsonProperty("phone") String phone,
                  @JsonProperty("nif") String nif,
                  @JsonProperty("date") String date) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.city = city;
        this.postal = postal;
        this.email = email;
        this.phone = phone;
        this.nif = nif;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }
}
