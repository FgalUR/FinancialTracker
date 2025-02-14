package com.iqcorp.financialtracker.controllers;

import com.iqcorp.financialtracker.models.User;
import com.iqcorp.financialtracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @PutMapping("/users")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
