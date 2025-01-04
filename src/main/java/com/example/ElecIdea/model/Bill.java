
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
@Table(name = "bill_standard")
@Data
public class Bill {
    
    @Column(numberfactura = "NUMBER_FACTURA")
    private String numberFactura;

    @Column(name = "ID_CLIENT")
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "HOUR")
    private String hour;

    @Column(name = "DATE")
    private String date;

    @Column(name = "NUMBER_MATERIAL")
    private String numberMaterial;

    @Column(name = "TOTAL_MATERIAL")
    private String totalMaterial;

    @Column(name = "PARAMETROS")
    private String parametros;
    
    @Column(name = "TOTAL_BILL")
    private String total;
    
    @Column(name = "NIF")
    private String nif;
    
    @Column(name = "STATUS")
    private String status;
    
    @Id
    @Column(name = "CODE")
    private String code;
    
    @Column(name = "NAME_PROJECT")
    private String nameProject;
    
    public Bill() {
    }
    
    
    @JsonCreator
    public Client(@JsonProperty("numberFactura") String numberFactura,
                  @JsonProperty("id") String id,
                  @JsonProperty("name") String name,
                  @JsonProperty("address") String address,
                  @JsonProperty("date") String date,
                  @JsonProperty("numberMaterial") String numberMaterial,
                  @JsonProperty("totalMaterial") String totalMaterial,
                  @JsonProperty("parametros") String parametros,
                  @JsonProperty("total") String total,
                  @JsonProperty("nif") String nif,
                  @JsonProperty("status") String status,
                  @JsonProperty("code") String code,
                  @JsonProperty("nameProject") String nameProject) {
        this.numberFactura = numberFactura;
        this.id = id;
        this.name = name;
        this.address = address;
        this.date = date;
        this.numberMaterial = numberMaterial;
        this.totalMaterial = totalMaterial;
        this.parametros = parametros;
        this.total = total;
        this.nif = nif;
        this.status = status;
        this.code = code;
        this.nameProject = nameProject;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }
    
}
