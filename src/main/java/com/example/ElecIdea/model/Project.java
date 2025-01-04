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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;


@Entity
@Table(name = "save_project")
@Data
public class Project {

    @Id
    @Column(name = "NAME", nullable = false, unique = true)
    private String name;
    
    @Column(name = "TYPE")
    private String type;

    @Column(name = "INFO")
    private String info;

    @Column(name = "NIF")
    private String nif;

    @Column(name = "ID_CLIENT")
    private String id;

    @Column(name = "DATE")
    private String date;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID", insertable = false, updatable = false)
    private Client client;  

    public Project() {
    }

    @JsonCreator
    public Project(@JsonProperty("name") String name,
                  @JsonProperty("type") String type,
                  @JsonProperty("info") String info,
                  @JsonProperty("nif") String nif,
                  @JsonProperty("id") String id,
                  @JsonProperty("date") String date) {
        this.name = name;
        this.type = type;
        this.info = info;
        this.nif = nif;
        this.id = id;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }
}
