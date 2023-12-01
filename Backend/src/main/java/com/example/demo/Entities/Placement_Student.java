package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name="placement_student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Placement_Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="placement_student_id")
    private int placement_student_id;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "placement_id")
    private Placement placement;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Students students;

    @Column(name="about")
    private String about;

    @Column(name="acceptance")
    private String acceptance="PENDING";

    @Column(name="comments")
    private String comments;

    @Column(name="date")
    private LocalDate date;

    @Lob
    @Column(name="file", columnDefinition = "LONGBLOB")
    private byte[] file;
}
