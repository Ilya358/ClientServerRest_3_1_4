package com.example.ClientServer.web.controller;

import com.example.ClientServer.web.model.User;
import com.example.ClientServer.web.service.UserServiceImpl;
import lombok.ToString;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@ToString
public class UserRestController {

    private final UserServiceImpl userService;

    public UserRestController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/user/info")
    public ResponseEntity userPage() {
        ModelMap model = new ModelMap();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return ResponseEntity.ok(model);
    }

    @GetMapping("/user")
    public ModelAndView viewPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("userPage");
        return model;
    }

    @PostMapping("/get/email")
    public User validEmail(@RequestBody String email) {
        if (email != null) {
            return (User) userService.getUserByEmail(email);
        } else {
            return null;
        }
    }
}
