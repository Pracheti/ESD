package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="login")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Login {

    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", unique = true, nullable = false)
    private Students student;

    @Id
    @Column(name="Username", unique = true, nullable = false)
    private String username;

    @Column(name="Password", nullable = false)
    private String password;
}
