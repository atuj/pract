package com.rest.pract.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ProgramPractic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idprogram;

    public Integer getIdprogram() {
        return idprogram;
    }

    public void setIdprogram(Integer idprogram) {
        this.idprogram = idprogram;
    }

    private String ts;

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProgramPractic(int idprogram,String ts,String description){
        this.idprogram=idprogram;
        this.ts = ts;
        this.description=description;
    }
    @Override
    public String toString() {
        return "ProgramPractic{" +
                "idprogram=" + idprogram +
                ", ts='" + ts + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
    public ProgramPractic(){};
}
