package com.kavach.kavach_backend.controller;

import com.kavach.kavach_backend.model.User;
import com.kavach.kavach_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/{phone}")
    public User getUser(@PathVariable String phone) {
        return userService.getUserByPhone(phone);
    }
}
