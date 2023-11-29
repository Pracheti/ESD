package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Entity(name="students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="student_id")
    private int student_id;

    @Column(name="roll_number", unique = true, nullable = false)
    private int roll_number;

    @Column(name="first_name", nullable = false)
    private String first_name;

    @Column(name="last_name")
    private String last_name;

    @Column(name="email", unique = true, nullable = false)
    private String email;

    @Column(name="photograph_path")
    private String photograph_path;

    @Column(name="cgpa", nullable = false, columnDefinition = "FLOAT DEFAULT 0.0")
    private float cgpa;

    @Column(name="total_credits", nullable = false)
    private int total_credits;

    @Column(name="graduation_year")
    private int graduation_year;

    @Column(name="domain")
    private String domain;

    @Column(name="specialisation")
    private String specialisation;

    //@Column(name="placement_id")
    //private int placement_id;

    @JsonBackReference(value="user-person3")
    @OneToMany(mappedBy = "students")
    private Set<Placement_Student> placementstudent;

    @OneToOne(mappedBy = "student")
    private Login login;
}
