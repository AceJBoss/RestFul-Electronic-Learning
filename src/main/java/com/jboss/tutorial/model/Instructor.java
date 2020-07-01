package com.jboss.tutorial.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "*Please Enter your full name")
    @Column(name = "full_name")
    private String fullname;
    @NotEmpty(message = "*Please enter an email")
    private String email;
    @NotEmpty(message = "*Please enter your phone number")
    private String phone;
    @CreationTimestamp
    @Column(name = "created_at")
    private Date created_at;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updated_at;

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Course> courses;


}
