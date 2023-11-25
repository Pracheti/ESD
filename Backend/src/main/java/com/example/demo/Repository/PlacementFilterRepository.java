package com.example.demo.Repository;
import com.example.demo.Entities.Placement_Filter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlacementFilterRepository extends JpaRepository<Placement_Filter, Integer>{
    //@Query("SELECT p FROM placement_filter pf join placement p on p.placement_id=pf.placement.placement_id WHERE pf.placement.minimum_grade>=:minimum_grade AND pf.specialisation=:specialisation AND pf.domain=:domain")
    @Query("SELECT pf FROM placement_filter pf WHERE pf.placement.minimum_grade<=:minimum_grade AND pf.specialisation=:specialisation AND pf.domain=:domain")
    List<Placement_Filter> getRecords(
            @Param("minimum_grade") Float grade,
            @Param("specialisation") String spec,
            @Param("domain") String dom
    );
}
