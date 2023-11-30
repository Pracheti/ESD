package com.example.demo.Services;

import com.example.demo.Entities.Placement_Student;
import com.example.demo.Repository.PlacementStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferDetailsService {
    @Autowired
    private PlacementStudentRepository PSRepository;

    @Autowired
    public OfferDetailsService(PlacementStudentRepository PSRepository) {
        this.PSRepository = PSRepository;
    }
    public Placement_Student saveOfferDetails(Placement_Student placementStudent) {
        Placement_Student placement_student = new Placement_Student();
        return PSRepository.save(placementStudent);
    }
}
