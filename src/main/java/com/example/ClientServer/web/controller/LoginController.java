package com.example.ClientServer.web.controller;

import com.example.ClientServer.web.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
class LoginController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("login")
    public String loginPage() {
        return "login";
    }
}
