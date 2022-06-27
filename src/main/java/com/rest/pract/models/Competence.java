package com.rest.pract.models;

import javax.persistence.*;

@Entity
public class Competence {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcompetence;
    public Integer getIdcompetence() {
        return idcompetence;
    }
    public void setIdcompetence(Integer idcompetence) {
        this.idcompetence = idcompetence;
    }
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private String value;
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public Competence(Integer idcompetence, String name, String value) {
        this.idcompetence = idcompetence;
        this.name = name;
        this.value = value;
    }
    public Competence() {
    }
    @Override
    public String toString() {
        return "{"+
        "idcompetence="+ idcompetence+
        " ,name="+name+
        " ,value="+value+"}";
    }
}
