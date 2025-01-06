
package com.example.ElecIdea.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

@Entity
@Table(name = "material_bill")
@Data
public class Material {
    
    @Column(name = "ID_CLIENT")
    private String id;
    
    @Column(name = "NUMBER")
    private String number;

    @Column(name = "NAME")
    private String name;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "PRICE")
    private String price;

    @Column(name = "UNIT")
    private String unit;

    @Column(name = "REF")
    private String ref;

    @Column(name = "DATE")
    private String date;

    @Column(name = "TOTAL_PRICE")
    private String total;
    
    @Column(name = "NIF")
    private String nif;
    
    @Id
    @Column(name = "CODE")
    private String code;  
    
    public Material() {
    }
    
    @JsonCreator
    public Material(@JsonProperty("id") String id,
                  @JsonProperty("number") String number,
                  @JsonProperty("name") String name,
                  @JsonProperty("brand") String brand,
                  @JsonProperty("price") String price,
                  @JsonProperty("unit") String unit,
                  @JsonProperty("ref") String ref,
                  @JsonProperty("date") String date,
                  @JsonProperty("total") String total,
                  @JsonProperty("nif") String nif,
                  @JsonProperty("code") String code) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.unit = unit;
        this.ref = ref;
        this.date = date;
        this.total = total;
        this.nif = nif;
        this.code = code;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }

}
