package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Entity(name="placement")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Placement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="placement_id")
    private int placement_id;

    @Column(name="organization")
    private String organization;

    @Column(name="profile", nullable = false)
    private String profile;

    @Column(name="description")
    private String description;

    @Column(name="intake", nullable = false)
    private int intake;

    @Column(name="minimum_grade")
    private Float minimum_grade;

    @JsonBackReference(value="user-person")
    @OneToMany(mappedBy = "placement", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Placement_Filter> PlacementFil;

    @JsonBackReference(value="user-person1")
    @OneToMany(mappedBy = "placement", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Placement_Student> PlacementStu;

}
