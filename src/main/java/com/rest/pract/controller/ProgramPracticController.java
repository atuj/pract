package com.rest.pract.controller;

import com.rest.pract.models.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

import com.rest.pract.component.ProgramPracticCom;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(description = "Контроллер для работы с PROGRAMPRACTIC")
class ProgramPracticController {

    private final ProgramPracticCom programPracticCom;
    public ProgramPracticController(ProgramPracticCom programPracticCom) {
        this.programPracticCom = programPracticCom;
    }

    @PostMapping(value="programpractic")
    @ApiOperation("Добавление новой программы практики")
    ProgramPractic create(@RequestBody ProgramPractic programPractic) {
        System.out.println(programPractic);
        ProgramPracticCom.save(programPractic);
        return programPractic;
    }

    @GetMapping(value = "/programpractic")
    @ApiOperation("Вывод всех программ")
    public String index(Model model) {
        //model.addAttribute("universe", );
        //return model.toString();
        return com.rest.pract.component.ProgramPracticCom.index().toString();
    }
    @DeleteMapping(value = "/proogrampractic/{id}")
    @ApiOperation("Удаление направления практики")
    public String delete(@PathVariable("id") int id, Model model) {
        return com.rest.pract.component.ProgramPracticCom.delete(id);
    }



}
