package com.AnshulCompany.Admin.controller;

import com.AnshulCompany.Admin.model.User;
import com.AnshulCompany.Admin.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // Read all
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Read by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) { // Changed ID type to String
        return userService.getUserById(id);
    }

    // Update
    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user) { // Changed ID type to String
        return userService.updateUser(id, user);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) { // Changed ID type to String
        userService.deleteUser(id);
    }
}