package com.rest.pract.controller;
import com.rest.pract.models.*;
import org.springframework.web.bind.annotation.RestController;

import com.rest.pract.component.StudentCom;
import com.rest.pract.component.UniversCom;
import com.rest.pract.models.Univers;

import antlr.collections.List;

import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
class StudentConroller {

    @RequestMapping("/teststudents")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    private final StudentCom studentCom;


    public StudentConroller (StudentCom studentCom){
        this.studentCom = studentCom;
    }

    @PostMapping(value="/student")
    Student create(@RequestBody Student student) {
        StudentCom.save(student);
        return student;
    }





    @GetMapping(value="/student")
    public void insertdata(@RequestParam Univers param) {

    }


}
