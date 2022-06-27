package com.rest.pract.models;

import java.sql.Date;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idstudent;

    public Integer getIdstudent() {
        return idstudent;
    }

    public void setIdstudent(Integer idstudent) {
        this.idstudent = idstudent;
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

    private Date dateofbirth;

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String phone;

    public String getPhone() {
        return city;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    private Integer id_university;

    public Integer getId_university() {
        return id_university;
    }

    public void setId_university(Integer id_university) {
        this.id_university = id_university;
    }
    private Integer id_statement;

    public Integer getId_statement() {
        return id_statement;
    }

    public void setId_statement(Integer id_statement) {
        this.id_statement = id_statement;
    }

    public Student(Integer idstudent,String firstname, String lastname,String patronimic,Date dateofbirth,
                   String gender,String city,String email,String phone,Integer id_university,Integer id_statement){
        this.idstudent=idstudent;
        this.gender=gender;
        this.phone = phone;
        this.city = city;
        this.email=email;
        this.dateofbirth=dateofbirth;
        this.firstname=firstname;
        this.lastname=lastname;
        this.patronimic=patronimic;
        this.id_statement=id_statement;
        this.id_university=id_university;
    }
    public Student(){}
}
