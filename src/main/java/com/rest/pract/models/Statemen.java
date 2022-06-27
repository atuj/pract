package com.rest.pract.models;

import javax.persistence.*;

@Entity
public class Statemen {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idstate;
    public Integer getIdstate() {
        return idstate;
    }
    public void setIdstate(Integer idstate) {
        this.idstate = idstate;
    }
    private String balue;
    public String getBalue() {
        return balue;
    }
    public void setBalue(String balue) {
        this.balue = balue;
    }
    private String description;
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Statemen(Integer idstate, String balue, String description) {
        this.idstate = idstate;
        this.balue = balue;
        this.description = description;
    }
    public Statemen() {
    }
    @Override
    public String toString() {
        return "{"+
        "idstate="+ idstate+
        " ,balue="+balue+
        " ,description="+description+"}";
    }

}
