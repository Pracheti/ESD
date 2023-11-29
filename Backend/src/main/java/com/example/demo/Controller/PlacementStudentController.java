package com.example.demo.Controller;

import com.example.demo.Entities.Placement_Filter;
import com.example.demo.Entities.Placement_Student;
import com.example.demo.Repository.PlacementStudentRepository;
import com.example.demo.Services.OfferDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RestController
@RequestMapping("/placement_student")
public class PlacementStudentController {
    @Autowired //Injecting repository interface/Service class
    private OfferDetailsService offerDetailsService;
    private PlacementStudentRepository PSRepository;

    @PostMapping("/add")
    public ResponseEntity<Placement_Student> saveOfferDetails(@RequestBody Placement_Student placementStudent){
        Placement_Student savedDetails;
        savedDetails = offerDetailsService.saveOfferDetails(placementStudent);
        //System.out.print(placementStudent.getComments());
        return ResponseEntity.ok(savedDetails);
    }
    /*public Placement_Student saveData(@RequestBody Placement_Student placementStudent){
        //Placement_Student savedDetails = OfferDetailsService.saveOfferDetails(placementStudent);
        return placementStudent;
    }*/
}
