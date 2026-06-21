package com.kavach.kavach_backend.service;

import com.kavach.kavach_backend.model.User;
import com.kavach.kavach_backend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User getUserByPhone(String phone) {
        return userRepository.findByPhone(phone);
    }
}