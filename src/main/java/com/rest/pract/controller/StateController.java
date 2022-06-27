package com.rest.pract.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.pract.component.StateCom;
import com.rest.pract.models.Statemen;

@RestController
class StateController {
    
    @PostMapping(value="/state")
    Statemen create(@RequestBody Statemen statemen) {
        StateCom.save(statemen);
        return statemen;
    }

    @GetMapping(value = "/state")
    public String indexs() {
        return StateCom.index().toString();
    }
}