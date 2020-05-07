package com.jboss.tutorial.repository;

import com.jboss.tutorial.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepo extends JpaRepository<Instructor, Long> {
    Instructor findByEmail(String email);
}
