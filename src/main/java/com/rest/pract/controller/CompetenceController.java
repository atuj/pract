package com.rest.pract.controller;
import com.rest.pract.models.*;
import org.springframework.web.bind.annotation.RestController;

import com.rest.pract.component.CompetenceCom;
import com.rest.pract.component.StudentCom;
import com.rest.pract.component.UniversCom;
import com.rest.pract.models.Univers;

import antlr.collections.List;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
@Api(description = "Контроллер для работы с COMPETENCE")
public class CompetenceController {

    private final CompetenceCom competenceCom;

    public CompetenceController(CompetenceCom competenceCom) {
        this.competenceCom = competenceCom;
    }

    @PostMapping(value="/competence")
    @ApiOperation("Добавление новой компетенции")
    Competence create(@RequestBody Competence competence) {
        CompetenceCom.save(competence);
        return competence;
    }
}

