package com.rest.pract.controller;
import com.rest.pract.models.*;
import org.springframework.web.bind.annotation.RestController;

import com.rest.pract.component.PracticCompetenceCom;
import com.rest.pract.component.PracticMentorCom;
import com.rest.pract.component.StudentCom;
import com.rest.pract.component.UniversCom;

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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(description = "Контроллер для работы с PRACTICECOMPETENCE")
public class PracticeCompetenceController {
    private final PracticCompetenceCom practicCompetenceCom;

    public PracticeCompetenceController (PracticCompetenceCom practicCompetenceCom){
        this.practicCompetenceCom = practicCompetenceCom;
    }
    @PostMapping(value="/practicompetence")
    @ApiOperation("Присваиваем практиканту компетенции")
    PracticCompetence create(@RequestBody PracticCompetence practicCompetence) {
        PracticCompetenceCom.save(practicCompetence);
        return practicCompetence;
    }
    @PatchMapping("/practicompetence/{id}")
    @ApiOperation("Изменяем компетентность у практиканта через id практиканта")
    public String update(@ModelAttribute("practic") @Valid PracticCompetence practicCompetence, BindingResult bindingResult,@PathVariable("id") int id) {
        PracticCompetenceCom.update(id, practicCompetence);
        return "OK";
    }
}
