package com.rest.pract.models;

import javax.persistence.*;

@Entity
public class Univers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iduniv;
    public Integer getIduniv() {
        return iduniv;
    }
    public void setIduniv(Integer iduniv) {
        this.iduniv = iduniv;
    }
    private String title;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    private Integer course;
    public Integer getCourse() {
        return course;
    }
    public void setCourse(Integer course) {
        this.course = course;
    }
    private String faculty;
    public String getFaculty() {
        return faculty;
    }
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
    private String specialty;
    public Univers(Integer iduniv, String title, Integer course, String faculty, String specialty) {
        this.iduniv = iduniv;
        this.title = title;
        this.course = course;
        this.faculty = faculty;
        this.specialty = specialty;
    }
    public String getSpecialty() {
        return specialty;
    }
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    public Univers(String title, Integer course, String faculty, String specialty) {
        this.title = title;
        this.course = course;
        this.faculty = faculty;
        this.specialty = specialty;
    }
    public Univers() {
    }
    @Override
    public String toString() {
        return "Univers{"+
        "id="+ iduniv+
        " ,title="+title+
        " ,course="+course+
        " ,faculty="+faculty+
        " ,speciality="+specialty+"}";
    }
}
