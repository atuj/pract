package com.rest.pract.controller;

import com.rest.pract.models.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

import com.rest.pract.component.MentorCom;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@Api(description = "Контроллер для работы с DMENTOR")
class MentorController {

    private final MentorCom mentorCom;


    public MentorController (MentorCom mentorCom){
        this.mentorCom = mentorCom;
    }
    
    @PostMapping(value="/dmentor")
    @ApiOperation("Добавление нового наставника")
    Mentor create(@RequestBody Mentor mentor) {
        System.out.println(mentor);
        MentorCom.save(mentor);
        return mentor;
    }
    
    @GetMapping(value = "/dmentor")
    @ApiOperation("Получение списка всех наставников")
    public String index(Model model) {
        //model.addAttribute("universe", );
        //return model.toString();
        return MentorCom.index().toString();
    }
    @DeleteMapping(value = "/dmentor/{id}")
    @ApiOperation("Удалене наставника")
    public String delete(@PathVariable("id") int id, Model model) {
        return MentorCom.delete(id);
    }

    @GetMapping(value = "/dmentor/{id}")
    @ApiOperation("Получение наставника по ID")
    public String show(@PathVariable("id") int id, Model model) {
        //model.addAttribute("universe", UniversCom.show(id));
        return MentorCom.show(id).toString();
    }


}
