package com.jboss.tutorial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private long id;
    @NotEmpty(message = "*Please enter course name")
    @Column(name = "course_name")
    private String courseName;
    @NotEmpty(message = "*Please enter course description")
    @Column(name = "course_desc")
    private String courseDesc;
    private double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "instructor_id"))
    private Instructor instructor;
}
