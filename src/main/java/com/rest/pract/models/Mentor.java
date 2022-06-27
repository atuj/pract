package com.rest.pract.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmentor;

    public Integer getIdmentor() {
        return idmentor;
    }

    public void setIdmentor(Integer idmentor) {
        this.idmentor = idmentor;
    }

    private String firstname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    private String lastname;

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    private String patronimic;

    public String getPatronimic() {
        return patronimic;
    }

    public void setPatronimic(String patronimic) {
        this.patronimic = patronimic;
    }

    public Mentor(Integer idmentor,String firstname, String lastname,String patronimic) {
        this.idmentor = idmentor;
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronimic = patronimic;
    }

    @Override
    public String toString() {
        return "Mentor{" +
                "idmentor=" + idmentor +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", patronimic='" + patronimic + '\'' +
                '}';
    }

    public Mentor(){}
}
