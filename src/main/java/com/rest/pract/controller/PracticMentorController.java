package com.rest.pract.controller;
import com.rest.pract.models.*;
import org.springframework.web.bind.annotation.RestController;

import com.rest.pract.component.PracticMentorCom;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class PracticMentorController {
    private final PracticMentorCom practicMentorCom;


    public PracticMentorController (PracticMentorCom practicMentorCom){
        this.practicMentorCom = practicMentorCom;
    }

    @PostMapping(value="/practicmentor")
    PracticMentor create(@RequestBody PracticMentor practicMentor) {
        PracticMentorCom.save(practicMentor);
        return practicMentor;
    }
    @PatchMapping("/practicmentor/{id}")
    public String update(@ModelAttribute("practic") @Valid PracticMentor practicMentor, BindingResult bindingResult,@PathVariable("id") int id) {
        PracticMentorCom.update(id, practicMentor);
        return "OK";
    }
}
