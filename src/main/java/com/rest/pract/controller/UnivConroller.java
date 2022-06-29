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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(description = "Контроллер для работы с Universe")
class UnivConroller {

    private final UniversCom universCom;

    public UnivConroller (UniversCom universCom){
        this.universCom = universCom;
    }

    @PostMapping(value="/universe")
    @ApiOperation("Добавление нового университета")
        Univers create(@RequestBody Univers univers) {   
            System.out.println(univers);
        UniversCom.save(univers);
        return univers;
    }

    @GetMapping(value = "/universe")
    @ApiOperation("Вывод списка всех университетов")
    public String index(Model model) {

        return UniversCom.index().toString();
    }
    @ApiOperation("Поиск университета по названию")
    @GetMapping(value = "/universe/{title}")
    public String show(@PathVariable("title") String title, Model model) {
        return UniversCom.show(title).toString();
    }  

}