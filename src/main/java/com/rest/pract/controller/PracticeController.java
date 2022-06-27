package com.rest.pract.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.rest.pract.component.PracticeCom;
import com.rest.pract.models.Practice;


@RestController
class PracticeController {

    @RequestMapping("/practice")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    private final PracticeCom practiceCom;


    public PracticeController (PracticeCom practiceCom){
        this.practiceCom = practiceCom;
    }

    @PostMapping(value="/practice")
    Practice create(@RequestBody Practice practice) {
        System.out.println(practice);
        PracticeCom.save(practice);
        return practice;
    }

    @GetMapping(value = "/practice")
    public String index(Model model) {
        //model.addAttribute("universe", );
        //return model.toString();
        return com.rest.pract.component.PracticeCom.index().toString();
    }

    @GetMapping(value = "/practice/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        //model.addAttribute("universe", UniversCom.show(id));
        return com.rest.pract.component.PracticeCom.show(id).toString();
    }



}
