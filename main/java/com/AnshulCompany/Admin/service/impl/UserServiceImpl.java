package com.AnshulCompany.Admin.service.impl;

import com.AnshulCompany.Admin.exception.ResourceNotFoundException;
import com.AnshulCompany.Admin.model.User;
import com.AnshulCompany.Admin.repository.UserRepository;
import com.AnshulCompany.Admin.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        // You might add validation or business logic here before saving
        // e.g., check if a user with the same name already exists
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String id) { // ID type is String
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    @Override
    public User updateUser(String id, User userDetails) { // ID type is String
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        // Update fields based on your User model
        user.setName(userDetails.getName());
        if (userDetails.getPassword() != null && !userDetails.getPassword().isEmpty()) {
            user.setPassword(userDetails.getPassword()); // In a real app, hash and update if provided
        }
        // ... set other fields if you add them later

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String id) { // ID type is String
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
}