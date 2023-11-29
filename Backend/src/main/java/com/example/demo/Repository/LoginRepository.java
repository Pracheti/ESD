package com.example.demo.Repository;

import com.example.demo.Entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Integer> {
    Login findByUsernameAndPassword(String Username, String Password);
}
