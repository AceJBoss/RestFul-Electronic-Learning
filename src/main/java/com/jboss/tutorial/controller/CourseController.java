package com.jboss.tutorial.controller;

import com.jboss.tutorial.model.Course;
import com.jboss.tutorial.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/add/course")
    public ResponseEntity<Course> addCourse(@Valid @RequestBody Course course) {
        try {
            courseService.registerCourse(course);
            return new ResponseEntity<>(course, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/fetch/courses")
    public ResponseEntity<List<Course>> fetchCourse() {
        try {
            courseService.fetchCourses();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
