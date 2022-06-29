package com.rest.pract.controller;
import com.rest.pract.models.*;
import org.springframework.web.bind.annotation.RestController;

import com.rest.pract.component.StudentCom;
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
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(description = "Контроллер для работы с STUDENT")
class StudentConroller {

    private final StudentCom studentCom;


    public StudentConroller (StudentCom studentCom){
        this.studentCom = studentCom;
    }

    @PostMapping(value="/student")
    @ApiOperation("Добавление нового студента")
    Student create(@RequestBody Student student) {
        studentCom.save(student);
        return student;
    }

    @GetMapping(value = "/student")
    @ApiOperation("Вывод всех студентов")
    public String indexs() {
        return studentCom.index().toString();
    }

    @GetMapping(value = "/student/{id}")
    @ApiOperation("Поиск студента по id")
    public String show(@PathVariable("id") int id) {
        return studentCom.show(id).toString();
    }
    @PatchMapping("/student/{id}")
    @ApiOperation("Обновление информации о студенте по id")
    public String update(@ModelAttribute("student") @Valid Student student, BindingResult bindingResult,@PathVariable("id") int id) {
        studentCom.update(id, student);
        return "OK";
    }
    @DeleteMapping("/{id}")
    @ApiOperation("Удаление студента по id")
    public String delete(@PathVariable("id") int id) {
        studentCom.delete(id);
        return "OK deletes";
    }
}
