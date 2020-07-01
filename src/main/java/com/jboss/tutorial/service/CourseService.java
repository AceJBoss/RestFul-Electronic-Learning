package com.jboss.tutorial.service;

import com.jboss.tutorial.model.Course;
import com.jboss.tutorial.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepo courseRepo;

    public Course registerCourse(Course course) {
        return courseRepo.save(course);
    }

    public List<Course> fetchCourses() {
        return courseRepo.findAll();
    }

    public Course fetchCourse(long id) {
        return courseRepo.findById(id).orElse(null);
    }

    public Course updateCourse(Long id, Course course) {
        Course existingCourse = courseRepo.findById(id).orElse(null);
        existingCourse.setCourseName(course.getCourseName());
        existingCourse.setCourseDesc(course.getCourseDesc());
        existingCourse.setAmount(course.getAmount());
        return courseRepo.save(existingCourse);
    }

    public String deleteCourse(long id) {
        courseRepo.deleteById(id);
        return "Course successfully deleted " + id;
    }
}
