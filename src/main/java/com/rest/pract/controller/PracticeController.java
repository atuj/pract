package com.rest.pract.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.rest.pract.component.PracticeCom;
import com.rest.pract.models.Practice;


@RestController
@Api(description = "Контроллер для работы с PRACTICE")
class PracticeController {

    private final PracticeCom practiceCom;

    public PracticeController (PracticeCom practiceCom){
        this.practiceCom = practiceCom;
    }

    @PostMapping(value="/practice")
    @ApiOperation("Добавление нового практиканта")
    Practice create(@RequestBody Practice practice) {
        System.out.println(practice);
        PracticeCom.save(practice);
        return practice;
    }

    @GetMapping(value = "/practice")
    @ApiOperation("Вывод всех практикантов")
    public String index(Model model) {
        //model.addAttribute("universe", );
        //return model.toString();
        return com.rest.pract.component.PracticeCom.index().toString();
    }

    @GetMapping(value = "/practice/{id}")
    @ApiOperation("Поиск практиканта по id")
    public String show(@PathVariable("id") int id, Model model) {
        //model.addAttribute("universe", UniversCom.show(id));
        return com.rest.pract.component.PracticeCom.show(id).toString();
    }



}
