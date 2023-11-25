package com.example.demo.Controller;

import com.example.demo.Entities.Placement_Filter;
import com.example.demo.Entities.Students;
import com.example.demo.Repository.PlacementFilterRepository;
import com.example.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/offers")
public class PlacementFilterController{
    @Autowired
    private PlacementFilterRepository PFRepository;

    @GetMapping("/{grade}/{spec}/{dom}")
    public ResponseEntity<List<Placement_Filter>> getRecords(@PathVariable Float grade, @PathVariable String spec, @PathVariable String dom) {
        List<Placement_Filter> result = PFRepository.getRecords(grade, spec, dom);
        if(result.size()<=0){
            System.out.println("Reached");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        System.out.println(result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}