package com.jboss.tutorial.repository;

import com.jboss.tutorial.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepo extends JpaRepository<Course, Long> {
    List<Course> findByInstructorId(Long instructorId);
}
