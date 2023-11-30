package com.example.demo.Repository;

import com.example.demo.Entities.Placement_Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlacementStudentRepository extends JpaRepository<Placement_Student, Integer> {

}
