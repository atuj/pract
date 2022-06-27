package com.rest.pract.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.pract.component.PracticeStatusCom;
import com.rest.pract.models.PracticeStatus;

@RestController
public class PracticStatusController {


    private final PracticeStatusCom practiceStatusCom;


    public PracticStatusController(PracticeStatusCom practiceStatusCom) {
        this.practiceStatusCom = practiceStatusCom;
    }

    @PostMapping(value="/practstatus")
    PracticeStatus create(@RequestBody PracticeStatus practiceStatus) {
        practiceStatusCom.save(practiceStatus);
        return practiceStatus;
    }

    @PatchMapping("/practstatus/{id}")
    public String update(@ModelAttribute("practiceStatus") @Valid PracticeStatus practiceStatus, BindingResult bindingResult,@PathVariable("id") int id) {
        practiceStatusCom.update(id, practiceStatus);
        return "OK";
    }
    
}
