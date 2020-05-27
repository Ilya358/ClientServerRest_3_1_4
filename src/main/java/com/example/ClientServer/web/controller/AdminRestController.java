package com.example.ClientServer.web.controller;

import com.example.ClientServer.web.model.Role;
import com.example.ClientServer.web.model.User;
import com.example.ClientServer.web.service.RoleService;
import com.example.ClientServer.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
public class AdminRestController {

    private final UserService userService;
    public final RoleService roleService;

    @Autowired
    public AdminRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/admin/userList")
    public List<User> getAllUsers() {
        return userService.listUsers();
    }

    @GetMapping(value = "/roleList")
    public List<Role> getAllRoles() {
        return roleService.roleList();
    }

    @GetMapping("/admin")
    public ModelAndView viewPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("adminPage");
        return model;
    }

    @GetMapping("/admin/addUser")
    public String getAddUser(Map<String, Object> model, ModelMap modelMap) {
        User user = new User();
        model.put("user", user);
        modelMap.addAttribute("roleList", roleService.roleList());
        return "addUser";
    }

    @PostMapping("/admin/submit")
    public User postAddUser(@RequestBody User user) {
        userService.add(user);
        return user;
    }

    @DeleteMapping("/admin/deleteUser/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

    @PutMapping("/admin/updateUser/{id}")
    public ResponseEntity updateUser(@PathVariable("id") Long id, ModelMap modelMap) {
        User user = userService.getUserById(id);
        modelMap.addAttribute("roleList", roleService.roleList());
        modelMap.addAttribute("user", user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/admin/save")
    public User saveUser(@RequestBody User user) {
        userService.updateUser(user);
        return userService.getUserById(user.getId());
    }

    @PostMapping("/get/name")
    public User getUserByName(@RequestBody String username) {
        return userService.getUserByName(username);
    }

    @GetMapping("/get/id/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/roles/name")
    public Role getRoleByName(@RequestBody String name) {
        return roleService.getRoleByName(name);
    }

    @GetMapping("/roles/id/{id}")
    public Role getRoleById(@PathVariable Long id) {
        return roleService.getById(id);
    }
}
