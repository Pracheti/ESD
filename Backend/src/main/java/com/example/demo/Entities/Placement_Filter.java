package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="placement_filter")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Placement_Filter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="placement_filter_id")
    private int placement_filter_id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "placement_id", referencedColumnName = "placement_id")
    private Placement placement;

    @Column(name="specialisation")
    private String specialisation;

    @Column(name="domain")
    private String domain;
}
