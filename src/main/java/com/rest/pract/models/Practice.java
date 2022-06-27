package com.rest.pract.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Practice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpractice;

    public Integer getIdpractice() {
        return idpractice;
    }

    public void setIdpractice(Integer idpractice) {
        this.idpractice = idpractice;
    }

    private Date datestart;

    public Date getDatestart() {
        return datestart;
    }

    public void setDatestart(Date datestart) {
        this.datestart = datestart;
    }

    private Date datefinish;

    public Date getDatefinish() {
        return datefinish;
    }

    public void setDatefinish(Date datefinish) {
        this.datefinish = datefinish;
    }
    private int id_student;

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }
    private int id_practicestatus;

    public int getId_practicestatus() {
        return id_practicestatus;
    }

    public void setId_practicestatus(int id_practicestatus) {
        this.id_practicestatus = id_practicestatus;
    }
    private int id_practicedirection;

    public void setId_practicedirection(int id_practicedirection) {
        this.id_practicedirection = id_practicedirection;
    }

    public int getId_practicedirection() {
        return id_practicedirection;
    }
    public Practice(int idpractice,Date datestart,Date datefinish,int id_student,int id_practicestatus,int id_practicedirection ){
        this.idpractice=idpractice;
        this.datestart=datestart;
        this.datefinish=datefinish;
        this.id_student = id_student;
        this.id_practicedirection = id_practicedirection;
        this.id_practicestatus=id_practicestatus;
    }

    @Override
    public String toString() {
        return "Practice{" +
                "idpractice=" + idpractice +
                ", datestart=" + datestart +
                ", datefinish=" + datefinish +
                ", id_student=" + id_student +
                ", id_practicestatus=" + id_practicestatus +
                ", id_practicedirection=" + id_practicedirection +
                '}';
    }
    public Practice(){}
}
