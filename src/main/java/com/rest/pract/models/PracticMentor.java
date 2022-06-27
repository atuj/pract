package com.rest.pract.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class PracticMentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_mentor;
    public Integer getId_mentor() {
        return id_mentor;
    }
    public void setId_mentor(Integer id_mentor) {
        this.id_mentor = id_mentor;
    }
    private Integer id_practice;
    public Integer getId_practice() {
        return id_practice;
    }
    public void setId_practice(Integer id_practice) {
        this.id_practice = id_practice;
    }
    public PracticMentor() {
    }
    public PracticMentor(Integer id_mentor, Integer id_practice) {
        this.id_mentor = id_mentor;
        this.id_practice = id_practice;
    }
    @Override
    public String toString() {
        return "{" +
                "idmentor=" + id_mentor +
                ", firstname='" + id_practice +
                '}';
    }
}
