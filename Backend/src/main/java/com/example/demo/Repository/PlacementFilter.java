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
public interface PlacementFilter extends JpaRepository<Placement_Filter>{
    @Query("SELECT p FROM placement p join placement_filter pf on p.placement_id=pf.placement_id WHERE p.minimum_grade =: grade AND pf.specialization = : spec AND lastName AND pf.domain = : dom")
    Placement_Filter getRecords(
            @Param("grade") float min_grade,
            @Param("specialization") String spec,
            @Param("domain") String dom
    );
}
