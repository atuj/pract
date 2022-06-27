package com.rest.pract.models;

import javax.persistence.*;

@Entity
public class PracticeStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idstatus;
    public Integer getIdstatus() {
        return idstatus;
    }
    public void setIdstatus(Integer idstatus) {
        this.idstatus = idstatus;
    }
    private String description;
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    private String assessment;
    public String getAssessment() {
        return assessment;
    }
    public void setAssessment(String assessment) {
        this.assessment = assessment;
    }
    private String value;
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public PracticeStatus(Integer idstatus, String description, String assessment, String value) {
        this.idstatus = idstatus;
        this.description = description;
        this.assessment = assessment;
        this.value = value;
    }
    public PracticeStatus() {
    }
    @Override
    public String toString() {
        return "{"+
        "idstatus="+ idstatus+
        " ,description="+description+
        " ,assessment="+assessment+
        " ,value="+value+"}";
    }
}
