package com.example.demo.Controller;

import com.example.demo.Entities.Login;
import com.example.demo.Entities.Students;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@CrossOrigin
@Controller
@RequestMapping(produces = "application/json")
public class LoginController {
    @Autowired
    private LoginService userService;
    @Autowired
    private StudentRepository studentRepository;

    /*@GetMapping("/login")
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new Login());
        return mav;
    }*/

    @PostMapping("/login")
    public ResponseEntity<Students> login(@RequestBody Login user){
        Login oauthUser = userService.login(user.getUsername(), user.getPassword());
        if (oauthUser != null) {
            System.out.println(oauthUser.getStudent().getStudent_id());
            Students s1 = studentRepository.getStudentsByStudent_id(oauthUser.getStudent().getStudent_id());
            System.out.println(s1);
            if (s1 != null) {
                // If the student is found, return it
                return ResponseEntity.ok(s1);
            } else {
                // If the student is not found, return a 404 response or handle accordingly
                return ResponseEntity.notFound().build();
            }
        } else {
            // If the login is not successful, return a 401 response or handle accordingly
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
