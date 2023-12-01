package com.example.demo.Controller;

import com.example.demo.Entities.Placement;
import com.example.demo.Entities.Placement_Filter;
import com.example.demo.Entities.Placement_Student;
import com.example.demo.Entities.Students;
import com.example.demo.Repository.PlacementRepository;
import com.example.demo.Repository.PlacementStudentRepository;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.Services.OfferDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

@Controller
@CrossOrigin
@RestController
@RequestMapping("/placement_student")
public class PlacementStudentController {
    @Autowired //Injecting repository interface/Service class
    private OfferDetailsService offerDetailsService;
    @Autowired
    private PlacementRepository placementRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private PlacementStudentRepository PSRepository;

    @PostMapping("/add")
    public ResponseEntity<String> handleFileUpload(
            @RequestParam("file") MultipartFile file,
            @RequestParam("about") String about,
            @RequestParam("acceptance") String acceptance,
            @RequestParam("comments") String comments,
            @RequestParam("date") LocalDate date,
            @RequestParam("placement_id") int placementId,
            @RequestParam("student_id") int studentId) throws IOException {

        Placement placement = placementRepository.findById(placementId)
                .orElseThrow(() -> new RuntimeException("Placement not found with ID: " + placementId));

        Students student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + studentId));


        Placement_Student savedDetails = new Placement_Student();
        savedDetails.setFile(file.getBytes());
        savedDetails.setAbout(about);
        savedDetails.setAcceptance(acceptance);
        savedDetails.setComments(comments);
        savedDetails.setDate(date);
        savedDetails.setPlacement(placement);
        savedDetails.setStudents(student);
        PSRepository.save(savedDetails);

        return ResponseEntity.ok("File uploaded successfully");
    }
}
