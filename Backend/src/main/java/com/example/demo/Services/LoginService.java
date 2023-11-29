package com.example.demo.Services;

import com.example.demo.Entities.Login;
import com.example.demo.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    public Login login(String Username, String Password){
        Login user = loginRepository.findByUsernameAndPassword(Username, Password);
        return user;
    }
}
