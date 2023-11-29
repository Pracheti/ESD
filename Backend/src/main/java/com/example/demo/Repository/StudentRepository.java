package com.example.demo.Repository;
import com.example.demo.DemoApplication;
import com.example.demo.Entities.Placement_Filter;
import com.example.demo.Entities.Students;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Students, Integer> {
    @Query("select s from students s where s.student_id=:sid")
    Students getStudentsByStudent_id(@Param("sid") Integer student_id);
}