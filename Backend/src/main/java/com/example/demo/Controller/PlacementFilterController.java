package com.example.demo.Controller;

import com.example.demo.Entities.Placement;
import com.example.demo.Entities.Placement_Filter;
import com.example.demo.Entities.Students;
import com.example.demo.Entities.Test;
import com.example.demo.Repository.PlacementFilterRepository;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.Response.OffersQuery;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RestController
@RequestMapping("/offers")
public class PlacementFilterController{
    @Autowired
    private PlacementFilterRepository PFRepository;

    @GetMapping("/{grade}/{spec}/{dom}")
    /*public ResponseEntity<List<Placement_Filter>> getRecords(@PathVariable Float grade, @PathVariable String spec, @PathVariable String dom) {
        List<Placement_Filter> result = PFRepository.getRecords(grade, spec, dom);
        if(result.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        System.out.println(result);
        //List<Placement_Filter> result = PFRepository.getPlacement_FiltersByDomainAndSpecialisation(dom, spec);
        //List<Placement_Filter> result = PFRepository.findAllByInnerJoin();
        //System.out.println("Placement ID: " + result.getFirst().getPlacement().getPlacement_id());

        return new ResponseEntity<List<Placement_Filter>>(result, HttpStatus.OK);
    }*/
    public List<OffersQuery> findAllWithInnerJoin(@PathVariable Float grade, @PathVariable String spec, @PathVariable String dom) {
        return PFRepository.findAllWithInnerJoin(grade, spec, dom);
    }
}