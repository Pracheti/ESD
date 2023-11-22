package com.example.demo.Entities;

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
    private int id;

    @Column(name="organization")
    private String organization;

    @Column(name="profile", nullable = false)
    private String profile;

    @Column(name="description")
    private String description;

    @Column(name="intake", nullable = false)
    private int intake;

    @Column(name="minimum_grade")
    private String minimum_grade;

    @OneToMany(mappedBy = "placement")
    private Set<Placement_Filter> PlacementFil;

    @OneToMany(mappedBy = "placement") /*cascade = CascadeType.ALL, orphanRemoval = true*/
    private Set<Placement_Student> PlacementStu;

}
