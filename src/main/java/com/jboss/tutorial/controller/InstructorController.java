package com.jboss.tutorial.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jboss.tutorial.model.Instructor;
import com.jboss.tutorial.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class InstructorController {
    @Autowired
    private InstructorService instructorService;

    @PostMapping("/instructor/create/account")
    public ResponseEntity<Instructor> createAccount(@Valid @RequestBody Instructor instructor) {
        try {
            instructorService.registerInstructor(instructor);
            return new ResponseEntity<>(instructor, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/fetch/instructors")
    public ResponseEntity<List<Instructor>> getInstructors(List<Instructor> instructors) {
        try {
            instructorService.fetchInstructors(instructors);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @GetMapping("/fetch/instructors/{id}")
    public Instructor getInstructor(@PathVariable long id) {
        return instructorService.fetchInstructor(id);
    }

    @GetMapping("/fetch/instructor/{email}")
    public Instructor getInstructorByEmail(@PathVariable String email) {
        return instructorService.fetchByEmail(email);
    }

    @PutMapping("/update/instructor/{id}")
    public Instructor editInstructor(@PathVariable Long id, @RequestBody Instructor instructor) {
        return instructorService.updateInstructor(id, instructor);
    }

    @DeleteMapping("/delete/instructor/{id}")
    public String removeInstructor(@PathVariable long id) {
        return instructorService.deleteInstructor(id);
    }

}
