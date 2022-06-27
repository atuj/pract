package com.rest.pract.models;

import javax.persistence.*;


@Entity
public class DirectionPractic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddirection;

    public void setIddirection(Integer iddirection) {
        this.iddirection = iddirection;
    }

    public Integer getIddirection() {
        return iddirection;
    }
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    private String description;

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    private int id_program;

    public void setId_program(int id_program) {
        this.id_program = id_program;
    }

    public int getId_program() {
        return id_program;
    }

    @Override
    public String toString() {
        return "DirectionPractic{" +
                "iddirection=" + iddirection +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id_program=" + id_program +
                '}';
    }
    public DirectionPractic(){}
    public DirectionPractic(int iddirection,String name,String description,int id_program){
        this.iddirection=iddirection;
        this.name=name;
        this.description=description;
        this.id_program=id_program;
    }
}
