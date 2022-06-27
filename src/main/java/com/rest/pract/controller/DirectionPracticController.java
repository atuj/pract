package com.rest.pract.controller;

import com.rest.pract.models.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

import com.rest.pract.component.DirectionPracticCom;
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


@RestController
class DirectionPracticController {

    @RequestMapping("/directionpractic")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    private final DirectionPracticCom directionPracticCom;


    public DirectionPracticController(DirectionPracticCom directionPracticCom) {
        this.directionPracticCom = directionPracticCom;
    }


    @PostMapping(value="/directionpractic")
    DirectionPractic create(@RequestBody DirectionPractic directionPractic) {
        System.out.println(directionPractic);
        DirectionPracticCom.save(directionPractic);
        return directionPractic;
    }

    @GetMapping(value = "/directionpractic")
    public String index(Model model) {
        //model.addAttribute("universe", );
        //return model.toString();
        return com.rest.pract.component.DirectionPracticCom.index().toString();
    }
    @DeleteMapping(value = "/directionpractic/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        return com.rest.pract.component.DirectionPracticCom.delete(id);
    }


}