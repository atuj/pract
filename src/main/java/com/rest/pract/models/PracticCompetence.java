package com.rest.pract.models;
import javax.persistence.*;
import java.util.Date;

@Entity
public class PracticCompetence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_competence;
    
    public Integer getId_competence() {
        return id_competence;
    }
    public void setId_competence(Integer id_competence) {
        this.id_competence = id_competence;
    }
    private Integer id_practice;
    public Integer getId_practice() {
        return id_practice;
    }
    public void setId_practice(Integer id_practice) {
        this.id_practice = id_practice;
    }
    public PracticCompetence() {
    }
    public PracticCompetence(Integer id_competence, Integer id_practice) {
        this.id_competence = id_competence;
        this.id_practice = id_practice;
    }
    @Override
    public String toString() {
        return "{" +
                "id_competence=" + id_competence +
                ", firstname='" + id_practice +
                '}';
    }
}