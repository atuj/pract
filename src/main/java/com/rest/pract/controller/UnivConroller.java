package com.rest.pract.controller;
import com.rest.pract.models.*;
import org.springframework.web.bind.annotation.RestController;

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
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
class UnivConroller {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    private final UniversCom universCom;
    //private final UniversRepository repository;

    //public UnivConroller(UniversRepository repository){
    //    this.repository = repository;
    //}

    public UnivConroller (UniversCom universCom){
        this.universCom = universCom;
    }

    //Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id)
    @PostMapping(value="/universe")
    //Univers create(@ModelAttribute("univers") @Valid Univers univers, BindingResult bindingResult) {
        Univers create(@RequestBody Univers univers) {   
            System.out.println(univers);
        UniversCom.save(univers);
        return univers;
    }

    @GetMapping(value = "/universe")
    public String index(Model model) {
        //model.addAttribute("universe", );
        //return model.toString();
        return UniversCom.index().toString();
    }
    
    @GetMapping(value = "/universe/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        //model.addAttribute("universe", UniversCom.show(id));
        return UniversCom.show(id).toString();
    }  

}