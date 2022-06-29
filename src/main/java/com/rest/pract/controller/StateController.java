package com.rest.pract.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.rest.pract.component.StateCom;
import com.rest.pract.models.Statemen;

@RestController
@Api(description = "Контроллер для работы с STATE")
class StateController {
    
    @PostMapping(value="/state")
    @ApiOperation("Добавление новой заявки")
    Statemen create(@RequestBody Statemen statemen) {
        StateCom.save(statemen);
        return statemen;
    }
    
    @GetMapping(value = "/state")
    @ApiOperation("Вывод всех заявок")
    public String indexs() {
        return StateCom.index().toString();
    }
}