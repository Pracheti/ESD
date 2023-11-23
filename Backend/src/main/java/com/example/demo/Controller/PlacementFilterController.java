package com.example.demo.Controller;

import com.example.demo.Entities.Placement_Filter;
import com.example.demo.Entities.Students;
import com.example.demo.Repository.PlacementFilter;
import com.example.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/offers")
public class PlacementFilterController{
    @Autowired
    private PlacementFilterRepository Repository;

    @GetMapping("/records")
    public ResponseEntity<Placement_Filter> getRecords(@RequestParam float min_grade, @RequestParam String spec, @RequestParam String dom) {
        Placement_Filter result = Repository.getRecords(min_grade, spec, dom);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}