package com.jboss.tutorial.service;

import com.jboss.tutorial.model.Instructor;
import com.jboss.tutorial.repository.InstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepo instructorRepo;

    public Instructor registerInstructor(Instructor instructor) {
        return instructorRepo.save(instructor);
    }

    public List<Instructor> fetchInstructors(List<Instructor> instructorList) {
        return instructorRepo.findAll();
    }

    public Instructor fetchInstructor(long id) {
        return instructorRepo.findById(id).orElse(null);
    }

    public Instructor updateInstructor(Long id, Instructor instructor) {
        Instructor existingInstructor = instructorRepo.findById(id).orElse(null);
        existingInstructor.setFullname(instructor.getFullname());
        existingInstructor.setEmail(instructor.getEmail());
        existingInstructor.setPhone(instructor.getPhone());

        return instructorRepo.save(existingInstructor);
    }

    public String deleteInstructor(long id) {
        instructorRepo.deleteById(id);
        return "Instructor deleted " + id;
    }

    public Instructor fetchByEmail(String email) {
        return instructorRepo.findByEmail(email);
    }
}
